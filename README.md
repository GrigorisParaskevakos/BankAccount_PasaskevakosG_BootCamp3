#Bootcamp Project1

# Author @Paraskevakos Grigoris

#Setup for OS Windows
#All files are inside BankAccount_Pasaskevakos_Grigors_BootCamp3

#Requirements :

# Java JRE (Currect jre1.8.0_131)

# Windows OS

######################################################################################################

#Definition
You are required to build a Windows console application where you will be asked to read
various inputs from the keyboard.
These inputs will be used as login details and actions in order to control the internal banking
system of a cooperative company.
Each input will be used for directing the various subsystems of this private banking system.
The output of the various subsystems will be displayed to the screen or it will be written to
simple text files.
#Deliverables
You are requested to produce a Java console application that has the following:
1. Six (6) .java files, the main application and one file per Logical Unit of the application
as described above on A. 
2. The Login Screen should be displayed first and it should let the user view the
application’s main menu after correct input of the username / password combination
which are checked against the values stored in the database table users 
3. The application’s main menu should be changed depending the level of the user as
described above on B.2. 
4. The application should let the super admin to view all the accounts and deposit or
withdraw from the simple users’ bank accounts while keeping all actions to memory
and write to statement file via Send Today’s Statement
5. The application should let the simple users to deposit to the cooperative’s bank
account an amount that is available to his bank account while keeping all actions to
memory and write to statement file via Send Today’s Statement 
6. Use the class BankAccounts as an intermediate storage for database’s data. Override
the toString() of the class BankAccount in order to show the user’s username,
transaction date, amount. Format all currency data to be displayed and written to file
with Locale(“el-GR”). Format all dates to the form “yyyy-MM-dd HH:mm:ss.SSS”. 

######################################################################################################

PS. Do not forget to open and RUN MySQL DB (MySQL Notifier)

######################################################################################################

# I F YOU HAVE MySQL installed do:

#A)
--open Folder: "Create_Connection_Steps" and follow steps till STEPS
--OPEN WORKBENCH
--CONNECT AS ROOT TO MYSQL (STEP 0)
--RUN THE SCRIPT(afdemp_new.sql), IT IS INSIDE DB DIRECTORY (STEP 0_1)
--CLOSE WORKBENCH
--OPEN WORKBENCH
--CREATE A DB CONNECTION(STEP1)
--SETUP (STEP2)
--CLOSE WORKBENCH
THEN:
---Just open "BankAccounts.bat" and Run the Application, it is ready and compiled :)
Credentials:1) admin
               admin
            2) user1
               password1
            3) user2 
               password2

# E L S E do:

    --open "mysql_How_to_install.html" and follow steps!
    --then return to #A)

######################################################################################################
**_HOW THIS PROJECT DEPLOYED_**

    I) Message: java.lang.ClassNotFoundException: com.mysql.jdbc.Driver

    1- Right click on Libraries > Click on Add Library.
    2-Scroll down to find MySQL JDBC driver.
    3-Press Shift + F11. (Clean and Build)
    4-Run

######################################################################################################
II) in order to run :
mysql-connector.jar | Paste to : C:\Program Files\Java\jre1.8.0_151\lib\ext

######################################################################################################
**_IRRELEVANT to IDE_(NetBeans)**
III) to compile and Run (Windows):
(inside the Project's working directory)

        Compile the program using javac command:
        1- javac -cp lib\mysql-connector-java-5.1.44-bin.jar -d classes src\mainapplication\*.java

        Create executable JAR file using jar command:
        2- jar cfm MainApplication manifest.txt -C classes mainapplication

        to run the APP:
        3- java -jar MainApplication

######################################################################################################

    IV) to make an executable .bat file :
    (inside the Project's directory)

        1- Create a .txt file
        2-inside write :

        start java -jar MainApplication

        3- save and close
        4- rename the file from .txt to .bat
        5- Run the file.bat

######################################################################################################

PS. Do not forget to open and RUN MySQL DB (MySQL Notifier)

######################################################################################################
