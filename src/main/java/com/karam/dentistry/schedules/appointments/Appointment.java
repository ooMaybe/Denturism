/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import com.karam.dentistry.data.Patient;
import java.text.SimpleDateFormat;
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
    
    public Appointment(UUID appointmentID){
        this.appointmentID = appointmentID.toString();
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
    
    public void setDuration(){
        this.duration = Duration.between(startingTime, endingTime);
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }
    
    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }
    
    public String[] convertToDatabaseFormat(){
        String[] stringBuilder = new String[8];
        stringBuilder[0] = this.appointmentID;
        stringBuilder[1] = this.patientID;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        // format the date into a string format that can later be unstringified
        stringBuilder[2] = sdf.format(this.appointmentDate); 
        stringBuilder[3] = this.type.name();
        stringBuilder[4] = this.additionalNotes;
        
        // converts the local times into a string
        stringBuilder[6] = this.startingTime.toString(); 
        stringBuilder[7] = this.endingTime.toString();
        
        setDuration();
        
        // this might seem counter intuitive  because of the numbers however it must be last because duration is only set after starrting time and ending time is done
        // converts duration into minutes so that similar to appointment date, itt can be unstringified later.
        stringBuilder[5] = String.valueOf(this.duration.toMinutes());
        return stringBuilder;
    }
    
}
