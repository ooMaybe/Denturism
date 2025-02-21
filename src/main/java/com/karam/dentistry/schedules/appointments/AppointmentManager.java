/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import com.karam.dentistry.schedules.Schedule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
            JOptionPane.showMessageDialog(null, "You must select a valid day in the calendar!", "Error!", JOptionPane.OK_OPTION);
            return;
        }
        
        appointments.add(appointment);
        System.out.println("ADDED");
       // Main.getInstance().getSchedule().updateCalendarCellToAppointments();
       // NOT IDEAL BUT  FOR NOW ITS OK
        //Main.getInstance().getSchedule().getCalender().format();
        Main.getInstance().getDataManager().addAppointmentToDatabase(appointment);
        Main.getInstance().getSchedule().updateAppointmentPanel(Main.getInstance().getSchedule().getCalender().getCalendarObject(), value);
    }
    
    public List<Appointment> getAppointmentsForDay(Calendar foreignCalendarr, Object value){
        Calendar localCalendar = (Calendar) foreignCalendarr.clone();

        String rawValue = value.toString();
        String dayStr = rawValue.replaceAll("<[^>]+>", "").trim();
        int day;
        try {
            day = Integer.parseInt(dayStr);
        } catch (NumberFormatException ex) {
            System.err.println("Unable to parse day from value: " + rawValue);
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
        return sortByTime(condensedList);
    }
    
    private List<Appointment> sortByTime(List<Appointment> appointments){
        return appointments.stream().sorted(Comparator.comparing(Appointment::getStartingTime)).toList();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
    
}
