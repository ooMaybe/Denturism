/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.karam.dentistry.customer;

import com.karam.dentistry.customer.table.TableActionCellRender;
import com.karam.dentistry.customer.table.TableActionEvent;
import com.karam.dentistry.customer.table.TableActionCellEditor;
import com.karam.dentistry.Main;
import com.karam.dentistry.data.Patient;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karam
 */
public class Customer extends javax.swing.JPanel {

    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        //int lastColumn = patientTable.getColumnCount();
        //patientTable.getColumnModel().getColumn(lastColumn - 1).setCellRenderer(new TableActionCellRender());
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (row == -1){
                    JOptionPane.showMessageDialog(Main.getInstance(), "You must select a valid patient from the table!", "Error!", JOptionPane.OK_OPTION);
                    return;
                }
                
                String patientID = patientTable.getValueAt(row, 0).toString();
                Patient patient = Main.getInstance().getCustomerManager().getPatientByID(patientID);
                if (patient == null){
                    JOptionPane.showMessageDialog(Main.getInstance(), "The patient you selected is nto valid. Please selecta valid one from the table!", "Error!", JOptionPane.OK_OPTION);                   
                    return;
                }
                
                ViewCustomer viewCustomer = new ViewCustomer(patient);
                viewCustomer.setVisible(true);                
            }
        };
        patientTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        patientTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        searchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        filterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient First Name", "Patient Last Name", "Patient UID" }));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel1.setText("Filter By:");

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "UID", "Full Name", "Date of Birth", "Gender", "Phone Number", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.setGridColor(java.awt.Color.green);
        patientTable.setRowHeight(40);
        patientTable.setSelectionBackground(new java.awt.Color(153, 255, 102));
        patientTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(patientTable);
        if (patientTable.getColumnModel().getColumnCount() > 0) {
            patientTable.getColumnModel().getColumn(5).setMinWidth(45);
            patientTable.getColumnModel().getColumn(5).setPreferredWidth(45);
            patientTable.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBoxKeyPressed(evt);
            }
        });

        searchButton.setText("SEARCH");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/karam/dentistry/images/Plus.png"))); // NOI18N
        jButton1.setText("ADD PATIENT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddCustomer ac = new AddCustomer();
        ac.setVisible(true);
        ac.toFront();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyPressed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_searchBoxKeyPressed

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        refreshTable();
    }//GEN-LAST:event_searchButtonMouseClicked

    
    public void refreshTable(){
        boolean isSearching = this.searchBox.getText().length() != 0;
        int patientsSize = Main.getInstance().getCustomerManager().getPatients().size();
        int maxPatients = isSearching ? patientsSize : Math.min(100, patientsSize);
        DefaultTableModel dm = (DefaultTableModel) patientTable.getModel();
        dm.setRowCount(0);
        for (int i = 0; i < maxPatients; i++){
            Patient patient = Main.getInstance().getCustomerManager().getPatients().get(i);
            if (!isSearching){
                addPatient(patient);
            }else{
                switch (filterBox.getSelectedItem().toString()){
                    case "Patient First Name":
                        if (patient.getFirstName().contains(searchBox.getText())){
                            addPatient(patient);
                        }
                        break;
                    case "Patient Last Name":
                        if (patient.getLastName().contains(searchBox.getText())){
                            addPatient(patient);
                        }
                        break;
                    case "Patient UID":
                        if (patient.getUid().toString().contains(searchBox.getText())){
                            addPatient(patient);
                        }
                        break;
                }
            }
        }
    }
    
    private void addPatient(Patient patient){
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        model.addRow(new Object[] {
            patient.getUid(),
            patient.getFirstName() + " " + patient.getLastName(),
            patient.getDob(),
            patient.getGender(),
            patient.getPhoneNumber()
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filterBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientTable;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
