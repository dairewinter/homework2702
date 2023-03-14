package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceEmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void createEmployee(String firstName, String lastName, String gender, Integer age, Integer cityId) {
        try (PreparedStatement statement = getConnection().prepareStatement
                ("INSERT INTO employee(first_name, last_name, gender, age, city_id) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee employee = null;
        try (PreparedStatement statement = getConnection().prepareStatement
                ("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");
                Integer cityId = resultSet.getInt("city_id");
                employee = new Employee(firstName, lastName, gender, age, cityId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM employee")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");
                list.add(new Employee(firstName, lastName, gender, age, cityId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Employee updateEmployeeById(Integer id, String firstName, String lastName, String gender, Integer age,
                                       Integer cityId) {
        try (PreparedStatement statement = getConnection().prepareStatement
                ("UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) WHERE id = (?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.setInt(6, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Employee(firstName, lastName, gender, age, cityId);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        try (PreparedStatement statement =
                     getConnection().prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        Connection CONNECTION;
        try {
            CONNECTION = DriverManager.getConnection(Application.URL, Application.USER,
                    Application.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return CONNECTION;
    }
}