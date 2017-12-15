package mainapplication;

/**
 *
 * @author Paraskevakos Grigoris
 */
public class MainApplication {

    public static void main(String[] args) {
        DataBaseAccess myDB = new DataBaseAccess();
        ApplicationMenus myMenu = new ApplicationMenus();
        InternalBankAccounts activeLog = new InternalBankAccounts();
        //Check DB conectivity
        myDB.getdbConnect();
        //Check user conectivity
        myDB.getcheckCredentials();
        //Create Statements & Directory
        activeLog.getDepositsView();
        activeLog.getDepositsViewUsers();
        activeLog.getWithdrawView();
        activeLog.getWithdrawViewUsers();
        //Display Menus
        if (myDB.getActiveUserID() == 1) {
            myMenu.getAdminMenu();
        } else {
            myMenu.getSimpleUserMenu();
        }
    }//end main
}//end MainApplication

