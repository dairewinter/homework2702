package org.example;

import java.sql.*;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) {
        Employee employee = new Employee("Natasha", "Rostova", "female", 15, 2);
        ServiceEmployeeDAOImpl service = new ServiceEmployeeDAOImpl();
        service.createEmployee(employee);
        service.getAllEmployees();
        service.getEmployeeById(1);
        service.updateEmployeeByIdInConstructor(new Employee("Andrey", "Bolkonsky", "male", 25, 1));
        Employee employee1 = new Employee("Tanya", "Larina", "female", 15, 4);
        service.deleteEmployeeByIdInConstructor(employee1);
    }
}