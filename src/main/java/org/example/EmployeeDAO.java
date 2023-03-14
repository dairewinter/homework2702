package org.example;

import java.util.List;
public interface EmployeeDAO {
    void createEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    Employee updateEmployeeById(Employee employee);

    void deleteEmployeeById(Employee employee);
}