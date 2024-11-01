# Localization home assignment

I used localized tables in database, to handle different languages used in app. App chooses automatically right table
on each language user sets. Fill your data and click save button to add them in database.

Before use you need to make database and use this script to add tables:
```sql
CREATE TABLE employee_en (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE employee_fa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE employee_ja (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);
```

After that you need to change some settings in code, fill your database url, username and password:
```java
private static final String JDBC_URL = "your db location";
private static final String USERNAME = "your user";
private static final String PASSWORD = "your password";
```