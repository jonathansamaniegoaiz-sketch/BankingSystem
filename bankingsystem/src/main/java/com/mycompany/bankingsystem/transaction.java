/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bankingsystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Student
 */
public class transaction extends javax.swing.JFrame {
    int accId;
    public static boolean aiFrame = false;
     public static boolean mainFrame = true;
      public static String posit = "Admin";
    /**
     * Creates new form searchUser
     */
    public transaction() {
        setUndecorated(true);
        initComponents();
        
        setLocationRelativeTo(null);
    }
    public transaction(int id) {
        setUndecorated(true);
        initComponents();
        
        setLocationRelativeTo(null);
        accId = id;
        
        profile pfp = new profile();
        pfp.setPreferredSize(new Dimension(100, 100));
    
        pfpContainer.setLayout(new BorderLayout());

    
        pfpContainer.add(pfp, BorderLayout.CENTER);

    
        pfpContainer.revalidate();
        pfpContainer.repaint();
        
        filterType.add("Account ID");
        filterType.add("Transaction ID");
        filterType.add("Type");

        
    
        
        updateTable();
    }
    private void updateTable(){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);
        
        try(Connection conn = dbconn.connect()){
            String sql = "select* from transactions";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int tid = rs.getInt("transacId");
                int accId = rs.getInt("accId");
                String type = rs.getString("transacType");
                double amount = rs.getDouble("amount");
                double interest = rs.getDouble("interest");
                String date = rs.getString("transacDate");
                
                model.addRow(new Object[]{tid,accId,type,amount,interest,date});
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < mainTable.getColumnCount(); i++) {
            mainTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    private void FilteredTable(int faid){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);
        
        String sql = "SELECT * FROM transactions WHERE accId =" + faid;
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt

            try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
                while (rs.next()) {                                          // ✅ Fixed
                int tid = rs.getInt("transacId");
                int accId = rs.getInt("accId");
                String type = rs.getString("transacType");
                double amount = rs.getDouble("amount");
                double interest = rs.getDouble("interest");
                String date = rs.getString("transacDate");

                    model.addRow(new Object[]{tid,accId,type,amount,interest,date});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);               // ✅ Fixed

        for (int i = 0; i < mainTable.getColumnCount(); i++) {
            mainTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    private void FilteredTableTransact(int TID){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM transactions WHERE transacId = ? ";
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt
            pstmt.setInt(1,TID);
        
        try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
            while (rs.next()) {                                          // ✅ Fixed
                int tid = rs.getInt("transacId");
                int accId = rs.getInt("accId");
                String type = rs.getString("transacType");
                double amount = rs.getDouble("amount");
                double interest = rs.getDouble("interest");
                String date = rs.getString("transacDate");
                model.addRow(new Object[]{tid,accId,type,amount,interest,date});
            }
        }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);               // ✅ Fixed

        for (int i = 0; i < mainTable.getColumnCount(); i++) {
            mainTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    private void FilteredTableString(String TYPE){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM transactions WHERE transacType = ?";
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt
            pstmt.setString(1,TYPE);
            try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
                while (rs.next()) {                                          // ✅ Fixed
                int tid = rs.getInt("transacId");
                int accId = rs.getInt("accId");
                String type = rs.getString("transacType");
                double amount = rs.getDouble("amount");
                double interest = rs.getDouble("interest");
                String date = rs.getString("transacDate");
                model.addRow(new Object[]{tid,accId,type,amount,interest,date});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);               // ✅ Fixed

        for (int i = 0; i < mainTable.getColumnCount(); i++) {
            mainTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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

        jPanel1 = new javax.swing.JPanel();
        dash = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        transactionBtn = new javax.swing.JButton();
        pfpContainer = new javax.swing.JPanel();
        settingsBtn = new javax.swing.JButton();
        searchBtn2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        filterInput = new javax.swing.JTextField();
        filter = new javax.swing.JButton();
        filterType = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 245, 238));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 500));

        dash.setBackground(new java.awt.Color(255, 196, 196));
        dash.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        dash.setForeground(new java.awt.Color(133, 14, 53));
        dash.setText("Dashboard");
        dash.setPreferredSize(new java.awt.Dimension(72, 35));
        dash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(255, 196, 196));
        logout.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(133, 14, 53));
        logout.setText("Logout");
        logout.setPreferredSize(new java.awt.Dimension(75, 35));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        transactionBtn.setBackground(new java.awt.Color(238, 105, 131));
        transactionBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        transactionBtn.setForeground(new java.awt.Color(133, 14, 53));
        transactionBtn.setText("Transaction History");
        transactionBtn.setPreferredSize(new java.awt.Dimension(75, 35));
        transactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionBtnActionPerformed(evt);
            }
        });

        pfpContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Banko ni Negro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Microsoft Sans Serif", 1, 18), new java.awt.Color(133, 14, 53))); // NOI18N
        pfpContainer.setForeground(new java.awt.Color(133, 14, 53));
        pfpContainer.setMaximumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pfpContainerLayout = new javax.swing.GroupLayout(pfpContainer);
        pfpContainer.setLayout(pfpContainerLayout);
        pfpContainerLayout.setHorizontalGroup(
            pfpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pfpContainerLayout.setVerticalGroup(
            pfpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        settingsBtn.setBackground(new java.awt.Color(255, 196, 196));
        settingsBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        settingsBtn.setForeground(new java.awt.Color(133, 14, 53));
        settingsBtn.setText("Settings");
        settingsBtn.setPreferredSize(new java.awt.Dimension(75, 35));
        settingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBtnActionPerformed(evt);
            }
        });

        searchBtn2.setBackground(new java.awt.Color(255, 196, 196));
        searchBtn2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        searchBtn2.setForeground(new java.awt.Color(133, 14, 53));
        searchBtn2.setText("Accounts");
        searchBtn2.setPreferredSize(new java.awt.Dimension(72, 35));
        searchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(dash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pfpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pfpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(dash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(transactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        mainTable.setBackground(new java.awt.Color(255, 196, 196));
        mainTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(133, 14, 53), 1, true));
        mainTable.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        mainTable.setForeground(new java.awt.Color(133, 14, 53));
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Account ID", "Type", "Amount", "Interest", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainTable.setGridColor(new java.awt.Color(133, 14, 53));
        mainTable.setShowGrid(true);
        jScrollPane1.setViewportView(mainTable);
        if (mainTable.getColumnModel().getColumnCount() > 0) {
            mainTable.getColumnModel().getColumn(0).setResizable(false);
            mainTable.getColumnModel().getColumn(1).setResizable(false);
        }

        filterInput.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        filterInput.setForeground(new java.awt.Color(133, 14, 53));
        filterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterInputActionPerformed(evt);
            }
        });

        filter.setBackground(new java.awt.Color(255, 196, 196));
        filter.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        filter.setForeground(new java.awt.Color(133, 14, 53));
        filter.setText("Filter");
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(133, 14, 53));
        jLabel1.setText("Filter Type");

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(133, 14, 53));
        jLabel2.setText("Filter Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(filterType, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter))
                            .addComponent(jLabel2))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filter, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filterInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterInputActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        
        try{
            if (filterInput.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Input At Least One", "Error", JOptionPane.ERROR_MESSAGE);
            updateTable();
            return;
        } else if(filterType.getSelectedItem().toString().trim().equals("Account ID")){
            int aID = Integer.parseInt(filterInput.getText().trim());
            
            FilteredTable(aID);
        }else if(filterType.getSelectedItem().toString().trim().equals("Transaction ID")){
            int tID = Integer.parseInt(filterInput.getText().trim());
            
            FilteredTableTransact(tID);
        }else if(filterType.getSelectedItem().toString().trim().equals("Type")){
            String type = filterInput.getText().trim();
            
            FilteredTableString(type);
        }
        }catch(Exception e){
            ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
        }
        
        
        
    }//GEN-LAST:event_filterActionPerformed

    private void dashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashActionPerformed
        adminDashboard dash =  new adminDashboard(accId);
        this.setVisible(false);
        this.dispose();
        dash.setVisible(true);
    }//GEN-LAST:event_dashActionPerformed

    private void transactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionBtnActionPerformed
        transaction transact =  new transaction(accId);
        this.setVisible(false);
        this.dispose();
        transact.setVisible(true);
    }//GEN-LAST:event_transactionBtnActionPerformed

    private void searchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn2ActionPerformed
        searchUser user =  new searchUser(accId);
        this.setVisible(false);
        this.dispose();
        user.setVisible(true);

    }//GEN-LAST:event_searchBtn2ActionPerformed

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        Setting set = new Setting(accId,aiFrame,posit);
        transition.switchFrame(this,set);
    }//GEN-LAST:event_settingsBtnActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        new logout(this).setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dash;
    private javax.swing.JButton filter;
    private javax.swing.JTextField filterInput;
    private java.awt.Choice filterType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTable mainTable;
    private javax.swing.JPanel pfpContainer;
    private javax.swing.JButton searchBtn2;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JButton transactionBtn;
    // End of variables declaration//GEN-END:variables
}                  





