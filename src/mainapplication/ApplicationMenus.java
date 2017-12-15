package mainapplication;

import java.io.IOException;

/**
 *
 * @author Paraskevakos Grigoris
 */
public class ApplicationMenus {

    private static void adminMenu() {
        DataBaseAccess myDB = new DataBaseAccess();
        LoginScreen myLogin = new LoginScreen();
        InternalBankAccounts myAdminAccount = new InternalBankAccounts();
        FileAcces adminLog = new FileAcces();
        adminLog.getCreateLogDirActiveUser();
        System.out.printf("\n1. View Cooperative's (super admin) internal bank account\n");
        System.out.println("2. View Member's bank accounts");
        System.out.println("3. Deposit to Member's bank accounts");
        System.out.println("4. Withdraw from Member's bank accounts");
        System.out.println("5. Send to log file today's transactions");
        System.out.println("6. Exit the application");
        System.out.print("Please choose an option from 1 to 6: ");
        String choise = " ";
        do {
            choise = myLogin.getchoice();
            switch (choise) {
            case "1":
                clearConsole();
                myAdminAccount.getAccessAdminAccount();
                break;
            case "2":
                clearConsole();
                myAdminAccount.getAccessAdminMembersAccount();
                break;
            case "3":
                clearConsole();
                myAdminAccount.getAccessAdminMembersAccount();
                System.out.println("Please select a user ID to deposit: ");
                myAdminAccount.selectUserID();
                if ((myAdminAccount.getSelectUserID() > 1) && (myAdminAccount.getSelectUserID() <= 3)) {
                    System.out.print("Please select a positive amount to deposit: ");
                    if (myAdminAccount.getDepositMemberAccount() == true) {
                        myAdminAccount.getCheckedDepositMemberAccount();
                        myAdminAccount.getUpdateActiveAccount();
                        clearConsole();
                        myAdminAccount.getUpdatePassiveAccount();
                        myAdminAccount.getInsertDepositLog();
                        adminLog.getCreateLogFileDeposits();
                    } else {
                        clearConsole();
                        System.out.println("\n\n*-------------------------------------------------------*");
                        System.out.println("|  NEW MESSAGE: Insaficient amount! Please retry...     |");
                        System.out.println("*-------------------------------------------------------*\n\n");
                    }
                } else {
                    clearConsole();
                    System.out.println("\n\n*---------------------------------------------*");
                    System.out.println("|  NEW MESSAGE: WRONG ID! Please retry...     |");
                    System.out.println("*---------------------------------------------*\n\n");

                }
                break;
            case "4":
                clearConsole();
                myAdminAccount.getAccessAdminMembersAccount();
                System.out.println("Please select a user ID to withdraw: ");
                myAdminAccount.selectUserID();
                if ((myAdminAccount.getSelectUserID() > 1) && (myAdminAccount.getSelectUserID() <= 3)) {
                    System.out.println("Please select a positive amount to withdraw: ");
                    if (myAdminAccount.getWithdrawMemberAccount() == true) {
                        myAdminAccount.getCheckedWithdrawMemberAccount();
                        myAdminAccount.getUpdateActiveAccount();
                        clearConsole();
                        myAdminAccount.getUpdatePassiveAccountWithdaw();
                        myAdminAccount.getInsertWithdrawtLog();
                        adminLog.getCreateLogFileWithdraw();
                    } else {
                        clearConsole();
                        System.out.println("\n\n*-------------------------------------------------------*");
                        System.out.println("|  NEW MESSAGE: Insaficient amount! Please retry...     |");
                        System.out.println("*-------------------------------------------------------*\n\n");
                    }
                } else {
                    clearConsole();
                    System.out.println("\n\n*---------------------------------------------*");
                    System.out.println("|  NEW MESSAGE: WRONG ID! Please retry...     |");
                    System.out.println("*---------------------------------------------*\n\n");

                }
                break;

            case "5":
                clearConsole();
                myAdminAccount.getInsertDepositLog();
                myAdminAccount.getInsertWithdrawtLog();
                //just to check wtf is going on with logs
                //myAdminAccount.getAccessDepositViewUsers();
                System.out.println("\n\n*---------------------------------------*");
                System.out.println("|  NEW MESSAGE: Statements Updated!     |");
                System.out.println("*---------------------------------------*\n\n");
                break;
            case "6":
                DelayThread myTimeThread = new DelayThread();
                System.out.printf("\nPrivate Banking System is shutting down");
                myAdminAccount.getDropDepositsView();
                myAdminAccount.getDropDepositsViewUsers();
                myAdminAccount.getDropWithdrawView();
                myAdminAccount.getDropWithdrawViewUsers();
                for (int count = 5; count > 0; count--) {
                    System.out.printf(".");
                    myTimeThread.delay(1000);
                }
                System.out.printf("\n");
                myLogin.getScannerClose();
                myDB.getdbDisConnect();
                System.exit(0);
                break;
            default:
                clearConsole();
                System.out.println("\n\n*-------------------------------------------------*");
                System.out.println("|  NEW MESSAGE: WRONG CHOICE! Please retry...     |");
                System.out.println("*-------------------------------------------------*\n\n");
                adminMenu();
            }
        } while (!choise.equals("1") && !choise.equals("2") && !choise.equals("3") && !choise.equals("4")
                && !choise.equals("5") && !choise.equals("6"));
        adminMenu();
    }//end AdminMenu

    void getAdminMenu() {
        adminMenu();
    }

    /**
     * Display simple user menu
     */
    private static void SimpleUserMenu() {
        DataBaseAccess myDB = new DataBaseAccess();
        LoginScreen myLogin = new LoginScreen();
        InternalBankAccounts myUserAccount = new InternalBankAccounts();
        FileAcces userLog = new FileAcces();
        userLog.getCreateLogDirActiveUser();
        System.out.printf("\n1. View account\n");
        System.out.println("2. Deposit to Cooperative's (super admin) bank accounts");
        System.out.println("3. Deposit to a Member's bank accounts");
        System.out.println("4. Send to log file today's transactions");
        System.out.println("5. Exit the application");
        System.out.print("Please choose an option from 1 to 5: ");
        String choise = " ";
        do {
            choise = myLogin.getchoice();
            switch (choise) {
            case "1":
                clearConsole();
                myUserAccount.getAccessUserMembersAccount();

                break;
            case "2":
                clearConsole();
                System.out.println("Please select a positive amount to deposit: ");
                if (myUserAccount.getDepositMemberAccount() == true) {
                    myUserAccount.getCheckedDepositMemberAccount();
                    myUserAccount.getUpdateActiveAccount();
                    clearConsole();
                    myUserAccount.getUpdatePassiveAdminAccount();
                    myUserAccount.getInsertDepositLog();
                    userLog.getCreateLogFileDeposits();
                } else {
                    clearConsole();
                    System.out.println("\n\n*-------------------------------------------------------*");
                    System.out.println("|  NEW MESSAGE: Insaficient amount! Please retry...     |");
                    System.out.println("*-------------------------------------------------------*\n\n");
                }
                break;
            case "3":
                clearConsole();
                myUserAccount.getAccessSimpleMembersInfo();
                System.out.println("Please select a user ID to deposit: ");
                myUserAccount.selectUserID();
                if (myUserAccount.getSelectUserID() == myDB.getActiveUserID()) {
                    clearConsole();
                    System.out.println(
                            "\n\n*-----------------------------------------------------------------------------------------*");
                    System.out.println(
                            "|  NEW MESSAGE: Try not to deposit to your account from your account! Please retry...     |");
                    System.out.println(
                            "*-----------------------------------------------------------------------------------------*\n\n");
                } else if ((myUserAccount.getSelectUserID() >= 1) && (myUserAccount.getSelectUserID() <= 3)) {
                    System.out.println("Please select a positive amount to deposit: ");
                    if (myUserAccount.getDepositMemberAccount() == true) {
                        myUserAccount.getCheckedDepositMemberAccount();
                        myUserAccount.getUpdateActiveAccount();
                        clearConsole();
                        myUserAccount.getUpdatePassiveAccount();
                        myUserAccount.getInsertDepositLog();
                        userLog.getCreateLogFileDeposits();
                    } else {
                        clearConsole();
                        System.out.println("\n\n*-------------------------------------------------------*");
                        System.out.println("|  NEW MESSAGE: Insaficient amount! Please retry...     |");
                        System.out.println("*-------------------------------------------------------*\n\n");
                    }
                } else {
                    clearConsole();
                    System.out.println("\n\n*---------------------------------------------*");
                    System.out.println("|  NEW MESSAGE: WRONG ID! Please retry...     |");
                    System.out.println("*---------------------------------------------*\n\n");

                }
                break;
            case "4":
                clearConsole();
                myUserAccount.getInsertDepositLog();
                System.out.println("\n\n*---------------------------------------*");
                System.out.println("|  NEW MESSAGE: Statements Updated!     |");
                System.out.println("*---------------------------------------*\n\n");
                break;
            case "5":
                DelayThread myTimeThread = new DelayThread();
                System.out.printf("\nPrivate Banking System is shutting down");
                myUserAccount.getDropDepositsView();
                myUserAccount.getDropDepositsViewUsers();
                myUserAccount.getDropWithdrawView();
                myUserAccount.getDropWithdrawViewUsers();
                for (int count = 5; count > 0; count--) {
                    System.out.printf(".");
                    myTimeThread.delay(1000);
                }
                System.out.printf("\n");
                myLogin.getScannerClose();
                myDB.getdbDisConnect();
                System.exit(0);
                break;
            default:
                clearConsole();
                System.out.println("\n\n*-------------------------------------------------*");
                System.out.println("|  NEW MESSAGE: WRONG CHOICE! Please retry...     |");
                System.out.println("*-------------------------------------------------*\n\n");
                SimpleUserMenu();
            }
        } while (!choise.equals("1") && !choise.equals("2") && !choise.equals("3") && !choise.equals("4")
                && !choise.equals("5"));
        SimpleUserMenu();
    }//end SimpleUserMenu

    void getSimpleUserMenu() {
        SimpleUserMenu();
    }

    /**
     * Clear the console
     */
    static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }
}//end ApplicationMenus
