/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import com.karam.dentistry.data.Patient;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

import java.util.UUID;

/**
 *
 * @author karam
 */
public class Appointment {
    
    private String appointmentID;
    private String patientID;
    private Date appointmentDate;
    private AppointmentType type;
    private String additionalNotes;
    private Duration duration;
    private LocalTime startingTime;
    private LocalTime endingTime;
    
    public Appointment(UUID patientID, Date appointmentDate, AppointmentType type, String additionalNotes, LocalTime startingTime, LocalTime endingTime){
        this.appointmentID = UUID.randomUUID().toString();
        this.patientID = patientID.toString();
        this.appointmentDate = appointmentDate;
        this.type = type;
        this.additionalNotes = additionalNotes;
        this.duration = Duration.between(startingTime, endingTime);
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentType getType() {
        return type;
    }

    public void setType(AppointmentType type) {
        this.type = type;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
    
    public Duration getDuration() {
        return duration;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }
    
    public String[] convertToDatabaseFormat(){
        String[] stringBuilder = new String[];
        stringBuilder[0] = "a";
        
    }
    
    public static Appointment fromDatabaseFormatToAppointment(String[] data){
        
    }
    
}
