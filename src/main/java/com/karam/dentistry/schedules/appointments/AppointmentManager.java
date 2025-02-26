/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import com.karam.dentistry.data.QueryType;
import com.karam.dentistry.schedules.Schedule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author karam
 */
public class AppointmentManager {
    
    private List<Appointment> appointments;
    
    public AppointmentManager(){
        appointments = new ArrayList<>();
    }
    
    public void addAppointment(Appointment appointment){
        Schedule schedule = Main.getInstance().getSchedule();
        Object value = schedule.getCalender().getCalendarTable().getValueAt(schedule.getLastSelectedRow(), schedule.getLastSelectedColumn());
        if (value == null || value.toString().length() == 0){
            JOptionPane.showMessageDialog(Main.getInstance(), "You must select a valid day in the calendar!", "Error!", JOptionPane.OK_OPTION);
            return;
        }

        Main.getInstance().getDataManager().addAppointmentToDatabase(appointment);
        Main.getInstance().getSchedule().updateAppointmentPanel(Main.getInstance().getSchedule().getCalender().getCalendarObject(), value);
    }
    
    public void removeAppointment(String appointmentId){
        
    }
    
    public List<Appointment> getAppointmentsForDay(Calendar foreignCalendarr, String rawData){
        Calendar localCalendar = (Calendar) foreignCalendarr.clone();
        
        String dayStr = rawData.replaceAll("<[^>]+>", "").trim(); 
        int day;
        try {
            day = Integer.parseInt(dayStr);
        } catch (NumberFormatException ex) {
            System.err.println("Unable to parse day from value: " + rawData);
            return new ArrayList<>(); // return an empty list if parsing fails.
        }
        
        List<Appointment> condensedList = new ArrayList<Appointment>();
        for (Appointment appt : appointments){
            Calendar apptCalendar = Calendar.getInstance();
            apptCalendar.setTime(appt.getAppointmentDate());

            if (apptCalendar.get(Calendar.MONTH) == localCalendar.get(Calendar.MONTH) &&
                    apptCalendar.get(Calendar.YEAR) == localCalendar.get(Calendar.YEAR) && 
                    apptCalendar.get(Calendar.DAY_OF_MONTH) == day){
                condensedList.add(appt);
            }
        }
        
        List<Appointment> sortedList = sortByTime(condensedList);
        System.out.println("Found " + sortedList.size() + " appointments for day " + day);     
        return sortedList;
    }
    
    public Appointment getAppointment(String appointmentID){
        return appointments.stream().filter(app -> app.getAppointmentID().equals(appointmentID)).findFirst().orElse(null);
    }
    
    public List<Appointment> getAppointmentsFor(Patient patient){
       return appointments.stream()
               .filter(appt -> appt.getPatientID().equals(patient.getUid().toString()))
               .sorted(Comparator.comparing(Appointment::getAppointmentDate))
               .collect(Collectors.toList());
    }
    
    private List<Appointment> sortByTime(List<Appointment> appointments){
        return appointments.stream().sorted(Comparator.comparing(Appointment::getStartingTime)).toList();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void remove(String appointmentId) {
        try{
            int rows = (Integer) Main.getInstance().getDataManager().query(QueryType.POST, "DELETE FROM appointments WHERE apptId=?", appointmentId);           
            if (rows < 0){
                JOptionPane.showMessageDialog(Main.getInstance(), "Failed to remove the appointment id=" + appointmentId + " from the database!", "Error!", JOptionPane.OK_OPTION);
                return;
            }
            
            boolean removed = appointments.removeIf(appt -> appt.getAppointmentID().equals(appointmentId));
            if (removed) {
                JOptionPane.showMessageDialog(Main.getInstance(), "Sucessfully removed the appointment " + appointmentId + "from the list!", "Success!", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(Main.getInstance(), "Failed to remove the appointment from the list id=" + appointmentId, "Error!", JOptionPane.OK_OPTION);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Main.getInstance(), "Failed to remove the appointment id=" + appointmentId, "Error!", JOptionPane.OK_OPTION);
        }
    }
    
}
