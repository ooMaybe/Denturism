/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.customer;

import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import com.karam.dentistry.schedules.Schedule;
import com.karam.dentistry.schedules.appointments.Appointment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author karam
 */
public class CustomerManager {
    private List<Patient> patients;
    
    public CustomerManager(){
        patients = new ArrayList<>();
    }
    
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    
    public Patient getPatientByFullName(String fullName){
        String[] splitName = fullName.split(" ");
        for (Patient patient : patients){
            if (patient.getFirstName().equalsIgnoreCase(splitName[0]) && patient.getLastName().equalsIgnoreCase(splitName[1])){
                return patient;
            }
        }
        return null;
    }
    
    public Patient getPatientByID(String ID){
        return getPatients().stream()
                .filter(p -> p.getUid().toString().equals(ID))
                .findFirst().orElse(null);
    }
    
    public List<Patient> getPatients() {
        return patients;
    }
}
