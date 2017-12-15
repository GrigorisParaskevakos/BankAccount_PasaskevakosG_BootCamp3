#Bootcamp Project1

# Author @Paraskevakos Grigoris

#Setup for OS Windows
#All files are inside BankAccount_Pasaskevakos_Grigors_BootCamp3

#Requirements :

# Java JRE (Currect jre1.8.0_131)

# Windows OS

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
---Just open "BankAccounts.bat" and make Run the Application "

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

PS. Do not forget to open and Start MySQL DB

######################################################################################################
