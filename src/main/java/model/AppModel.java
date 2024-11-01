package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppModel {

    private ResourceBundle bundle;
    private static final String JDBC_URL = "your db location";
    private static final String USERNAME = "your user";
    private static final String PASSWORD = "your password";

    public void addEmployee(Employee employee, Locale locale) {
        bundle = ResourceBundle.getBundle("app", locale);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String table = bundle.getString("dbBundle");
                String sql = "INSERT INTO " + table + " (first_name, last_name, email) VALUES (?, ?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {

                    statement.setString(1, employee.getFirstname());
                    statement.setString(2, employee.getLastname());
                    statement.setString(3, employee.getEmail());
                    statement.executeUpdate();


                    System.out.println("Records inserted successfully.");
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
