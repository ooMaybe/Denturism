/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import com.karam.dentistry.schedules.Schedule;
import java.util.ArrayList;
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
        Main.getInstance().getSchedule().updateCurrentAppointments(value);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
    
}
