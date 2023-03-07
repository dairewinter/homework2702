package org.example;

import java.sql.*;
import java.sql.SQLException;

public class Application {
    static final String USER = "postgres";
    static final String PASSWORD = "postgres111";
    static final String URL = "jdbc:postgresql://localhost:5432/skypro";

    public static void main(String[] args) {
        try (final Connection CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     CONNECTION.prepareStatement("SELECT * FROM employee")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");
                System.out.println(firstName + " " + lastName + " " + gender + " " + age + " " + cityId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ServiceEmployeeDAOImpl serviceEmployeeDAO = new ServiceEmployeeDAOImpl();
        System.out.println(serviceEmployeeDAO.getEmployeeById(12));
        serviceEmployeeDAO.createEmployee("Natasha", "Rostova", "female", 20, 3);
        System.out.println(serviceEmployeeDAO.updateEmployeeById(23, "Andrey", "Bolkonsky", "male", 30, 2));
        serviceEmployeeDAO.deleteEmployeeById(24);
        System.out.println(serviceEmployeeDAO.getAllEmployees());
    }
}
