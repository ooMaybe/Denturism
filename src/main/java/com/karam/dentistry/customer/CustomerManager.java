/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.customer;

import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import com.karam.dentistry.data.QueryType;
import com.karam.dentistry.schedules.Schedule;
import com.karam.dentistry.schedules.appointments.Appointment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
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

    public void remove(UUID patientID) {
        try{
            int rows = (Integer) Main.getInstance().getDataManager().query(QueryType.POST, "DELETE FROM patients WHERE uid=?", patientID);           
            if (rows < 0){
                JOptionPane.showMessageDialog(Main.getInstance(), "Failed to remove the patient id=" + patientID + " from the database!", "Error!", JOptionPane.OK_OPTION);
                return;
            }
            
            boolean removed = patients.removeIf(appt -> appt.getUid().equals(patientID));
            if (removed) {
                Main.getInstance().executeButton(0);
                JOptionPane.showMessageDialog(Main.getInstance(), "Sucessfully remove the patient " + patientID + "from the list!", "Success!", JOptionPane.OK_OPTION);  
            } else {
                JOptionPane.showMessageDialog(Main.getInstance(), "Failed to remove the patient from the list id=" + patientID, "Error!", JOptionPane.OK_OPTION);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Main.getInstance(), "Failed to remove the patient id=" + patientID, "Error!", JOptionPane.OK_OPTION);
        }
    }
}
