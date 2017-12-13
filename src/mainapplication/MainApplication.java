/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

/**
 *
 * @author GT780
 */
public class MainApplication {

    public static void main(String[] args) {
        DataBaseAccess myDB = new DataBaseAccess();
        LoginScreen myLogin = new LoginScreen();
        ApplicationMenus myMenu = new ApplicationMenus();
        //Check DB conectivity
        myDB.getdbConnect();
        //Check user conectivity
        myDB.getcheckCredentials();
        //Create Statements Directory
        FileAcces userLog = new FileAcces();
        userLog.getCreateLogDirActiveUser();
        userLog.getCreateLogFileActiveUser();
        //Display Menus
        if (myDB.getActiveUserID() == 1) {
            myMenu.getAdminMenu();
        } else {
            myMenu.getSimpleUserMenu();
        }
    }//end main
}//end MainApplication
