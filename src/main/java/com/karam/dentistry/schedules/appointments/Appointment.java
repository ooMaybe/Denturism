/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import com.karam.dentistry.data.Patient;
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
    
    public Appointment(UUID patientID, Date appointmentDate, AppointmentType type, String additionalNotes){
        this.appointmentID = UUID.randomUUID().toString();
        this.patientID = patientID.toString();
        this.appointmentDate = appointmentDate;
        this.type = type;
        this.additionalNotes = additionalNotes;
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
    
}
