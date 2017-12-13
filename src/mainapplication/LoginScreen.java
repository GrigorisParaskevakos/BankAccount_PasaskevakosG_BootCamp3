/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.util.Scanner;
import java.util.Scanner;
import java.io.Console;
import java.util.Arrays;

/**
 *
 * @author GT780
 */
public class LoginScreen {

    private String username;
    private String password;
    private String userChoice;
    private String encryptPassword;
    private String decryptPassword;

    /**
     * ask user for Credentials
     */
    private void userCredentials() {
        AdvancedEncryptionStandard myEncryption = new AdvancedEncryptionStandard();
        Scanner input = new Scanner(System.in, "utf-8");
        Console console = System.console();
        console.printf("Username: ");
        this.username = input.nextLine();

        //Password Field is not prompted
        console.printf("Password: ");
        char[] pass = console.readPassword();
        this.decryptPassword = new String(pass);
        //ecrypts input user password
        this.encryptPassword = myEncryption.encrypt(decryptPassword);
        this.password = encryptPassword;
        System.out.println();
    }

    void getuserCredentials() {
        userCredentials();
    }

    String getusername() {
        return username;
    }

    String getpassword() {
        return password;
    }

    /**
     * ask user for menu choice
     *
     * @return
     */
    private String choice(String userChoice) {
        Scanner input = new Scanner(System.in, "utf-8");
        this.userChoice = input.nextLine();
        return this.userChoice;
    }

    //return user choise
    String getchoice() {
        return choice(this.userChoice);
    }

    //close user input
    void getScannerClose() {
        Scanner input = new Scanner(System.in, "utf-8");
        input.close();
    }

}
