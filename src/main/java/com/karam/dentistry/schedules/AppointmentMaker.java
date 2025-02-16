/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.karam.dentistry.schedules;

import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import com.karam.dentistry.schedules.appointments.Appointment;
import com.karam.dentistry.schedules.appointments.AppointmentType;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author karam
 */
public class AppointmentMaker extends javax.swing.JFrame {

    /**
     * Creates new form AppointmentMaker
     */
    public AppointmentMaker() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        loadAppointments();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelAppointment = new javax.swing.JButton();
        saveAppointmentButton = new javax.swing.JButton();
        patientSelector = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        appointmentTypeSelector = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelAppointment.setText("Cancel Appointment");
        cancelAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelAppointmentMouseClicked(evt);
            }
        });

        saveAppointmentButton.setText("Save Appointment");
        saveAppointmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveAppointmentButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Appointment Type");

        jLabel2.setText("Patient Selector");

        notesArea.setColumns(20);
        notesArea.setRows(5);
        jScrollPane1.setViewportView(notesArea);

        jLabel3.setText("Additional Notes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveAppointmentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelAppointment))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(patientSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 143, Short.MAX_VALUE))
                            .addComponent(appointmentTypeSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appointmentTypeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAppointment)
                    .addComponent(saveAppointmentButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAppointmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAppointmentButtonMouseClicked
        if (patientSelector.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "You do not have any patients selected! Please begin by adding a new patient.", "Error!", JOptionPane.OK_OPTION);
            return;
        }
        
        String patientName = patientSelector.getSelectedItem().toString();
        Patient patient = Main.getInstance().getDataManager().getPatientByFullName(patientName);
        
        if (patient == null){
            JOptionPane.showMessageDialog(null, "Either you do not have any patients in your database or that one could not be found.", "Error!", JOptionPane.OK_OPTION);
            return;
        }
        
        AppointmentType appointmentType = AppointmentType.find(appointmentTypeSelector.getSelectedItem().toString());
        String additionalNotes = notesArea.getText();
        
        Appointment appointment = new Appointment(patient.getUid(), appointmentType, additionalNotes);
        Main.getInstance().getAppointmentManager().addAppointment(appointment);
        
        try{
            JOptionPane.showMessageDialog(null, "Sucessfully added the appointment uid=" + patient.getUid(), "Sucess!", JOptionPane.OK_OPTION);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Failed to add the appointment uid=" + patient.getUid(), "Error!", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveAppointmentButtonMouseClicked

    private void cancelAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelAppointmentMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelAppointmentMouseClicked

    public void loadAppointments(){
        patientSelector.removeAllItems();
        for (Patient patient : Main.getInstance().getDataManager().getPatients()){
            patientSelector.addItem(patient.getFirstName() + " " + patient.getLastName());
        }
        
        appointmentTypeSelector.removeAllItems();
        for (AppointmentType type : AppointmentType.values()){
            appointmentTypeSelector.addItem(type.toString().replace("_", " ") + " - " + type.getColor());
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> appointmentTypeSelector;
    private javax.swing.JButton cancelAppointment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea notesArea;
    private javax.swing.JComboBox<String> patientSelector;
    private javax.swing.JButton saveAppointmentButton;
    // End of variables declaration//GEN-END:variables
}
