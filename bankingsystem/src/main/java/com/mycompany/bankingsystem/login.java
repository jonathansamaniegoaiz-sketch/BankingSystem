
package com.mycompany.bankingsystem;
import java.sql.*;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(login.class.getName());
    boolean aiFrame;
    public login() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        idIn = new javax.swing.JTextField();
        pin = new javax.swing.JLabel();
        pinIn = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 500));
        setUndecorated(true);

        panel.setBackground(new java.awt.Color(255, 196, 196));
        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        login.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(133, 14, 53));
        login.setText("WELCOME");

        email.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        email.setForeground(new java.awt.Color(133, 14, 53));
        email.setText("ID :");

        idIn.setBackground(new java.awt.Color(252, 245, 238));
        idIn.setForeground(new java.awt.Color(133, 14, 53));
        idIn.addActionListener(this::idInActionPerformed);

        pin.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        pin.setForeground(new java.awt.Color(133, 14, 53));
        pin.setText("Pin :");

        pinIn.setBackground(new java.awt.Color(252, 245, 238));
        pinIn.setForeground(new java.awt.Color(133, 14, 53));

        jButton1.setBackground(new java.awt.Color(133, 14, 53));
        jButton1.setForeground(new java.awt.Color(252, 245, 238));
        jButton1.setText("SIGN IN");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 196, 196));
        jButton2.setText("Don't have an account? Sign-Up");
        jButton2.setBorder(null);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(email)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idIn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(pin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pinIn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton2))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton1)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login)
                .addGap(71, 71, 71))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email))
                .addGap(32, 32, 32)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pinIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pin))
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String idTxt = idIn.getText().trim();
        String pinTxt = new String(pinIn.getPassword()).trim();

        if (idTxt.isEmpty() || pinTxt.isEmpty()) {
            ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 3);
            return;
        }else if (pinTxt.length()>6 ||  pinTxt.length()== 0) {
            JOptionPane.showMessageDialog(null,"INPUT 6 PIN","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            
            int inputId = Integer.parseInt(idTxt);
            int inputPin = Integer.parseInt(pinTxt);

            // 2. Database Connection
            try (Connection conn = dbconn.connect()) {
                String sql = "SELECT accId, position, pin FROM bankingAccounts";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                
                while (rs.next()) {
                    int dbid = rs.getInt("accId");
                    int dbpin = rs.getInt("pin");
                    String dbposition = rs.getString("position");
                   

                    // 3. Credential Match Check
                    if (inputId == dbid && inputPin == dbpin) {
                        this.setVisible(false); // Hide login once found
                         found = true;

                        if ("Admin".equals(dbposition)) {
                            new adminDashboard(dbid).setVisible(true);
                            return; // Exit loop and method
                        }

                        if ("user".equals(dbposition)) {
                            new udashboard(dbid,aiFrame,dbposition).setVisible(true);
                            return;
                        }
                    }
                }

               if (!found) {
                    
                    ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 3);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 3);
        }


        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        signup signup = new signup();;
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email;
    private javax.swing.JTextField idIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel login;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel pin;
    private javax.swing.JPasswordField pinIn;
    // End of variables declaration//GEN-END:variables
}
