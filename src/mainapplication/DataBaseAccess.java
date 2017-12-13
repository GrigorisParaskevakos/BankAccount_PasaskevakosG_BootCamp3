/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GT780
 */
public class DataBaseAccess {

    private static final String myConnectionURL = "jdbc:mysql://localhost:3306/afdemp_java_1";
    private static final String myConnectionUserName = "afdemp";
    private static String myConnectionPassword = "12345";
    /**
     * Db variables
     */
    static Connection con = null;
    static Statement stmt = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    private static String activeUser;
    private static int activeUserID;
    private static double activeUserAmount;

    /**
     * boolean flags to control authentication and loops
     */
    private static boolean flag1 = false;//checking error credentials, loop 

    /**
     * connect to DB
     */
    private static void dbConnect() {
        try {
            //check JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            ApplicationMenus clearThis = new ApplicationMenus();
            clearThis.clearConsole();
            System.out.println("JDBC installed");
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC went wrong");
        }

        try {
            //connect to DB
            con = DriverManager.getConnection(myConnectionURL, myConnectionUserName, myConnectionPassword);
            System.out.println("connected to DB afdemp_java_1\n");
            System.out.println("Private Banking System is running...\n");
        } catch (SQLException ex) {
            //Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DB connection went wrong");
        }
    }//end dbConnect

    void getdbConnect() {
        dbConnect();
    }

    /**
     * Disconnect from DB
     */
    private void dbDisConnect() {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//end dbDisConnect

    /**
     * access dbDisConnect()
     */
    void getdbDisConnect() {
        dbDisConnect();
        System.out.println("Disconnected!");
        DelayThread myTimeThread = new DelayThread();
        myTimeThread.delay(1500);
    }

    /**
     * checks if user exists
     */
    private boolean checkCredentials() {
        LoginScreen myLogin = new LoginScreen();
        ApplicationMenus clearThis = new ApplicationMenus();
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = 0;//counter for password  tries
        try {
            //check if user exists
            while (flag1 == false) {
                myLogin.getuserCredentials();
                //String sql = "SELECT accounts.user_id, users.username, users.password, accounts.amount FROM afdemp_java_1.users,afdemp_java_1.accounts  WHERE username = '" + myLogin.getusername() + "' AND password ='" + myLogin.getpassword() + "'  AND accounts.user_id = users.id";
                String sql = "SELECT accounts.user_id, users.username, users.password, accounts.amount FROM afdemp_java_1.users,afdemp_java_1.accounts  WHERE username = ? AND password = ? AND accounts.user_id = users.id";
                try {
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, myLogin.getusername());
                    pstmt.setString(2, myLogin.getpassword());
                    rs = pstmt.executeQuery();
                } catch (SQLException ex) {
                    System.out.println("User does not exist!");
                }
                while (rs.next()) {
                    if ((myLogin.getusername().equals(rs.getString(2)))
                            && (myLogin.getpassword().equals(rs.getString(3)))) {
                        DataBaseAccess.activeUser = rs.getString(2);
                        this.activeUserID = rs.getInt(1);
                        this.activeUserAmount = rs.getDouble(4);
                        clearThis.clearConsole();
                        System.out.println("Connected: " + rs.getString(2) + "\n");
                    }
                    flag1 = true;//then user exists
                }
                if (flag1 == false) {
                    if (i == 2) {
                        flag1 = true;
                        System.out.println("You have enter 3 times wrong pin, come back later....\n");
                        DelayThread myTimeThread = new DelayThread();
                        System.out.printf("Application will close in ");
                        for (int count = 5; count > 0; count--) {
                            System.out.printf(count + "sec...");
                            myTimeThread.delay(1000);
                        }
                        System.out.printf("\n");
                        getdbDisConnect();
                        myTimeThread.delay(1000);
                        myLogin.getScannerClose();
                        System.exit(0);
                    }
                    clearThis.clearConsole();
                    System.out.println("\n\n*-------------------------------------------------*");
                    System.out.println("|  NEW MESSAGE: Wrong Credentials! Please retry...|");
                    System.out.println("*-------------------------------------------------*\n\n");
                    i++;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }//end Credentials()

    boolean getcheckCredentials() {
        checkCredentials();
        return true;
    }

    /**
     * return user info
     */
    String getActiveUser() {
        return activeUser;
    }

    int getActiveUserID() {
        return activeUserID;
    }

    static double getActiveUserAmount() {
        return activeUserAmount;
    }

    void setActiveUserAmount(double activeUserAmount) {
        this.activeUserAmount = activeUserAmount;
    }

}//end DataBaseAccess
