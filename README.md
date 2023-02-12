# Appium-Java-Framework

Boilerplate for Android using Appium. The aim of this project is provide a maven project in order to run automated test with Android easily.

## Prerequisites

Following are the softwares need to be installed,

1. Java version "15.0.2" (Setup Environment variables)
2. Apache Maven 3.6.3 (Setup Environment variables)
3. Android Studio Chipmunk 2021 (Setup Environment variables Android\Sdk\tools | Sdk\tools\bin | platform-tools)
4. Appium 2.0.0-beta.55
5. Node v16.15.1 (Setup Environment variables)


## How to configure test and execute

Please follow the steps,

1. Clone the repository in your system, git clone https://github.com/Ommie1/Appium-Java.git 
2. Start appium servier on administrator mode with command "appium"
3. Open virtual device from device manager
4. Change virtual device name from properties file, Appium-Project\src\main\java\org\resources\androidConfig.properties
5. Configure testng.xml file before run test using Intellig IDE
6- Use command "mvn test -PFunctional-Tests" to execute run test on command line 

## Author
Syed Umair Hassan

