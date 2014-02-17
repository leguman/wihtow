#WihtoW - What I Have to Watch

##Introduction

This project is a personnal movie manager.
Features that will be implemented are:
  - Using JSF 2.2, Bootstrap layout
  - CRUD for movies, genres, users, user_groups
  - Managing user access
  - Internationalization
  - Use an api for themoviedb (ie. https://github.com/Omertron/api-themoviedb)
  
##Infractucture

###MariaDB
For this project, We're using a MariaDB SQL server configured as following:
To open you session:

  #> mysql -u root -p yourpassword
  
Create the database:

    mysql> CREATE DATABASE wihtow;
    mysql> CREATE USER 'wihtow_user'@'localhost' IDENTIFIED BY 'wihtow_user';
    mysql> USE wihtow;
    mysql> GRANT ALL PRIVILEGES ON wihtow.* TO 'wihtow_user'@'localhost';
    mysql> FLUSH PRIVILEGES;

Rest of the database wild be generated using liquibase during the application deployement.

###WildFly 8

You need to create a datasource called 'java:/jdbc/wihtowDS' in WildFly to get it working.
