/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.data;

import com.karam.dentistry.Main;
import com.karam.dentistry.schedules.appointments.Appointment;
import com.karam.dentistry.utilities.ImageUtils;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author karam
 */
public class DataManager {
    
    private Connection conn;
    
    public DataManager(){
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
                        + " profilePicture BLOB,"        
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
                
                query(QueryType.POST, 
                        "CREATE TABLE IF NOT EXISTS appointments("
                        + " apptID PRIMARY KEY,"
                        + " patientID TEXT,"
                        + " appointmentDate TEXT,"
                        + " appointmentType TEXT,"
                        + " additionalNotes TEXT,"
                        + " duration TEXT,"
                        + " startingTime TEXT,"
                        + " endingTime TEXT)");
                System.out.println("Sucessfully created the appointments table.");
                
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
            String patientLoadingQuery = "SELECT * FROM patients;";
            
            ResultSet patientResult = (ResultSet) query(QueryType.RESULT_SET, patientLoadingQuery);
            while (patientResult.next()){
                Patient patient = new Patient(UUID.fromString(patientResult.getString("uid")));
                
                patient.setFirstName(patientResult.getString("firstName"));
                patient.setLastName(patientResult.getString("lastName"));
                patient.setDob(patientResult.getString("dob"));
                patient.setGender(patientResult.getString("gender"));
                patient.setNationality(patientResult.getString("nationality"));
                patient.setCitizenship(patientResult.getString("citizenship"));
                patient.setEmail(patientResult.getString("email"));
                
                // image converrsion
                byte[] imageData = patientResult.getBytes("profilePicture");
                Image image = ImageUtils.bytesToImage(imageData);
                patient.setProfilePicture(image);
                
                // address
                patient.setAddress(patientResult.getString("address"));
                patient.setCity(patientResult.getString("city"));
                patient.setStreetNumber(patientResult.getString("streetNumber"));
                patient.setProvince(patientResult.getString("province"));
                patient.setPostalCode(patientResult.getString("postalCode"));
                patient.setPhoneNumber(patientResult.getString("phoneNumber"));
                
                // insurance
                patient.setCompanyName(patientResult.getString("insuranceCompany"));
                patient.setEmployer(patientResult.getString("insuranceEmployer"));
                patient.setIdNumber(patientResult.getString("insuranceIdNumber"));
                patient.setCompanyTelephone(patientResult.getString("insuranceTelephone"));
                
                Main.getInstance().getCustomerManager().addPatient(patient);
                System.out.println("Loaded the patient uid=" + patientResult.getString("uid"));
            }
            
            //  do another query for appointments
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to load patients database!", "Error!", JOptionPane.OK_OPTION);
            ex.printStackTrace();
        }
    }
    
    public void addAppointmentToDatabase(Appointment appointment){
        String query = "INSERT INTO appointments ("
                + "apptID, patientID, appointmentDate, appointmentType, additionalNotes, duration, startingTime, endingTime) VALUES ("
                + "?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            String[] serializedData = appointment.convertToDatabaseFormat();
            
            int rowsAffected = (Integer) query(QueryType.POST, query,
                    serializedData[0],
                    serializedData[1],
                    serializedData[2],
                    serializedData[3],
                    serializedData[4],
                    serializedData[5],
                    serializedData[6],
                    serializedData[7]);
            
            if (rowsAffected > 0){ 
                Main.getInstance().getAppointmentManager().getAppointments().add(appointment);
                JOptionPane.showMessageDialog(null, "Sucessfully inserted the appointment id=" + appointment.getAppointmentID(), "Sucess!", JOptionPane.OK_OPTION);
                System.out.println("Appointment record inserted successfully!");
            }else{
                JOptionPane.showMessageDialog(null, "Failed to insert the appointment id=" + appointment.getAppointmentID(), "Error!", JOptionPane.OK_OPTION);
                System.out.println("Failed to insert the appointment with the id=" + appointment.getAppointmentID());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void addPatientToDatabase(Patient patient) {
        String query = "INSERT INTO patients (" +
                "uid, firstName, lastName, dob, gender, nationality, citizenship, email, profilePicture," +
                "address, city, streetNumber, province, postalCode, phoneNumber, " +
                "insuranceCompany, insuranceEmployer, insuranceIdNumber, insuranceTelephone" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int rowsAffected = (Integer) query(QueryType.POST, query,
            patient.getUid().toString(),
            patient.getFirstName(),
            patient.getLastName(),
            patient.getDob(),
            patient.getGender(),
            patient.getNationality(),
            patient.getCitizenship(),
            patient.getEmail(),
            
            //  converts from IMAGE to BLOB
            ImageUtils.ImageToBytes(patient.getProfilePicture()),
            
            patient.getAddress(),
            patient.getCity(),
            patient.getStreetNumber(),
            patient.getProvince(),
            patient.getPostalCode(),
            patient.getPhoneNumber(),
            patient.getCompanyName(),
            patient.getEmployer(),
            patient.getIdNumber(),
            patient.getCompanyTelephone());
            
        if (rowsAffected > 0 ){ // SQL returns the number of rows that was affected during query. Having a number > 0 means that rows were changes and there was an update
            Main.getInstance().getCustomerManager().addPatient(patient);
            JOptionPane.showMessageDialog(null, "Successfully inserted the patient id=" + patient.getUid(), "Success!", JOptionPane.OK_OPTION);
            System.out.println("Patient record inserted successfully!");
        }else{
             JOptionPane.showMessageDialog(null, "Failed to insert the patient id=" + patient.getUid(), "Error!", JOptionPane.OK_OPTION);
            System.out.println("Failed to insert the patient with the id=" + patient.getUid());
        }
    }
    
    // main method for doing any commands to the database. uses an organized and condensed method that can be used frrom
    public Object query(QueryType type, String query, Object... params) {
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
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
                int rowsAffected = pst.executeUpdate();
                return rowsAffected;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
