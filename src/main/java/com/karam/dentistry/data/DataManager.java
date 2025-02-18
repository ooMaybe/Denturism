/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author karam
 */
public class DataManager {
    
    private Connection conn;
    
    private ArrayList<Patient> patients;
    
    public DataManager(){
        patients = new ArrayList<>();
        init();
    }
    
    /*
    
    My code from other projects
    
    */
    private void init(){
        try {
            if (!connected()) {
                File databaseFile = new File(System.getProperty("user.dir") + "/data/main.db");
                if (!databaseFile.exists()){
                    databaseFile.getParentFile().mkdirs();
                    databaseFile.createNewFile();
                }
                
                String url = "jdbc:sqlite:" + databaseFile.getAbsolutePath();
                conn = DriverManager.getConnection(url);
                conn.setAutoCommit(true);
                System.out.println("Connection to SQLLite has been established.");
                
                query(QueryType.POST,
                        "CREATE TABLE IF NOT EXISTS patients("
                        + " uid PRIMARY KEY,"
                        // Personal Information
                        + " firstName TEXT,"
                        + " lastName TEXT,"
                        + " dob TEXT,"
                        + " gender TEXT,"
                        + " nationality TEXT,"
                        + " citizenship TEXT,"
                        + " email TEXT,"
                        // Address
                        + " address TEXT,"
                        + " city TEXT,"
                        + " streetNumber TEXT,"
                        + " province TEXT,"
                        + " postalCode TEXT,"
                        + " phoneNumber TEXT,"
                        // Insurance
                        + " insuranceCompany TEXT,"
                        + " insuranceEmployer TEXT,"
                        + " insuranceIdNumber TEXT,"
                        + " insuranceTelephone TEXT)");
                System.out.println("Sucessfully created the patients table.");
                
                load();
            }
        } catch (Exception e) {
            System.out.println("Failed to load mysql: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean connected() {
        try {
            if (conn == null || conn.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed to check if mysql is connected: " + e.getMessage());
        }
        return true;
    }
    
    private void load(){
        try {
            String loadingQuery = "SELECT * FROM patients;";
            
            ResultSet result = (ResultSet) query(QueryType.RESULT_SET, loadingQuery);
            while (result.next()){
                Patient patient = new Patient(UUID.fromString(result.getString("uid")));
                
                patient.setFirstName(result.getString("firstName"));
                patient.setLastName(result.getString("lastName"));
                patient.setDob(result.getString("dob"));
                patient.setGender(result.getString("gender"));
                patient.setNationality(result.getString("nationality"));
                patient.setCitizenship(result.getString("citizenship"));
                patient.setEmail(result.getString("email"));
                
                // address
                patient.setAddress(result.getString("address"));
                patient.setCity(result.getString("city"));
                patient.setStreetNumber(result.getString("streetNumber"));
                patient.setProvince(result.getString("province"));
                patient.setPostalCode(result.getString("postalCode"));
                patient.setPhoneNumber(result.getString("phoneNumber"));
                
                // insurance
                patient.setCompanyName(result.getString("insuranceCompany"));
                patient.setEmployer(result.getString("insuranceEmployer"));
                patient.setIdNumber(result.getString("insuranceIdNumber"));
                patient.setCompanyTelephone(result.getString("insuranceTelephone"));
                
                patients.add(patient);
                System.out.println("Loading patient uid=" + result.getString("uid"));
            }
            
            //  do another query for appointments
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to load patients database!", "Error!", JOptionPane.OK_OPTION);
            ex.printStackTrace();
        }
    }
    
    public void insertPatient(Patient patient) {
        String query = "INSERT INTO patients (" +
                "uid, firstName, lastName, dob, gender, nationality, citizenship, email, " +
                "address, city, streetNumber, province, postalCode, phoneNumber, " +
                "insuranceCompany, insuranceEmployer, insuranceIdNumber, insuranceTelephone" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, patient.getUid().toString()); // UID as UUID
            pst.setString(2, patient.getFirstName());
            pst.setString(3, patient.getLastName());
            pst.setString(4, patient.getDob());
            pst.setString(5, patient.getGender());
            pst.setString(6, patient.getNationality());
            pst.setString(7, patient.getCitizenship());
            pst.setString(8, patient.getEmail());
            pst.setString(9, patient.getAddress());
            pst.setString(10, patient.getCity());
            pst.setString(11, patient.getStreetNumber());
            pst.setString(12, patient.getProvince());
            pst.setString(13, patient.getPostalCode());
            pst.setString(14, patient.getPhoneNumber());
            pst.setString(15, patient.getCompanyName());
            pst.setString(16, patient.getEmployer());
            pst.setString(17, patient.getIdNumber());
            pst.setString(18, patient.getCompanyTelephone());

            pst.executeUpdate();
            patients.add(patient);
            System.out.println("Patient record inserted successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Object query(QueryType type, String query) {
        try {
            if (type == QueryType.GET) {
                PreparedStatement pst = this.conn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                String[] column_split = query.split(" ");
                String column = column_split[1];
                if (rs.next()) {
                    rs.getString(column);
                } else {
                    return null;
                }
            } else if (type == QueryType.RESULT_SET) {
                PreparedStatement pst = this.conn.prepareStatement(query);
                return pst.executeQuery();
            } else if (type == QueryType.POST) {
                PreparedStatement pst = this.conn.prepareStatement(query);
                pst.executeUpdate();
                return null;
            }else{
                // TODO: make this print something so that it looks cleaner and prevents accidentals
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Patient getPatientByFullName(String fullName){
        return getPatients().stream()
                .filter(p -> p.getFirstName().equals(fullName.split(" ")[0])) // Since fullName is a full patient name like "Jane Doe", it splits it into a string array {"Jane", "Doe"} and it grabs the first elemment 
                .filter(p -> p.getLastName().equals(fullName.split(" ")[1]))
                .findFirst().orElse(null); // grabs the first available patient from the list otherwise returrn a null
    }
    
    public Patient getPatientByID(String ID){
        return getPatients().stream()
                .filter(p -> p.getUid().toString().equals(ID))
                .findFirst().orElse(null);
    }
    
    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
