package com.mycompany.bankingsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class signup extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(signup.class.getName());

    public signup() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(fmale);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        nameIn = new javax.swing.JTextField();
        pin = new javax.swing.JLabel();
        signBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pin1 = new javax.swing.JLabel();
        ageIn = new javax.swing.JSpinner();
        pin2 = new javax.swing.JLabel();
        phoneIn = new javax.swing.JPasswordField();
        email1 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        fmale = new javax.swing.JRadioButton();
        addressIn = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 500));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 196, 196));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        login.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(133, 14, 53));
        login.setText("WELCOME");

        email.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        email.setForeground(new java.awt.Color(133, 14, 53));
        email.setText("FULL NAME");

        nameIn.setBackground(new java.awt.Color(252, 245, 238));
        nameIn.setForeground(new java.awt.Color(133, 14, 53));
        nameIn.addActionListener(this::nameInActionPerformed);

        pin.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        pin.setForeground(new java.awt.Color(133, 14, 53));
        pin.setText("AGE");

        signBtn.setBackground(new java.awt.Color(133, 14, 53));
        signBtn.setForeground(new java.awt.Color(252, 245, 238));
        signBtn.setText("SIGN UP");
        signBtn.addActionListener(this::signBtnActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 196, 196));
        jButton2.setText("Already have an account? Log-In");
        jButton2.setBorder(null);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        pin1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        pin1.setForeground(new java.awt.Color(133, 14, 53));
        pin1.setText("ADDRESS");

        ageIn.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        pin2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        pin2.setForeground(new java.awt.Color(133, 14, 53));
        pin2.setText("PHONE NUMBER");

        phoneIn.setBackground(new java.awt.Color(252, 245, 238));
        phoneIn.setForeground(new java.awt.Color(133, 14, 53));

        email1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        email1.setForeground(new java.awt.Color(133, 14, 53));
        email1.setText("SEX");

        male.setText("Male");

        fmale.setText("Female");

        addressIn.setBackground(new java.awt.Color(252, 245, 238));
        addressIn.setForeground(new java.awt.Color(133, 14, 53));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(signBtn)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(27, 27, 27))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email)
                            .addComponent(pin)
                            .addComponent(pin1)
                            .addComponent(pin2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(login))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(phoneIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(addressIn, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ageIn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(male)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fmale)))))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(login)
                .addGap(40, 40, 40)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pin)
                    .addComponent(email1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(male)
                    .addComponent(fmale))
                .addGap(18, 18, 18)
                .addComponent(pin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pin2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(signBtn)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        login login = new login();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void signBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signBtnActionPerformed
        cdb db = new cdb();
        
        try{
            String pin = JOptionPane.showInputDialog(null, "Enter Desired Pin:", "Input", JOptionPane.QUESTION_MESSAGE);
        int pinInt = Integer.parseInt(pin);
        String name = nameIn.getText();
        int age = (int) ageIn.getValue();
        String address = addressIn.getText();
        String phone = phoneIn.getText();
        String sex = "";
        
        if (male.isSelected()) {
            sex = "m";
        } else if (fmale.isSelected()) {
            sex = "f";
        }
        
        if(!name.isEmpty()||age > 0||!address.isEmpty()||!phone.isEmpty()||!sex.isEmpty()||pin.length()==6){
        db.addUser(name, age, address, phone, pinInt, "user", sex, "active");}
        else{
            ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
        }
        }catch(Exception e){
            ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
        }
        

      

        /*if(pin.length()< 6 || pin.length() > 6 ){
            JOptionPane.showMessageDialog(this,"PIN must be at least 6 digits.","Invalid PIN",JOptionPane.ERROR_MESSAGE);
        }*/
        
    }//GEN-LAST:event_signBtnActionPerformed

    private void nameInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInActionPerformed

    }//GEN-LAST:event_nameInActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new signup().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressIn;
    private javax.swing.JSpinner ageIn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel email;
    private javax.swing.JLabel email1;
    private javax.swing.JRadioButton fmale;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel login;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField nameIn;
    private javax.swing.JPasswordField phoneIn;
    private javax.swing.JLabel pin;
    private javax.swing.JLabel pin1;
    private javax.swing.JLabel pin2;
    private javax.swing.JButton signBtn;
    // End of variables declaration//GEN-END:variables
}
