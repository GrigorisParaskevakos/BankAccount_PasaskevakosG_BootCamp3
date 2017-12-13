package mainapplication;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static mainapplication.ApplicationMenus.clearConsole;
import static mainapplication.DataBaseAccess.rs;

public class InternalBankAccounts extends DataBaseAccess {

    //transaction user
    //private String passiveUser;
    private int passiveUserID;
    private double passiveUserAmount;
    static double tempAmount;
    private double userInputAmount;

    //Admin View Cooperative's (super admin) internal bank account
    private String sql = "SELECT afdemp_java_1.users.id, afdemp_java_1.users.username, afdemp_java_1.accounts.amount, afdemp_java_1.accounts.transaction_date FROM afdemp_java_1.users, afdemp_java_1.accounts WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id =1";
    //Admin View Member's bank accounts 
    private String sql2 = "SELECT afdemp_java_1.users.id, afdemp_java_1.users.username, afdemp_java_1.accounts.amount, afdemp_java_1.accounts.transaction_date FROM afdemp_java_1.users, afdemp_java_1.accounts WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id > 1";
    //Simple User View Member's bank accounts info
    private String sql5 = "SELECT afdemp_java_1.users.id, afdemp_java_1.users.username FROM afdemp_java_1.users, afdemp_java_1.accounts WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id >= 1";

    private void accessAdminAccount() {
        try {
            rs = stmt.executeQuery(sql);
            System.out.println("\nConnected: " + getActiveUser() + "\nView: Super admin accout");
            System.out.println("---+-------+-----------------+----------------------------");
            System.out.printf("%2s |%5s  |%15s  | %21s", "ID", "USER", "AMMOUNT", "Transaction date\n");
            System.out.println("---+-------+-----------------+----------------------------");
            while (rs.next()) {

                System.out.printf("%2d |%5s  |%15f  | %21s%n", this.rs.getInt(1), this.rs.getString(2),
                        this.rs.getDouble(3), this.rs.getString(4));
                System.out.println("---+-------+-----------------+----------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getAccessAdminAccount() {
        this.accessAdminAccount();
    }

    /**
     * Super Admin view Simple Users account
     */
    private void accessAdminMembersAccount() {
        try {
            rs = stmt.executeQuery(sql2);
            System.out.println("\nConnected: " + getActiveUser() + "\nView: All simple users' accouts");
            System.out.println("---+-------+-----------------+----------------------------");
            System.out.printf("%2s |%5s  |%15s  | %21s", "ID", "USER", "AMMOUNT", "Transaction date\n");
            System.out.println("---+-------+-----------------+----------------------------");
            while (rs.next()) {
                //System.out.printf(this.rs.getInt(1) + "   | " + this.rs.getString(2) + "  |" + this.rs.getDouble(3) + "   |" + this.rs.getString(4) + "\n");
                System.out.printf("%2d |%5s  |%15f  | %21s%n", this.rs.getInt(1), this.rs.getString(2),
                        this.rs.getDouble(3), this.rs.getString(4));
                System.out.println("---+-------+-----------------+----------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getAccessAdminMembersAccount() {
        this.accessAdminMembersAccount();
    }

    /**
     * Simple Member view Users info
     */
    private void accessSimpleMembersInfo() {
        try {
            rs = stmt.executeQuery(sql5);
            System.out.println("\nConnected: " + getActiveUser() + "\nView: All users' info");
            System.out.println("---+-----+");
            System.out.printf("%2s|%5s", "ID ", "USER\n");
            System.out.println("---+-----+");
            while (rs.next()) {
                System.out.printf("%2d |%5s %n", this.rs.getInt(1), this.rs.getString(2));
                System.out.println("---+-----+");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getAccessSimpleMembersInfo() {
        this.accessSimpleMembersInfo();
    }

    /**
     * User view Simple Users account
     */
    private void accessUserMembersAccount() {
        try {
            String sql3 = "SELECT afdemp_java_1.users.id, afdemp_java_1.users.username, afdemp_java_1.accounts.amount, afdemp_java_1.accounts.transaction_date FROM afdemp_java_1.users, afdemp_java_1.accounts WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id = '"
                    + getActiveUserID() + "'";
            rs = stmt.executeQuery(sql3);
            System.out.println("\nConnected: " + getActiveUser() + "\nView: All simple users' accouts");
            System.out.println("---+-------+-----------------+----------------------------");
            System.out.printf("%2s |%5s  |%15s  | %21s", "ID", "USER", "AMMOUNT", "Transaction date\n");
            System.out.println("---+-------+-----------------+----------------------------");
            while (rs.next()) {
                //System.out.printf(this.rs.getInt(1) + "   | " + this.rs.getString(2) + "  |" + this.rs.getDouble(3) + "   |" + this.rs.getString(4) + "\n");
                System.out.printf("%2d |%5s  |%15f  | %21s%n", this.rs.getInt(1), this.rs.getString(2),
                        this.rs.getDouble(3), this.rs.getString(4));
                System.out.println("---+-------+-----------------+----------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getAccessUserMembersAccount() {
        this.accessUserMembersAccount();
    }

    //ask user for input amount
    void setTransactionAmount() {
        try {
            Scanner input = new Scanner(System.in, "utf-8");
            this.userInputAmount = input.nextDouble();
        } catch (InputMismatchException e) {
            clearConsole();
            System.out.println("\n\n*-----------------------------------------------------------*");
            System.out.println("|  NEW MESSAGE: Amount must be NUMERIC! Please retry...     |");
            System.out.println("*-----------------------------------------------------------*\n\n");
            System.out.println("Please select a NUMERIC positive amount: ");
            setTransactionAmount();
        }
    }

    //return the transaction ammount
    double getTransactionAmount() {
        return userInputAmount;
    }

    //checks if able to deposit
    private boolean depositMemberAccount() {
        setTransactionAmount();
        tempAmount = getActiveUserAmount() - getTransactionAmount();
        //System.out.println("tempAmount = " + tempAmount);
        if (tempAmount >= 0) {
            setActiveUserAmount(tempAmount);
        } else {
            return false;
        }
        return true;
    }

    boolean getDepositMemberAccount() {
        return depositMemberAccount();
    }

    void getCheckedDepositMemberAccount() {
        getTransactionAmount();
    }

    //Update ActiveUserAmount
    private void updateActiveAccount() {
        try {
            double newActiveUserAmmount = getActiveUserAmount();
            String sql3 = "UPDATE afdemp_java_1.accounts SET afdemp_java_1.accounts.amount = ? WHERE afdemp_java_1.accounts.user_id = ? ";
            //System.out.println("active user ID: " + getActiveUserID());
            pstmt = con.prepareStatement(sql3);
            pstmt.setDouble(1, newActiveUserAmmount);
            pstmt.setInt(2, getActiveUserID());
            pstmt.executeUpdate();
            //System.out.println("NEW active amount = " + newActiveUserAmmount);
            //System.out.println("active ID = " + getActiveUserID());
        } catch (SQLException ex) {
            System.out.println("\n\n*----------------------------------*");
            System.out.println("|  NEW MESSAGE: Update FAILED!     |");
            System.out.println("*----------------------------------*\n\n");

            //ex.printStackTrace();
        }
    }

    void getUpdateActiveAccount() {
        updateActiveAccount();
    }

    // get PassiveUserAmount
    private double tempCheckPassiveUserAmount() {
        try {
            String sql = "SELECT afdemp_java_1.users.id, afdemp_java_1.accounts.amount FROM afdemp_java_1.users,afdemp_java_1.accounts  WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id = '"
                    + getSelectUserID() + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                passiveUserAmount = rs.getDouble(2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return passiveUserAmount;

    }

    double getTempCheckPassiveUserAmount() {
        return tempCheckPassiveUserAmount();
    }

    //checks if able to withdraw
    private boolean withdrawMemberAccount() {
        setTransactionAmount();
        double passiveTempAmount = getTempCheckPassiveUserAmount() - getTransactionAmount();
        //System.out.println("tempAmount = " + tempAmount);
        if (passiveTempAmount >= 0) {
            tempAmount = getActiveUserAmount() + getTransactionAmount();
            setActiveUserAmount(tempAmount);
            setPassiveUserAmount(passiveTempAmount);
        } else {
            return false;
        }
        return true;
    }

    boolean getWithdrawMemberAccount() {
        return withdrawMemberAccount();
    }

    void getCheckedWithdrawMemberAccount() {
        getTransactionAmount();
    }

    //Update PassiveUserAmount for deposit
    private void updatePassiveAccount() {
        try {
            String sql = "SELECT afdemp_java_1.users.id, afdemp_java_1.accounts.amount FROM afdemp_java_1.users,afdemp_java_1.accounts  WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id = '"
                    + getSelectUserID() + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                passiveUserAmount = rs.getDouble(2);
                double newPassiveUserAmount = passiveUserAmount + getTransactionAmount();
                String sql4 = "UPDATE afdemp_java_1.accounts SET afdemp_java_1.accounts.amount = '"
                        + newPassiveUserAmount + "' WHERE afdemp_java_1.accounts.user_id = '" + getSelectUserID() + "'";
                pstmt = con.prepareStatement(sql4);
                pstmt.executeUpdate();
                System.out.println("\n\n*-----------------------------------------*");
                System.out.println("|  NEW MESSAGE: Successfully Deposit!     |");
                System.out.println("*-----------------------------------------*\n\n");
            } else {
                System.out.println("\n\n*-------------------------------*");
                System.out.println("|  Please enter a valid ID!     |");
                System.out.println("*-------------------------------*\n\n");

            }
        } catch (SQLException ex) {
            System.out.println("\n\n*----------------------*");
            System.out.println("|  Deposit FAILED!     |");
            System.out.println("*----------------------*\n\n");
            ex.printStackTrace();
        }
    }

    void getUpdatePassiveAccount() {
        updatePassiveAccount();
    }

    //if passive user update is admin 
    private void updatePassiveAdminAccount() {
        try {
            String sql = "SELECT afdemp_java_1.users.id, afdemp_java_1.accounts.amount FROM afdemp_java_1.users,afdemp_java_1.accounts  WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id = 1 ";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                passiveUserAmount = rs.getDouble(2);
                double newPassiveUserAmount = passiveUserAmount + getTransactionAmount();
                String sql4 = "UPDATE afdemp_java_1.accounts SET afdemp_java_1.accounts.amount = '"
                        + newPassiveUserAmount + "' WHERE afdemp_java_1.accounts.user_id = 1 ";
                pstmt = con.prepareStatement(sql4);
                pstmt.executeUpdate();
                System.out.println("\n\n*-----------------------------------------*");
                System.out.println("|  NEW MESSAGE: Successfully Deposit!     |");
                System.out.println("*-----------------------------------------*\n\n");

            }
        } catch (SQLException ex) {
            System.out.println("\n\n*----------------------*");
            System.out.println("|  Deposit FAILED!     |");
            System.out.println("*----------------------*\n\n");
            ex.printStackTrace();
        }
    }

    void getUpdatePassiveAdminAccount() {
        updatePassiveAdminAccount();
    }

    //Update PassiveUserAmount for withdaw
    private void updatePassiveAccountWithdaw() {
        try {
            String sql = "SELECT afdemp_java_1.users.id, afdemp_java_1.accounts.amount FROM afdemp_java_1.users,afdemp_java_1.accounts  WHERE afdemp_java_1.users.id = afdemp_java_1.accounts.user_id AND afdemp_java_1.users.id = '"
                    + getSelectUserID() + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                passiveUserAmount = rs.getDouble(2);
                double newPassiveUserAmount = passiveUserAmount - getTransactionAmount();
                String sql4 = "UPDATE afdemp_java_1.accounts SET afdemp_java_1.accounts.amount = '"
                        + newPassiveUserAmount + "' WHERE afdemp_java_1.accounts.user_id = '" + getSelectUserID() + "'";
                pstmt = con.prepareStatement(sql4);
                pstmt.executeUpdate();
                System.out.println("\n\n*-----------------------------------------*");
                System.out.println("|  NEW MESSAGE: Successfully withdaw!     |");
                System.out.println("*-----------------------------------------*\n\n");

            }
        } catch (SQLException ex) {
            System.out.println("\n\n*----------------------*");
            System.out.println("|  Deposit FAILED!     |");
            System.out.println("*----------------------*\n\n");
            ex.printStackTrace();
        }
    }

    void getUpdatePassiveAccountWithdaw() {
        updatePassiveAccountWithdaw();
    }

    //set passiveUserAmount
    void setPassiveUserAmount(double passiveUserAmount) {
        this.passiveUserAmount = passiveUserAmount;
    }

    private boolean checkPassiveUserAmount() {
        String sql = "SELECT accounts.user_id, users.username, users.password, accounts.amount FROM afdemp_java_1.users,afdemp_java_1.accounts  WHERE accounts.user_id = ? ";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, getSelectUserID());
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("\n\n*-----------------------------------------------*");
            System.out.println("|  NEW MESSAGE: amount error, please retry!     |");
            System.out.println("*-----------------------------------------------*\n\n");

            ex.printStackTrace();
        }
        try {
            while (rs.next()) {
                this.passiveUserAmount = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InternalBankAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }//end Credentials()

    double getCheckPassiveUserAmount() {
        return this.passiveUserAmount;
    }

    //Select a user ID to deposit or withdraw
    void selectUserID() {
        try {
            Scanner input = new Scanner(System.in);
            this.passiveUserID = (int) input.nextInt();
        } catch (InputMismatchException e) {
            getSelectUserID();
        }
    }

    int getSelectUserID() {
        return passiveUserID;
    }

}//end InternalBankAccounts
