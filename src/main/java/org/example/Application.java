package org.example;

import java.sql.*;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        City city = new City("Kazan", 6);
        Employee employee1 = new Employee("Natasha", "Rostova", "female", 18, new City("Kazan", 6));
        Employee employee2 = new Employee("Andrey", "Bolkonsky", "male", 27, new City("Nizhnekamsk", 7));

        ServiceEmployeeDAOImpl service = new ServiceEmployeeDAOImpl();
        service.createEmployee(new Employee());
        service.getAllEmployees();
        service.getEmployeeById(2);
        service.updateEmployee(new Employee("Grigory", "Kozintsev", "male", 50, city));
        service.deleteEmployee(employee2);

        ServiceCityDAOImpl serviceCity = new ServiceCityDAOImpl();
        serviceCity.deleteCity(city);
    }
}