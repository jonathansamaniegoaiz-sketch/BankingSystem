package com.mycompany.bankingsystem;

import java.sql.*;
import javax.swing.JOptionPane;

public class ChangePIn extends javax.swing.JFrame {

    int accId;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChangePIn.class.getName());

    public ChangePIn() {
        setUndecorated(true);
        initComponents();
    }

    public ChangePIn(int id) {
        accId = id;
        setUndecorated(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        SettingPanel = new javax.swing.JPanel();
        changePinLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        oldPinTexField = new javax.swing.JTextField();
        newPinTexField = new javax.swing.JTextField();
        OldPinLabel = new javax.swing.JLabel();
        oldPinLabel = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SettingPanel.setBackground(new java.awt.Color(133, 14, 53));
        SettingPanel.setForeground(new java.awt.Color(133, 14, 53));

        changePinLabel.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 27)); // NOI18N
        changePinLabel.setForeground(new java.awt.Color(255, 255, 255));
        changePinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changePinLabel.setText("Change Pin");
        changePinLabel.setMaximumSize(new java.awt.Dimension(119, 31));
        changePinLabel.setMinimumSize(new java.awt.Dimension(119, 31));
        changePinLabel.setPreferredSize(new java.awt.Dimension(119, 31));

        backBtn.setBackground(new java.awt.Color(255, 166, 166));
        backBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(this::backBtnActionPerformed);

        oldPinTexField.addActionListener(this::oldPinTexFieldActionPerformed);

        OldPinLabel.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        OldPinLabel.setForeground(new java.awt.Color(255, 255, 255));
        OldPinLabel.setText("Old Pin");

        oldPinLabel.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        oldPinLabel.setForeground(new java.awt.Color(255, 255, 255));
        oldPinLabel.setText("New Pin");

        updateBtn.setBackground(new java.awt.Color(255, 166, 166));
        updateBtn.setText("Update");
        updateBtn.addActionListener(this::updateBtnActionPerformed);

        javax.swing.GroupLayout SettingPanelLayout = new javax.swing.GroupLayout(SettingPanel);
        SettingPanel.setLayout(SettingPanelLayout);
        SettingPanelLayout.setHorizontalGroup(
            SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(changePinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(oldPinTexField)
                        .addComponent(newPinTexField))
                    .addComponent(OldPinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPinLabel)
                    .addGroup(SettingPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(updateBtn)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        SettingPanelLayout.setVerticalGroup(
            SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changePinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addGap(59, 59, 59)
                .addComponent(OldPinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oldPinTexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(oldPinLabel)
                .addGap(2, 2, 2)
                .addComponent(newPinTexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(updateBtn)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SettingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SettingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Setting setting = new Setting(accId,false,Setting.posit);
        transition.switchFrame(this, setting);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void oldPinTexFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPinTexFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPinTexFieldActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int pin = 0;
        String tsql = "SELECT pin FROM bankingaccounts WHERE accId = ?";

        try (Connection conn = dbconn.connect(); PreparedStatement pst = conn.prepareStatement(tsql)) {

            pst.setInt(1, accId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Assuming columns exist
                pin = rs.getInt("pin");
            } else {
                JOptionPane.showMessageDialog(this, "\nAI: No User found with that name");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "\nAI: Error fetching user");
        }

        String oldText = oldPinTexField.getText().trim();
        String newText = newPinTexField.getText().trim();

        if (oldText.isEmpty() || newText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        int oldPin = Integer.parseInt(oldText);
        int newPin = Integer.parseInt(newText);
        if (pin == newPin) {
            JOptionPane.showMessageDialog(this, "New PIN cannot be the same as your old PIN!");
            return;
        }
        if (oldPin == pin) {
            String sql = "UPDATE bankingaccounts SET pin = ? WHERE accId = " + accId;
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update your ping?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setDouble(1, newPin);

                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Ping Updated");
                    oldPinTexField.setText("");
                    newPinTexField.setText("");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Operation Cancelled");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Pin!!!");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ChangePIn().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OldPinLabel;
    private javax.swing.JPanel SettingPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel changePinLabel;
    private javax.swing.JTextField newPinTexField;
    private javax.swing.JLabel oldPinLabel;
    private javax.swing.JTextField oldPinTexField;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
