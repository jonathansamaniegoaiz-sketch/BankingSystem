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
public class searchUser extends javax.swing.JFrame {
    int accId;
    String position;
         public static boolean aiFrame = false;
     public static boolean mainFrame = true;
      public static String posit = "Admin";
    /**
     * Creates new form searchUser
     */
    public searchUser() {
        setUndecorated(true);
        initComponents();
        
        setLocationRelativeTo(null);
    }
    public searchUser(int id) {
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
        
        filterType.add("ID");
        filterType.add("Name");
        filterType.add("Status");

        
        cdb db = new cdb();
        double cap = db.getCapital();
        capital.setText(String.format("%.2f", cap));
        
        double Activeloan = db.getActiveLoan();
        loan.setText(String.format("%.2f", Activeloan));
        updateTable();
    }
    private void updateTable(){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);

        try(Connection conn = dbconn.connect()){
            String sql = "select* from bankingAccounts";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("accId");
                String name = rs.getString("fullName");
                double savings = rs.getDouble("sBalance");
                double loans = rs.getDouble("lBalance");
                String status = rs.getString("status");
                
                model.addRow(new Object[]{id,name,savings,loans,status});
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
    private void FilteredTable(int fid){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);
        
        String sql = "SELECT * FROM bankingAccounts WHERE accId =" + fid;
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt

            try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
                while (rs.next()) {                                          // ✅ Fixed
                    int id          = rs.getInt("accId");
                    String name     = rs.getString("fullName");
                    double savings  = rs.getDouble("sBalance");
                    double loans    = rs.getDouble("lBalance");
                    String status   = rs.getString("status");

                    model.addRow(new Object[]{id, name, savings, loans, status});
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
    private void FilteredTable(String NAME){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM bankingAccounts WHERE fullname = ? ";
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt
            pstmt.setString(1,NAME);
        
        try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
            while (rs.next()) {                                          // ✅ Fixed
                int id          = rs.getInt("accId");
                String name     = rs.getString("fullName");
                double savings  = rs.getDouble("sBalance");
                double loans    = rs.getDouble("lBalance");
                String status   = rs.getString("status");

                model.addRow(new Object[]{id, name, savings, loans, status});
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
    private void FilteredTableString(String STATUS){
        
        
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM bankingAccounts WHERE status = ?";
                 

        try (Connection conn = dbconn.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {         // ← also auto-close pstmt
            pstmt.setString(1,STATUS);
            try (ResultSet rs = pstmt.executeQuery()) {                      // ← also auto-close rs
                while (rs.next()) {                                          // ✅ Fixed
                    int id          = rs.getInt("accId");
                    String name     = rs.getString("fullName");
                    double savings  = rs.getDouble("sBalance");
                    double loans    = rs.getDouble("lBalance");
                    String status   = rs.getString("status");

                    model.addRow(new Object[]{id, name, savings, loans, status});
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
        diana = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        capital = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        loan = new javax.swing.JTextField();

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

        transactionBtn.setBackground(new java.awt.Color(255, 196, 196));
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

        searchBtn2.setBackground(new java.awt.Color(238, 105, 131));
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
                    .addComponent(settingsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Account ID", "Full Name", "Savings Balance", "Loans Balance", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            mainTable.getColumnModel().getColumn(4).setResizable(false);
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

        filterType.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        filterType.setForeground(new java.awt.Color(133, 14, 53));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(133, 14, 53));
        jLabel1.setText("Filter Type");

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(133, 14, 53));
        jLabel2.setText("Filter Data");

        diana.setBackground(new java.awt.Color(255, 196, 196));
        diana.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        diana.setForeground(new java.awt.Color(133, 14, 53));
        diana.setText("Ask Diana?");
        diana.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dianaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(133, 14, 53));
        jLabel3.setText("Capital :");

        capital.setEditable(false);
        capital.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        capital.setForeground(new java.awt.Color(133, 14, 53));
        capital.setText("0.00");
        capital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capitalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(133, 14, 53));
        jLabel4.setText("Total Loans :");

        loan.setEditable(false);
        loan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        loan.setForeground(new java.awt.Color(133, 14, 53));
        loan.setText("0.00");

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
                            .addComponent(filterType, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capital, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(diana))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(capital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(diana))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        } else if(filterType.getSelectedItem().toString().trim().equals("ID")){
            int ID = Integer.parseInt(filterInput.getText().trim());
            
            FilteredTable(ID);
        }else if(filterType.getSelectedItem().toString().trim().equals("Name")){
            String name = filterInput.getText().trim();
            
            FilteredTable(name);
        }else if(filterType.getSelectedItem().toString().trim().equals("Status")){
            String status = filterInput.getText().trim();
            
            FilteredTableString(status);
        }
        }catch(Exception e){
            ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
        }
        
        
        
    }//GEN-LAST:event_filterActionPerformed

    private void dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dianaActionPerformed

        // hide main dashboard
        new AiUi(accId, true, this,position);
        // TODO add your handling code here:
    }//GEN-LAST:event_dianaActionPerformed

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

    private void capitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capitalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capitalActionPerformed

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
            java.util.logging.Logger.getLogger(searchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capital;
    private javax.swing.JButton dash;
    private javax.swing.JButton diana;
    private javax.swing.JButton filter;
    private javax.swing.JTextField filterInput;
    private java.awt.Choice filterType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loan;
    private javax.swing.JButton logout;
    private javax.swing.JTable mainTable;
    private javax.swing.JPanel pfpContainer;
    private javax.swing.JButton searchBtn2;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JButton transactionBtn;
    // End of variables declaration//GEN-END:variables
}                  





