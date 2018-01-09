# RampUP Spring MVC
Exercises
 - [Task1](https://github.com/Ax1om/ramp-up-springmvc/commit/d72b640f7412bae499724461612155f22cfe04e3): Create a CRUD for employee
 - [Task2](https://github.com/Ax1om/ramp-up-springmvc/commit/c7f7990176861bb9100761db2bf4aeb6c1a0e834): Add a Marital Status property to Employee as a relationship Many To One
 - [Task3](https://github.com/Ax1om/ramp-up-springmvc/commit/69c9b6a31b392bef91e1883b1bf2598324fea298): Add a filter to the CRUD employee
 - [Task4](https://github.com/Ax1om/ramp-up-springmvc/commit/522842bd8774cbfa114a6f1502bf7e14ddde6045): Add a Skill property to Employee as a relationship Many to Many
 - [Task5](https://github.com/Ax1om/ramp-up-springmvc/commit/140d3b8ecdd897ca6f8151afd14a7f8c96c4f1e8): Upsert Form Validation server side
 - [Task6](https://github.com/Ax1om/ramp-up-springmvc/commit/0a0b4729587cc23a1ff8860668efabd4e12cad43): Notification System for CRUD operations
 
 
### Pre-requisites

  - JDK 1.8 and JAVA_HOME setup as env variable
  - Maven 3 or higher and the binaries added to then env variable PATH
  - MySQL5.7 with a DBA user 'ROOT' e pass 'ROOT' ( otherwise change the application.properties and pom.xml with your credentials)
  
### How to install

 - Checkout project
 - Navigate with the terminal to the project directory
 - if it is the first time running the app, you need to exec this maven task: 
    ```
    mvn exec:exec@install
    ```
 - start server 
    ```
    mvn tomcat7:run-war
    ```
    
