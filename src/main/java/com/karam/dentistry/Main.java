/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.karam.dentistry;

import com.karam.dentistry.schedules.Calender;
import com.karam.dentistry.Services;
import com.karam.dentistry.customer.Customer;
import com.karam.dentistry.customer.CustomerManager;
import com.karam.dentistry.data.DataManager;
import com.karam.dentistry.schedules.Schedule;
import com.karam.dentistry.schedules.appointments.AppointmentManager;
import java.awt.Color;

/**
 *
 * @author Karam
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    private static Main instance = null;
    
    private DataManager dataManager;
    private CustomerManager customerManager;
    private AppointmentManager appointmentManager;
    
    private Schedule schedule;
    private Customer customer;
    
    private Color highlightedColor = new Color(150, 50, 100);
    private Color normalColor = new Color(242, 242, 242);
    
    public Main() {
        initComponents();
        
        instance = this;
        
        customerManager = new CustomerManager();
        appointmentManager = new AppointmentManager();
        
        dataManager = new DataManager();
        
        schedule = new Schedule();
        customer = new Customer();
        
        // Starts off the application with the schedules tab
        scheduleButtonMouseClicked(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scheduleButton = new javax.swing.JLabel();
        scheduleBar = new javax.swing.JPanel();
        customerButton = new javax.swing.JLabel();
        customerBar = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dentisry");
        setBackground(new java.awt.Color(20, 20, 20));
        setMaximumSize(new java.awt.Dimension(918, 500));
        setMinimumSize(new java.awt.Dimension(918, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));
        jPanel1.setMinimumSize(new java.awt.Dimension(918, 451));
        jPanel1.setName(""); // NOI18N

        jPanel2.setBackground(new java.awt.Color(35, 35, 35));

        scheduleButton.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        scheduleButton.setForeground(java.awt.Color.white);
        scheduleButton.setText("SCHEDULE");
        scheduleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleButtonMouseClicked(evt);
            }
        });

        scheduleBar.setMaximumSize(new java.awt.Dimension(104, 5));
        scheduleBar.setMinimumSize(new java.awt.Dimension(104, 5));
        scheduleBar.setName(""); // NOI18N
        scheduleBar.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout scheduleBarLayout = new javax.swing.GroupLayout(scheduleBar);
        scheduleBar.setLayout(scheduleBarLayout);
        scheduleBarLayout.setHorizontalGroup(
            scheduleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        scheduleBarLayout.setVerticalGroup(
            scheduleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        customerButton.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        customerButton.setForeground(java.awt.Color.white);
        customerButton.setText("CUSTOMER");
        customerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerButtonMouseClicked(evt);
            }
        });

        customerBar.setMaximumSize(new java.awt.Dimension(115, 5));
        customerBar.setMinimumSize(new java.awt.Dimension(115, 5));
        customerBar.setPreferredSize(new java.awt.Dimension(115, 5));

        javax.swing.GroupLayout customerBarLayout = new javax.swing.GroupLayout(customerBar);
        customerBar.setLayout(customerBarLayout);
        customerBarLayout.setHorizontalGroup(
            customerBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        customerBarLayout.setVerticalGroup(
            customerBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scheduleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(672, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerButton)
                    .addComponent(scheduleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scheduleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scheduleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleButtonMouseClicked
        mainPanel.removeAll();
        mainPanel.add(schedule);
        //mainPanel.add(new Calender());
        mainPanel.repaint();
        mainPanel.revalidate();
        
        scheduleBar.setBackground(highlightedColor);
        customerBar.setBackground(normalColor);
    }//GEN-LAST:event_scheduleButtonMouseClicked

    private void customerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseClicked
        mainPanel.removeAll();
        mainPanel.add(customer);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        scheduleBar.setBackground(normalColor);
        customerBar.setBackground(highlightedColor);
        
        customer.refreshTable();
    }//GEN-LAST:event_customerButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    public static Main getInstance(){
        return instance;
    }
    
    public DataManager getDataManager(){
        return dataManager;
    }
    
    public AppointmentManager getAppointmentManager(){
        return appointmentManager;
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    // made this quick method to execute button for simplicity
    public void executeButton(int i){
        if (i == 0){
            customerButtonMouseClicked(null);
            scheduleButtonMouseClicked(null);
        }else if (i == 1){
            customerButtonMouseClicked(null);
            scheduleButtonMouseClicked(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel customerBar;
    public javax.swing.JLabel customerButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel scheduleBar;
    public javax.swing.JLabel scheduleButton;
    // End of variables declaration//GEN-END:variables
}
