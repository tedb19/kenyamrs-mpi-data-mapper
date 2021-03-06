/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emr.connections;

import com.emr.utilities.DatabaseManager;
import com.emr.utilities.FileManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *  A JInternalFrame Form for adding/editing connection parameters for the MPI database
 * @author LEONARD NDUATI
 */
public class MPIConnectionForm extends javax.swing.JInternalFrame {
    DatabaseManager dbManager;
    Connection con;
    FileManager fileManager;
    /**
     * Creates new form MPIConnectionForm
     */
    public MPIConnectionForm() {
        con=null;
        dbManager=null;
        initComponents();
        this.setClosable(true);
        
        fileManager=new FileManager();
        String[] settings=fileManager.getConnectionSettings("mpi_database.properties","mpi");
        if(settings.length>1){
            txtServerName.setText(settings[0]);
            txtServerPort.setText(settings[1]);
            txtDbName.setText(settings[3]);
            txtUserName.setText(settings[4]);
            txtPassword.setText(settings[5]);
        }
    }
    /**
     * Method creates a connection using the settings entered in the form
     * @param test Boolean whether this is a connection test or not
     * @return {@link boolean} true|false
     */
    private boolean makeConnection(boolean test){
        String serverName=txtServerName.getText();
        String serverPort=txtServerPort.getText();
        String dbName=txtDbName.getText();
        String userName=txtUserName.getText();
        String password=txtPassword.getText();
        dbManager=new DatabaseManager(serverName, serverPort, dbName, userName, password);
        con=dbManager.getConnection();
        if(con!=null){
            if(test){
                JOptionPane.showMessageDialog(this, "Test Connection Successful", "Connection Test", JOptionPane.INFORMATION_MESSAGE);
            }
            return true;
        }else{
            if(test){
                JOptionPane.showMessageDialog(this, "Test Connection Failed", "Connection Test", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtServerName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtServerPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDbName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();

        setClosable(true);
        setIconifiable(true);
        setTitle("MPI Database Connection Settings");
        setPreferredSize(new java.awt.Dimension(416, 286));
        setRequestFocusEnabled(false);

        jLabel1.setText("Server Name");

        txtServerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Server Port");

        txtServerPort.setText("3306");

        jLabel3.setText("Database Name");

        jLabel4.setText("Login ID");

        jLabel5.setText("Password");

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test_connection.png"), ""));
        jButton1.setText("Test");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"), ""));
        jButton2.setText("Save");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtServerName)
                    .addComponent(txtServerPort, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(txtDbName)
                    .addComponent(txtUserName)
                    .addComponent(txtPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtServerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtDbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerNameActionPerformed
    /**
     * Handles click event for the Test button
     * Tests entered connection settings
     * @param evt {@link ActionEvent} 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //Test database connection here
        makeConnection(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Handles click event for the save button
     * Saves connection settings
     * @param evt {@link ActionEvent}
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //save db settings to a properties file
        if(con==null){
            //Connection object is null. Initialize it first
            if(!makeConnection(false)){
                //Connection to the db could not be established
                JOptionPane.showMessageDialog(this, "Connection to the database failed!", "Database Connection", JOptionPane.ERROR_MESSAGE);
            }else{
                //Successful connection was established
                dbManager.saveSettings("mpi_database.properties","mpi");
                this.setVisible(false);
                this.dispose();
            }
        }else{
            //There's an already established connection
            dbManager.saveSettings("mpi_database.properties","mpi");
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtDbName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtServerName;
    private javax.swing.JTextField txtServerPort;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
