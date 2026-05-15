/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bankingsystem;

import static com.mycompany.bankingsystem.udashboard.accId;
import static com.mycompany.bankingsystem.udashboard.posit;
import javax.swing.*;
import java.awt.*;

public class deposit extends javax.swing.JFrame {

    private int accId;
    boolean aiFrame;
    String posit;

    public deposit() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);

        // 1. Create your image panel
        profile pfp = new profile();
        pfp.setPreferredSize(new Dimension(100, 100));
        // 2. Set a simple layout for the container so the image fills it
        pfpContainer.setLayout(new BorderLayout());

        // 3. Add the image to the container
        pfpContainer.add(pfp, BorderLayout.CENTER);

        // 4. Refresh to show changes
        pfpContainer.revalidate();
        pfpContainer.repaint();
    }

    public deposit(int id, String pos) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        setVisible(true);
        profile pfp = new profile();
        pfp.setPreferredSize(new Dimension(100, 100));
        // 2. Set a simple layout for the container so the image fills it
        pfpContainer1.setLayout(new BorderLayout());

        // 3. Add the image to the container
        pfpContainer1.add(pfp, BorderLayout.CENTER);

        // 4. Refresh to show changes
        pfpContainer1.revalidate();
        pfpContainer1.repaint();

        accId = id;
        posit = pos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        pfpContainer = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        depositTab = new javax.swing.JButton();
        withdrawTab = new javax.swing.JButton();
        savings = new javax.swing.JButton();
        loan = new javax.swing.JButton();
        transac = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        transferTab = new javax.swing.JButton();
        dashboard = new javax.swing.JButton();
        pfpContainer1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        savingsBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Dconfirm = new javax.swing.JButton();
        deposit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        diana = new javax.swing.JButton();

        jButton1.setText("jButton1");

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
            .addGap(0, 74, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setUndecorated(true);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(133, 14, 53));
        mainPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 245, 238));
        jLabel1.setText("Welcome");

        buttonsPanel.setBackground(new java.awt.Color(252, 245, 238));
        buttonsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonsPanel.setForeground(new java.awt.Color(252, 245, 238));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(200, 500));

        depositTab.setBackground(new java.awt.Color(238, 105, 131));
        depositTab.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        depositTab.setForeground(new java.awt.Color(133, 14, 53));
        depositTab.setText("Deposit");
        depositTab.setPreferredSize(new java.awt.Dimension(70, 35));
        depositTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositTabActionPerformed(evt);
            }
        });

        withdrawTab.setBackground(new java.awt.Color(255, 196, 196));
        withdrawTab.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        withdrawTab.setForeground(new java.awt.Color(133, 14, 53));
        withdrawTab.setText("Withdraw");
        withdrawTab.setPreferredSize(new java.awt.Dimension(70, 35));
        withdrawTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawTabActionPerformed(evt);
            }
        });

        savings.setBackground(new java.awt.Color(255, 196, 196));
        savings.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        savings.setForeground(new java.awt.Color(133, 14, 53));
        savings.setText("Savings");
        savings.setPreferredSize(new java.awt.Dimension(70, 35));
        savings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savingsActionPerformed(evt);
            }
        });

        loan.setBackground(new java.awt.Color(255, 196, 196));
        loan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        loan.setForeground(new java.awt.Color(133, 14, 53));
        loan.setText("Loan");
        loan.setPreferredSize(new java.awt.Dimension(70, 35));
        loan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanActionPerformed(evt);
            }
        });

        transac.setBackground(new java.awt.Color(255, 196, 196));
        transac.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        transac.setForeground(new java.awt.Color(133, 14, 53));
        transac.setText("Transaction");
        transac.setPreferredSize(new java.awt.Dimension(70, 35));
        transac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transacActionPerformed(evt);
            }
        });

        settings.setBackground(new java.awt.Color(255, 196, 196));
        settings.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        settings.setForeground(new java.awt.Color(133, 14, 53));
        settings.setText("Settings");
        settings.setPreferredSize(new java.awt.Dimension(70, 35));
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(255, 196, 196));
        logout.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        logout.setForeground(new java.awt.Color(133, 14, 53));
        logout.setText("Logout");
        logout.setPreferredSize(new java.awt.Dimension(100, 35));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        transferTab.setBackground(new java.awt.Color(255, 196, 196));
        transferTab.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        transferTab.setForeground(new java.awt.Color(133, 14, 53));
        transferTab.setText("Transfer");
        transferTab.setPreferredSize(new java.awt.Dimension(70, 35));
        transferTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferTabActionPerformed(evt);
            }
        });

        dashboard.setBackground(new java.awt.Color(255, 196, 196));
        dashboard.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        dashboard.setForeground(new java.awt.Color(133, 14, 53));
        dashboard.setText("Dashboard");
        dashboard.setPreferredSize(new java.awt.Dimension(70, 35));
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });

        pfpContainer1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Banko ni Negro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Microsoft Sans Serif", 1, 18), new java.awt.Color(133, 14, 53))); // NOI18N
        pfpContainer1.setForeground(new java.awt.Color(133, 14, 53));
        pfpContainer1.setMaximumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pfpContainer1Layout = new javax.swing.GroupLayout(pfpContainer1);
        pfpContainer1.setLayout(pfpContainer1Layout);
        pfpContainer1Layout.setHorizontalGroup(
            pfpContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pfpContainer1Layout.setVerticalGroup(
            pfpContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pfpContainer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(buttonsPanelLayout.createSequentialGroup()
                        .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(transac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(savings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transferTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(withdrawTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(depositTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addComponent(pfpContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(depositTab, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(withdrawTab, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transferTab, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(savings, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transac, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(252, 245, 238));
        jPanel1.setPreferredSize(new java.awt.Dimension(755, 415));

        savingsBtn.setBackground(new java.awt.Color(238, 105, 131));
        savingsBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        savingsBtn.setForeground(new java.awt.Color(133, 14, 53));
        savingsBtn.setText("Savings");
        savingsBtn.setPreferredSize(new java.awt.Dimension(75, 35));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(savingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(savingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 196, 196));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(133, 14, 53), 1, true));
        jPanel3.setPreferredSize(new java.awt.Dimension(462, 244));

        Dconfirm.setBackground(new java.awt.Color(238, 105, 131));
        Dconfirm.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        Dconfirm.setForeground(new java.awt.Color(133, 14, 53));
        Dconfirm.setText("Confirm");
        Dconfirm.setToolTipText("");
        Dconfirm.setPreferredSize(new java.awt.Dimension(75, 35));
        Dconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DconfirmActionPerformed(evt);
            }
        });

        deposit.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        deposit.setForeground(new java.awt.Color(133, 14, 53));
        deposit.setText("0.00");
        deposit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(133, 14, 53));
        jLabel2.setText("DEPOSIT");

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(133, 14, 53));
        jLabel3.setText("Enter Amount");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );

        diana.setBackground(new java.awt.Color(255, 196, 196));
        diana.setForeground(new java.awt.Color(133, 14, 53));
        diana.setText("Ask Diana?");
        diana.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dianaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(371, 371, 371))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(diana)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(diana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        new logout(this).setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        Setting set = new Setting(accId, aiFrame, posit);
        transition.switchFrame(this, set);
    }//GEN-LAST:event_settingsActionPerformed

    private void transacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transacActionPerformed
        transactionUser user = new transactionUser(accId, posit);
        transition.switchFrame(this, user);
    }//GEN-LAST:event_transacActionPerformed

    private void loanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanActionPerformed
        loan loan = new loan();
        transition.switchFrame(this, loan);
    }//GEN-LAST:event_loanActionPerformed

    private void savingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savingsActionPerformed
        sbalance sbal = new sbalance(accId, posit);
        transition.switchFrame(this, sbal);
    }//GEN-LAST:event_savingsActionPerformed

    private void withdrawTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawTabActionPerformed
        widthraw with = new widthraw(accId, posit);
        transition.switchFrame(this, with);
    }//GEN-LAST:event_withdrawTabActionPerformed

    private void depositTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositTabActionPerformed
        deposit userDash = new deposit(accId, posit);
        transition.switchFrame(this, userDash);
    }//GEN-LAST:event_depositTabActionPerformed

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        deposit.setText("");
    }//GEN-LAST:event_depositActionPerformed

    private void transferTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferTabActionPerformed
        transfer trans = new transfer(accId, posit);
        transition.switchFrame(this, trans);
    }//GEN-LAST:event_transferTabActionPerformed

    private void DconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DconfirmActionPerformed
        cdb cdb = new cdb();
        String Ssavings = deposit.getText();
        try {
            if (Ssavings.isEmpty()) {
                ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
            } else {
                double saving = Double.parseDouble(deposit.getText());
                if (saving == 0) {
                    ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
                } else {
                    try {
                        double newSavings = Double.parseDouble(Ssavings.trim());
                        cdb.setSavingsDeposit(accId, newSavings);
                        deposit.setText("0.00");
                    } catch (NumberFormatException e) {
                        ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
                    }
                }

            }
        } catch (NumberFormatException e) {
            ErrorManager.showError((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), 0);
        }

    }//GEN-LAST:event_DconfirmActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        udashboard dashboard = new udashboard(accId, aiFrame, posit);
        transition.switchFrame(this, dashboard);
    }//GEN-LAST:event_dashboardActionPerformed

    private void dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dianaActionPerformed
        new AiUi(accId, true, this, posit);
    }//GEN-LAST:event_dianaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deposit().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dconfirm;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton dashboard;
    private javax.swing.JTextField deposit;
    private javax.swing.JButton depositTab;
    private javax.swing.JButton diana;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loan;
    private javax.swing.JButton logout;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pfpContainer;
    private javax.swing.JPanel pfpContainer1;
    private javax.swing.JButton savings;
    private javax.swing.JButton savingsBtn;
    private javax.swing.JButton settings;
    private javax.swing.JButton transac;
    private javax.swing.JButton transferTab;
    private javax.swing.JButton withdrawTab;
    // End of variables declaration//GEN-END:variables
}
