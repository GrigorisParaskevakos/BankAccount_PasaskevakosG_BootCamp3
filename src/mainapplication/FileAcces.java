/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileAcces extends InternalBankAccounts {

    public FileAcces() {
        super();
    }

    /**
     * Date & Time formats
     */
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    Date date = new Date();

    public String transactionDateStamp() {
        return dateFormat.format(date);
    }

    DateFormat dateTimeFormat = new SimpleDateFormat("(dd-MM-yy)HH.mm.ss");
    Date dateTime = new Date();

    public String transactionDateTimeStamp() {
        return dateTimeFormat.format(dateTime);
    }

    DateFormat dateTimeFormatFile = new SimpleDateFormat("dd/MM/yy | HH:mm:ss");
    Date dateTimeFile = new Date();

    public String transactionDateTimeStampFile() {
        return dateTimeFormatFile.format(dateTimeFile);
    }

    /**
     * Create directory
     */
    private void createLogDirActiveUser() {
        transactionDateStamp();
        transactionDateTimeStamp();
        transactionDateTimeStampFile();
        String path = "C:\\Today's_Statements\\";
        String path2 = "Statement_" + getActiveUser() + "_" + transactionDateStamp() + "\\";
        File f = new File(path + path2);
        boolean check = f.isDirectory();
        if (check) {
            //System.out.println("Press enter...");
        } else {
            //System.out.println("Statements for " + getActiveUser() + "Created!");           
            //System.out.println("Press enter...");
            if (f.mkdirs()) {
                System.out.println("\n\n*----------------------------------------*");
                System.out.println("|  Directory for Statements Created!     |");
                System.out.println("*----------------------------------------*\n\n");
            }
        }
    }

    void getCreateLogDirActiveUser() {
        createLogDirActiveUser();
    }

    /**
     * Create files for deposits Logs
     */
    private void createLogFileDeposits() {
        transactionDateStamp();
        transactionDateTimeStamp();
        transactionDateTimeStampFile();
        String path = "C:\\Today's_Statements\\";
        String path2 = "Statement_" + getActiveUser() + "_" + transactionDateStamp() + "\\";
        PrintWriter writer;
        String fileName = getActiveUser() + transactionDateTimeStamp() + ".txt";
        try {
            writer = new PrintWriter(path + path2 + fileName, "UTF-8");
            writer.println("User-ID: " + getActiveUserID());
            writer.println("User Name: " + getActiveUser());
            double d = getActiveUserAmount();
            String s = formatAmount(d);
            writer.println("Current Balance: " + s + " \u20ac");
            writer.println("Action: Deposit");
            writer.println("Transaction Date Time: " + transactionDateTimeStampFile());
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            //System.out.println("Ooop File not found!");
            ex.printStackTrace();
        }
    }

    void getCreateLogFileDeposits() {
        createLogFileDeposits();
    }

    /////////////////////////////////////////////////////
    /**
     * Create files for Withdraw Logs
     */
    private void createLogFileWithdraw() {
        transactionDateStamp();
        transactionDateTimeStamp();
        transactionDateTimeStampFile();
        String path = "C:\\Today's_Statements\\";
        String path2 = "Statement_" + getActiveUser() + "_" + transactionDateStamp() + "\\";
        PrintWriter writer;
        String fileName = getActiveUser() + transactionDateTimeStamp() + ".txt";
        try {
            writer = new PrintWriter(path + path2 + fileName, "UTF-8");
            writer.println("User-ID: " + getActiveUserID());
            writer.println("User Name: " + getActiveUser());
            double d2 = getActiveUserAmount();
            String s2 = formatAmount(d2);
            writer.println("Current Balance: " + s2 + " \u20ac");
            writer.println("Action: Withdraw");
            writer.println("Transaction Date Time: " + transactionDateTimeStampFile());
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            //System.out.println("Ooop File not found!");
            ex.printStackTrace();
        }
    }

    void getCreateLogFileWithdraw() {
        createLogFileWithdraw();
    }
}
