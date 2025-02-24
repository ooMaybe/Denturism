/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.karam.dentistry.schedules;

import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import com.karam.dentistry.schedules.appointments.Appointment;
import java.util.Calendar;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Karam
 */
public class Schedule extends javax.swing.JPanel {

    /**
     * Creates new form Schedule
     */
    
    private Calender calender;
    private int lastSelectedRow = -1;
    private int lastSelectedColumn = -1;
    
    private AppointmentMaker appMaker;
    
    public Schedule() {
        initComponents();
        this.removeAll();
        this.add(calender = new Calender()); // adds it to panel and instantiates at the same time.
        this.repaint();
        this.revalidate();
        this.appointmentsList.setListData(new String[0]);
        this.appointmentsList.addListSelectionListener(event -> {
            // prevents more than one event calling
            if (!event.getValueIsAdjusting()){
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        addAppointmentButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        appointmentsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentsList = new javax.swing.JList<>();
        calender1 = new com.karam.dentistry.schedules.Calender();

        jButton1.setText("REMOVE APPOINTMENT");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        printButton.setText("PRINT SCHEDULE");
        printButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addAppointmentButton.setText("ADD APPOINTMENT");
        addAppointmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAppointmentButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAppointmentButton)
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addGap(116, 116, 116)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton)
                    .addComponent(jButton1)
                    .addComponent(addAppointmentButton))
                .addContainerGap())
        );

        appointmentsPanel.setBackground(new java.awt.Color(30, 30, 30));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("CURRENT APPOINTMENTS");

        appointmentsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        appointmentsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(appointmentsList);

        javax.swing.GroupLayout appointmentsPanelLayout = new javax.swing.GroupLayout(appointmentsPanel);
        appointmentsPanel.setLayout(appointmentsPanelLayout);
        appointmentsPanelLayout.setHorizontalGroup(
            appointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentsPanelLayout.createSequentialGroup()
                .addGroup(appointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appointmentsPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                    .addGroup(appointmentsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        appointmentsPanelLayout.setVerticalGroup(
            appointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentsPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appointmentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appointmentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calender1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(calender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calender1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addAppointmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAppointmentButtonMouseClicked
        if (getLastSelectedRow() == -1 || getLastSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "You must select a valid cell!", "Error!", JOptionPane.OK_OPTION);
            return;
        }
        
        Object value = calender.getCalendarTable().getValueAt(getLastSelectedRow(), getLastSelectedColumn());
        if (value == null || value.toString().length() == 0){
            JOptionPane.showMessageDialog(this, "You must select a valid day!", "Error!", JOptionPane.OK_OPTION);
            return;
        }
        
        appMaker = new AppointmentMaker();
        appMaker.setVisible(true);
        appMaker.toFront();
        appMaker.setAlwaysOnTop(false);
    }//GEN-LAST:event_addAppointmentButtonMouseClicked

    public void updateCalendarCellToAppointments(){
        
    }
    
    public void updateAppointmentPanel(Calendar calendar, Object value){
        if (value == null || value.toString().length() == 0){
            return;
        }
        
        this.appointmentsList.setListData(new String[0]);
        String data = value.toString();       
        List<Appointment> appointments = Main.getInstance().getAppointmentManager().getAppointmentsForDay(calendar, data);
        if (appointments.isEmpty()){
            return;
        }
        
        String[] appointmentsToAdd = new String[appointments.size()];
        for (int i = 0; i < appointments.size(); i++){
            Appointment appt = appointments.get(i);
            Patient patient = Main.getInstance().getCustomerManager().getPatientByID(appt.getPatientID());
            String builder = "•";
            builder += patient.getFirstName() + " " + patient.getLastName();
            builder += " @ " + appt.getStartingTime().getHour() + ":" + appt.getEndingTime().getMinute(); 
            builder += " for " + appt.getType().name();
            appointmentsToAdd[i] = builder;
        }
        
        this.appointmentsList.setListData(appointmentsToAdd);
    }

    public int getLastSelectedRow() {
        return lastSelectedRow;
    }

    public int getLastSelectedColumn() {
        return lastSelectedColumn;
    }
    
    private boolean calendarCellSelected(){
        return getLastSelectedRow() == -1 && getLastSelectedColumn() == -1;
    }

    public void setLastSelectedRow(int lastSelectedRow) {
        this.lastSelectedRow = lastSelectedRow;
    }

    public void setLastSelectedColumn(int lastSelectedColumn) {
        this.lastSelectedColumn = lastSelectedColumn;
    }

    public Calender getCalender() {
        return calender;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAppointmentButton;
    private javax.swing.JList<String> appointmentsList;
    private javax.swing.JPanel appointmentsPanel;
    private com.karam.dentistry.schedules.Calender calender1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
}
