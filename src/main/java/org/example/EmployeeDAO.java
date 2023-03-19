package org.example;

import java.util.List;
public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    Employee updateEmployeeById(Employee employee);

    void deleteEmployeeById(Employee employee);

    void updateEmployeeByIdInConstructor(Employee employee);

    void deleteEmployeeByIdInConstructor(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}