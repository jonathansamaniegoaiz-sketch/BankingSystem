package com.mycompany.bankingsystem;

import java.sql.*;
import javax.swing.JOptionPane;

public class databaseLogic {

    //Update names by id
    public static void updateUserName(int id, String name, AiUi ui) {
        name = name.trim();
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            String sql = "UPDATE bankingaccounts SET fullName = ? WHERE accId = ?";
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the name of this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, name);
                    stmt.setInt(2, id);

                    if (id == 0 || name == null || name.equals("") || name.equals("string")) {

                        ui.appendChatBox("\nAi: Invalid Input");
                    } else {
                        stmt.executeUpdate();
                        ui.appendChatBox("\nAi: Data Updated");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }

        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }

    }

    public static void updateUserSBalance(int id, Double sBal, AiUi ui) {
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            String sql = "UPDATE bankingaccounts SET sBalance = ? WHERE accId = ?";
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the savings of this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setDouble(1, sBal);
                    stmt.setInt(2, id);

                    stmt.executeUpdate();

                    String sqlTransact = "INSERT INTO transactions(transacId,accId,amount,transacType,transactTo) VALUES(null, ?, ?, ?,?)";
                    PreparedStatement pstmtTransact = conn.prepareStatement(sqlTransact);
                    pstmtTransact.setInt(1, id);
                    pstmtTransact.setDouble(2, sBal);
                    pstmtTransact.setString(3, "Deposit");
                    pstmtTransact.setString(4, "Cash");
                    if (sBal > 0) {
                        pstmtTransact.executeUpdate();
                        ui.appendChatBox("\nAI: Data Updated");
                    } else {
                        ui.appendChatBox("\nAI: Invalid input");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }
        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }

    }

    public static void updateUserLBalance(int id, Double lBal, AiUi ui) {
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            String sql = "UPDATE bankingaccounts SET lBalance = ? WHERE accId = ?";
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the loan of this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setDouble(1, lBal);
                    stmt.setInt(2, id);
                    if (lBal > 0) {
                        stmt.executeUpdate();
                        ui.appendChatBox("\nAI: Data Updated");
                    } else {
                        ui.appendChatBox("\nAI: Invalid Input");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }
        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }

    }

    public static void updateUserStatus(int id, String stat, AiUi ui) {
        stat = stat.trim();
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            String sql = "UPDATE bankingaccounts SET status = ? WHERE accId = ?";
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the status of this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, stat);
                    stmt.setInt(2, id);
                    if (id == 0 || stat == null || stat.equals("") || stat.equals("string")) {
                        ui.appendChatBox("\nAI: Invalid Input");
                    } else {
                        stmt.executeUpdate();

                        ui.appendChatBox("\nAI: Data Updated");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }
        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }

    }

    public static void updateUserPosition(int id, String pos, AiUi ui) {
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            String sql = "UPDATE bankingaccounts SET position = ? WHERE accId = ?";
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the positon of this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, pos);
                    stmt.setInt(2, id);
                    if (id == 0 || pos == null || pos.equals("") || pos.equals("string")) {
                    } else {
                        stmt.executeUpdate();
                        ui.appendChatBox("\nAI: Data Updated");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }
        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }
    }

    public static void updateUserPin(int id, int pin, AiUi ui) {
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            String sql = "UPDATE bankingaccounts SET pin = ? WHERE accId = ?";
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the pin of this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setInt(1, pin);
                    stmt.setInt(2, id);
                    if (id == 0 || pin == 0 || pin < 100000 || pin > 999999) {
                        ui.appendChatBox("\nAI: Invalid Input");
                    } else {
                        stmt.executeUpdate();

                        ui.appendChatBox("\nAI: Data Updated");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }
        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }

    }

    //adding user
    public static void addUser(String name, int age, String address, String phone, int pin, String pos, String sex, String status, AiUi ui) {
        int accId = 0;
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                String sqlSetMaintable = "INSERT INTO bankingaccounts (fullName,position,pin,status) VALUES (?, ?, ?,?)";
                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sqlSetMaintable)) {

                    stmt.setString(1, name);
                    stmt.setString(2, pos);
                    stmt.setInt(3, pin);
                    stmt.setString(4, status);

                    stmt.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                String sqlGetAccId = "SELECT accId FROM bankingaccounts WHERE fullname = ?";

                try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sqlGetAccId)) {

                    stmt.setString(1, name);

                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        accId = rs.getInt("accId");

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String sqlSetChildtable = "INSERT INTO users (full_name,age,address,phone_number,sex,acc_id) VALUES (?, ?, ?, ?,?,?)";
                int confirms = JOptionPane.showConfirmDialog(null, "Are you sure your informations are correct?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirms == JOptionPane.YES_OPTION) {
                    try (Connection conn = dbconn.connect(); PreparedStatement stmt = conn.prepareStatement(sqlSetChildtable)) {

                        stmt.setString(1, name);
                        stmt.setInt(2, age);
                        stmt.setString(3, address);
                        stmt.setString(4, phone);
                        stmt.setString(5, sex);
                        stmt.setInt(6, accId);

                        if (name == null || name.equals("") || name.equals("string") || age > 100 || age < 0 || address == null || address.equals("") || address.equals("string") || phone == null || phone.length() != 11 || sex == null || sex.length() != 1 || !sex.equals("m") || !sex.equals("f")) {
                            ui.appendChatBox("\nAI: Invalid Input");
                        } else {
                            stmt.executeUpdate();
                            ui.appendChatBox("\nAI: Account successfully created");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }
        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }
    }

    //delete
    public static void deleteUser(int id, AiUi ui) {
        if (AiUi.posit.equalsIgnoreCase("Admin")) {
            String sql = "DELETE FROM bankingaccounts WHERE accId = ?";
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = dbconn.connect(); PreparedStatement pst = conn.prepareStatement(sql)) {

                    pst.setInt(1, id);

                    if (id == 0) {
                        ui.appendChatBox("\nAI: Invalid Input");
                    } else {
                        int rows = pst.executeUpdate();
                        if (rows > 0) {
                            ui.appendChatBox("\nAI: Data Deleted");
                        } else {
                            ui.appendChatBox("\nAI: No User found with that ID");
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ui.appendChatBox("\nAI: Operation Cancelled");
            }
        } else {
            ui.appendChatBox("\nAI: You dont have authority for this operation");
        }
    }

    public static void selectUserById(int id, AiUi ui) {

        String sql = "SELECT accId, fullName FROM bankingaccounts WHERE accId = ?";
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to search for this user id?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = dbconn.connect(); PreparedStatement pst = conn.prepareStatement(sql)) {

                pst.setInt(1, id);
                if (id == 0) {
                    ui.appendChatBox("\nAI: Invalid Input");
                } else {
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        // Assuming columns exist
                        int userId = rs.getInt("accId");
                        String name = rs.getString("fullname");

                        ui.appendChatBox("\nAI: User Found ( ");
                        ui.appendChatBox("ID: " + userId);
                        ui.appendChatBox(" | Name: " + name + " )");

                    } else {
                        ui.appendChatBox("\nAI: No User found with that ID");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
                ui.appendChatBox("\nAI: Error fetching user");
            }
        } else {
            ui.appendChatBox("\nAI: Operation Cancelled");
        }
    }

    public static void selectUserByName(String fname, AiUi ui) {

        String sql = "SELECT accId, fullName FROM bankingaccounts WHERE fullName = ?";
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to search for this user name?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = dbconn.connect(); PreparedStatement pst = conn.prepareStatement(sql)) {

                pst.setString(1, fname);

                if (fname == null || fname.trim().equals("") || fname.equals("string")) {
                    ui.appendChatBox("\nAI: Invalid Input");
                } else {
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        // Assuming columns exist
                        int userId = rs.getInt("accId");
                        String name = rs.getString("fullname");

                        ui.appendChatBox("\nAI: User Found ( ");
                        ui.appendChatBox("ID: " + userId);
                        ui.appendChatBox(" | Name: " + name + " )");

                    } else {
                        ui.appendChatBox("\nAI: No User found with that name");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                ui.appendChatBox("\nAI: Error fetching user");
            }
        } else {
            ui.appendChatBox("\nAI: Operation Cancelled");
        }
    }

    public static void Transfer(int accID, double amount, AiUi ui) {
        int userId = AiUi.accId;

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to transfer this money?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            double oldSavings1 = 0.0;
            double oldSavings2 = 0.0;

            try (Connection conn = dbconn.connect()) {
                String old1 = "select* from bankingaccounts";
                PreparedStatement stmt1 = conn.prepareStatement(old1);
                ResultSet rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    int id = rs1.getInt("accId");
                    double savings = rs1.getDouble("sBalance");
                    if (userId == id) {
                        oldSavings1 = savings;
                    }
                }

                String sql1 = "update bankingAccounts set sBalance = ? where accId=?";
                PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                pstmt1.setDouble(1, oldSavings1 - amount);
                pstmt1.setInt(2, userId);
                int rowsAffected = pstmt1.executeUpdate();
                //////////////////////////////////////////////////////
            PreparedStatement stmt2 = conn.prepareStatement(old1);
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    int id = rs2.getInt("accId");
                    double savings = rs2.getDouble("sBalance");
                    if (accID == id) {
                        oldSavings2 = savings;
                    }
                }

                String sql2 = "update bankingAccounts set sBalance = ? where accId=?";
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setDouble(1, oldSavings2 + amount);
                pstmt2.setInt(2, accID);
                if (amount > 0) {
                    String sqlTransact = "INSERT INTO transactions(transacId,accId,amount,transacType,transactTo) VALUES(null, ?, ?, ?,?)";
                    PreparedStatement pstmtTransact = conn.prepareStatement(sqlTransact);
                    pstmtTransact.setInt(1, userId);
                    pstmtTransact.setDouble(2, amount);
                    pstmtTransact.setString(3, "Transfer");
                    pstmtTransact.setInt(4, accID);
                    int totalAffected = pstmt2.executeUpdate() + rowsAffected;

                    if (rowsAffected > 0) {
                        pstmtTransact.executeUpdate();
                        ui.appendChatBox("\nAI: Money has been transferred");
                    }
                    String sql3 = "update bankingAccounts set totalTrans = ? where accId=?";
                    PreparedStatement pstmt3 = conn.prepareStatement(sql3);

                    pstmt3.setDouble(1, cdb.getTotalTrans(userId) + amount);
                    pstmt3.setInt(2, userId);

                    pstmt3.executeUpdate();
                } else {
                    ui.appendChatBox("\nAI: Invalid input");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            ui.appendChatBox("\nAI: Operation Cancelled");
        }

    }

    public static void setSavingsDeposit(double newSavings, AiUi ui) {
        int accID = AiUi.accId;
        double oldSavings = 0.0;
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to deposit this money?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = dbconn.connect()) {
                String old = "select* from bankingAccounts";
                PreparedStatement stmt = conn.prepareStatement(old);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("accId");
                    double savings = rs.getDouble("sBalance");
                    if (accID == id) {
                        oldSavings = savings;
                    }
                }
                cdb.setTotalDep(accID, newSavings);
                String sqlTransact = "INSERT INTO transactions(transacId,accId,amount,transacType,transactTo) VALUES(null, ?, ?, ?,?)";
                PreparedStatement pstmtTransact = conn.prepareStatement(sqlTransact);
                pstmtTransact.setInt(1, accID);
                pstmtTransact.setDouble(2, newSavings);
                pstmtTransact.setString(3, "Deposit");
                pstmtTransact.setString(4, "Cash");

                String sql = "update bankingAccounts set sBalance = ? where accId=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, oldSavings + newSavings);
                pstmt.setInt(2, accID);

                if (newSavings == 0) {
                    ui.appendChatBox("\nAI: Invalid input");
                } else {
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        pstmtTransact.executeUpdate();
                        ui.appendChatBox("\nAI: Deposit Successfull");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            ui.appendChatBox("\nAI: Operation Cancelled");
        }
    }

    public static void setSavingsWithdraw(double newSavings, AiUi ui) {
        int accID = AiUi.accId;
        double oldSavings = 0.0;
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to withdraw this money?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {

            try (Connection conn = dbconn.connect()) {
                String old = "select* from bankingAccounts";
                PreparedStatement stmt = conn.prepareStatement(old);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("accId");
                    double savings = rs.getDouble("sBalance");
                    if (accID == id) {
                        oldSavings = savings;
                    }
                }

                cdb db = new cdb();
                db.setTotalWith(accID, newSavings);
                String sql = "update bankingAccounts set sBalance = ? where accId=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                if (oldSavings >= newSavings) {
                    if (newSavings <= 0) {
                        ui.appendChatBox("\nAI: Invalid Amount");
                    } else {
                        pstmt.setDouble(1, oldSavings - newSavings);
                        pstmt.setInt(2, accID);

                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            String sqlTransact = "INSERT INTO transactions(transacId,accId,amount,transacType,transactTo) VALUES(null, ?, ?, ?,?)";
                            PreparedStatement pstmtTransact = conn.prepareStatement(sqlTransact);
                            pstmtTransact.setInt(1, accID);
                            pstmtTransact.setDouble(2, newSavings);
                            pstmtTransact.setString(3, "Withdraw");
                            pstmtTransact.setString(4, "Cash");
                            pstmtTransact.executeUpdate();
                            ui.appendChatBox("\nAI: Withdraw successfull");
                        }
                    }

                } else {
                    ui.appendChatBox("\nAI: Invalid Amount");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            ui.appendChatBox("\nAI: Operation Cancelled");
        }

    }

    public static void setAddLoan(double InputAmount, AiUi ui) {
        int id = AiUi.accId;

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to borrow this money?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {

            try (Connection conn = dbconn.connect()) {
                String sql = "update bankingAccounts set lBalance = ? WHERE accId = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);

                double amountdb = cdb.getTotalLoan(id);
                amountdb += InputAmount;

                stmt.setDouble(1, amountdb);
                stmt.setInt(2, id);
                if (InputAmount < 0) {
                    ui.appendChatBox("Invalid input");
                } else {
                    stmt.executeUpdate();
                }

                String sqlTransact = "INSERT INTO transactions(transacId,accId,amount,transacType,transactTo) VALUES(null, ?, ?, ?,?)";
                PreparedStatement pstmtTransact = conn.prepareStatement(sqlTransact);
                pstmtTransact.setInt(1, id);
                pstmtTransact.setDouble(2, InputAmount);
                pstmtTransact.setString(3, "Loan");
                pstmtTransact.setString(4, "Account");
                pstmtTransact.executeUpdate();
                ui.appendChatBox("\nAI: Loan Successful");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            ui.appendChatBox("\nAI: Operation Cancelled");
        }
    }

    public static void payLoan(double payloan, AiUi ui) {

        int id = AiUi.accId;
        try (Connection conn = dbconn.connect()) {
            String sql = "update bankingAccounts set lBalance = ? WHERE accId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            double rLoan = cdb.getTotalLoan(id) - payloan;

            stmt.setDouble(1, rLoan);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            String sqlTransact = "INSERT INTO transactions(transacId,accId,amount,transacType,transactTo) VALUES(null, ?, ?, ?,?)";
            PreparedStatement pstmtTransact = conn.prepareStatement(sqlTransact);
            pstmtTransact.setInt(1, id);
            pstmtTransact.setDouble(2, payloan);
            pstmtTransact.setString(3, "Loan Payment");
            pstmtTransact.setString(4, "Cash");
            if (payloan > 0) {
                pstmtTransact.executeUpdate();
                ui.appendChatBox("\nAI: Payment Successful");
            } else {
                ui.appendChatBox("\nAI: Input Error");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //chat
    public static void chatBot(String response, AiUi ui) {

        ui.appendChatBox("\nAI: " + response);

    }
}
