/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author Syncro
 */
public class ErrorManager {
    private static final String[] Error ={
      "                                     INVALID INPUT!",
      "                                         INSUFFICIENT BALANCE!",
      "                                         CONNECTION TIMEOUT",
      "                              INCORRECT CREDENTIALS"
    };
    
    public static void showError(java.awt.Frame parent, int errorIndex){
        ErrorModal modal = new ErrorModal(parent, true);
        modal.setMessage(Error[errorIndex]);
        modal.setVisible(true);
    }
}
