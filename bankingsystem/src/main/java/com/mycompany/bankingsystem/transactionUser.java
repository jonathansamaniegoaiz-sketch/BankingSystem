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
public class transactionUser extends javax.swing.JFrame {
    int accId;
    String posit;
    boolean aiFrame;
    /**
     * Creates new form searchUser
     */
    public transactionUser() {
        initComponents();
        
        setLocationRelativeTo(null);
    }
    public transactionUser(int id,String pos) {
        setUndecorated(true);
        initComponents();
        
        setLocationRelativeTo(null);
        accId = id;
        posit = pos;
        
        profile pfp = new profile();
        pfp.setPreferredSize(new Dimension(100, 100));
    
        pfpContainer.setLayout(new BorderLayout());

    
        pfpContainer.add(pfp, BorderLayout.CENTER);

    
        pfpContainer.revalidate();
        pfpContainer.repaint();
        
        filterType.add("Above");
        filterType.add("Below");
        filterType.add("Type");

        
    
        
        updateTable();
    }
    private void updateTable(){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);
 
        try(Connection conn = dbconn.connect()){
            String sql = "select* from transactions where accId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,accId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int tid = rs.getInt("transacId");
                int accId = rs.getInt("accId");
                String type = rs.getString("transacType");
                double amount = rs.getDouble("amount");
                double interest = rs.getDouble("interest");
                String date = rs.getString("transacDate");
                String trans = rs.getString("transactTo");
                model.addRow(new Object[]{tid,accId,type,amount,interest,date,trans});
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
    private void FilteredTable(double amount){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM transactions WHERE accId = " + accId +" AND amount > " + amount;
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt

            try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
                while (rs.next()) {                                          // ✅ Fixed
                    int tid = rs.getInt("transacId");
                    int accId = rs.getInt("accId");
                    String type = rs.getString("transacType");
                    double amountDb = rs.getDouble("amount");
                    double interest = rs.getDouble("interest");
                    String date = rs.getString("transacDate");
                    String trans = rs.getString("transactTo");
                
                    
                        model.addRow(new Object[]{tid,accId,type,amountDb,interest,date,trans});
                    
                
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
    private void FilteredTableTransact(double amount){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM transactions WHERE accId = ?";
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt
            pstmt.setInt(1,accId);
        
        try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
            while (rs.next()) {                                          // ✅ Fixed
                int tid = rs.getInt("transacId");
                int accId = rs.getInt("accId");
                String type = rs.getString("transacType");
                double amountDb = rs.getDouble("amount");
                double interest = rs.getDouble("interest");
                String date = rs.getString("transacDate");
                String trans = rs.getString("transactTo");
                
                if(amountDb <= amount){
                    model.addRow(new Object[]{tid,accId,type,amountDb,interest,date});
                }
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

        String sql = "SELECT * FROM transactions WHERE accId = ? AND transacType = ?";
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt
            pstmt.setInt(1,accId);
            pstmt.setString(2,TYPE);
            try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
                while (rs.next()) {                                          // ✅ Fixed
                int tid = rs.getInt("transacId");
                int accId = rs.getInt("accId");
                String type = rs.getString("transacType");
                double amount = rs.getDouble("amount");
                double interest = rs.getDouble("interest");
                String date = rs.getString("transacDate");
                String trans = rs.getString("transactTo");
                model.addRow(new Object[]{tid,accId,type,amount,interest,date,trans});
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
        pfpContainer = new javax.swing.JPanel();
        dash = new javax.swing.JButton();
        deposit = new javax.swing.JButton();
        withdraw = new javax.swing.JButton();
        transfer = new javax.swing.JButton();
        savings3 = new javax.swing.JButton();
        loan = new javax.swing.JButton();
        transac = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        logout = new javax.swing.JButton();
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

        pfpContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Banko ni Negro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Microsoft Sans Serif", 1, 18), new java.awt.Color(133, 14, 53))); // NOI18N
        pfpContainer.setForeground(new java.awt.Color(133, 14, 53));
        pfpContainer.setMaximumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pfpContainerLayout = new javax.swing.GroupLayout(pfpContainer);
        pfpContainer.setLayout(pfpContainerLayout);
        pfpContainerLayout.setHorizontalGroup(
            pfpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        pfpContainerLayout.setVerticalGroup(
            pfpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        dash.setBackground(new java.awt.Color(255, 196, 196));
        dash.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        dash.setForeground(new java.awt.Color(133, 14, 53));
        dash.setText("Dashboard");
        dash.setPreferredSize(new java.awt.Dimension(70, 35));
        dash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashActionPerformed(evt);
            }
        });

        deposit.setBackground(new java.awt.Color(255, 196, 196));
        deposit.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        deposit.setForeground(new java.awt.Color(133, 14, 53));
        deposit.setText("Deposit");
        deposit.setPreferredSize(new java.awt.Dimension(70, 35));
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });

        withdraw.setBackground(new java.awt.Color(255, 196, 196));
        withdraw.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        withdraw.setForeground(new java.awt.Color(133, 14, 53));
        withdraw.setText("Withdraw");
        withdraw.setPreferredSize(new java.awt.Dimension(70, 35));
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });

        transfer.setBackground(new java.awt.Color(255, 196, 196));
        transfer.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        transfer.setForeground(new java.awt.Color(133, 14, 53));
        transfer.setText("Transfer");
        transfer.setPreferredSize(new java.awt.Dimension(70, 35));
        transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferActionPerformed(evt);
            }
        });

        savings3.setBackground(new java.awt.Color(255, 196, 196));
        savings3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        savings3.setForeground(new java.awt.Color(133, 14, 53));
        savings3.setText("Savings");
        savings3.setPreferredSize(new java.awt.Dimension(70, 35));
        savings3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savings3ActionPerformed(evt);
            }
        });

        loan.setBackground(new java.awt.Color(255, 196, 196));
        loan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        loan.setForeground(new java.awt.Color(133, 14, 53));
        loan.setText("Loan");
        loan.setPreferredSize(new java.awt.Dimension(70, 35));
        loan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanActionPerformed(evt);
            }
        });

        transac.setBackground(new java.awt.Color(238, 105, 131));
        transac.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        transac.setForeground(new java.awt.Color(133, 14, 53));
        transac.setText("Transaction");
        transac.setPreferredSize(new java.awt.Dimension(70, 35));
        transac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transacActionPerformed(evt);
            }
        });

        settings.setBackground(new java.awt.Color(255, 196, 196));
        settings.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        settings.setForeground(new java.awt.Color(133, 14, 53));
        settings.setText("Settings");
        settings.setPreferredSize(new java.awt.Dimension(100, 35));
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(255, 196, 196));
        logout.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(133, 14, 53));
        logout.setText("Logout");
        logout.setPreferredSize(new java.awt.Dimension(100, 35));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pfpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savings3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transac, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dash, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pfpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(dash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(savings3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transac, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainTable.setBackground(new java.awt.Color(255, 196, 196));
        mainTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(133, 14, 53), 1, true));
        mainTable.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        mainTable.setForeground(new java.awt.Color(133, 14, 53));
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Account ID", "Type", "Amount", "Fee", "Date", "To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        filterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterInputActionPerformed(evt);
            }
        });

        filter.setBackground(new java.awt.Color(255, 196, 196));
        filter.setText("Filter");
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter Type");

        jLabel2.setText("Filter Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(filterType, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filter))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashActionPerformed
        udashboard dash =  new udashboard(accId,aiFrame,posit);
        this.setVisible(false);
        this.dispose();
        dash.setVisible(true);
    }//GEN-LAST:event_dashActionPerformed

    private void filterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterInputActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        
        
        if (filterInput.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Input At Least One", "Error", JOptionPane.ERROR_MESSAGE);
            updateTable();
            return;
        } else if(filterType.getSelectedItem().toString().trim().equals("Above")){
            double amount = Double.parseDouble(filterInput.getText().trim());
            
            FilteredTable(amount);
        }else if(filterType.getSelectedItem().toString().trim().equals("Below")){
            double amount = Double.parseDouble(filterInput.getText().trim());
            
            FilteredTableTransact(amount);
        }else if(filterType.getSelectedItem().toString().trim().equals("Type")){
            String type = filterInput.getText().trim();
            
            FilteredTableString(type);
        }
        
        
    }//GEN-LAST:event_filterActionPerformed

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        deposit userDash = new deposit(accId,posit);
        transition.switchFrame(this,userDash);
    }//GEN-LAST:event_depositActionPerformed

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed
        widthraw with = new widthraw(accId,posit);
        transition.switchFrame(this,with);
    }//GEN-LAST:event_withdrawActionPerformed

    private void transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferActionPerformed
        transfer trans = new transfer(accId,posit);
        transition.switchFrame(this,trans);
    }//GEN-LAST:event_transferActionPerformed

    private void savings3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savings3ActionPerformed
        sbalance sbal = new sbalance(accId,posit);
        transition.switchFrame(this,sbal);
    }//GEN-LAST:event_savings3ActionPerformed

    private void loanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanActionPerformed
        loan loan = new loan(accId,posit);
        transition.switchFrame(this,loan);
    }//GEN-LAST:event_loanActionPerformed

    private void transacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transacActionPerformed
        transactionUser user = new transactionUser(accId,posit);
        transition.switchFrame(this,user);
    }//GEN-LAST:event_transacActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        Setting set = new Setting(accId,aiFrame,posit);
        transition.switchFrame(this,set);
    }//GEN-LAST:event_settingsActionPerformed

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
            java.util.logging.Logger.getLogger(transactionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transactionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transactionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transactionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transactionUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dash;
    private javax.swing.JButton deposit;
    private javax.swing.JButton filter;
    private javax.swing.JTextField filterInput;
    private java.awt.Choice filterType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loan;
    private javax.swing.JButton logout;
    private javax.swing.JTable mainTable;
    private javax.swing.JPanel pfpContainer;
    private javax.swing.JButton savings3;
    private javax.swing.JButton settings;
    private javax.swing.JButton transac;
    private javax.swing.JButton transfer;
    private javax.swing.JButton withdraw;
    // End of variables declaration//GEN-END:variables
}                  





