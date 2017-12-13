/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.util.Scanner;

/**
 *
 * @author GT780
 */
public class LoginScreen {

    private String username;
    private String password;
    private String userChoice;

    /**
     * ask user for Credentials
     */
    private void userCredentials() {
        Scanner input = new Scanner(System.in, "utf-8");
        System.out.print("Username: ");
        this.username = input.nextLine();
        System.out.print("Password: ");
        this.password = input.nextLine();
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
