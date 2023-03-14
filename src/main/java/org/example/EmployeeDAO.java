package org.example;

import java.util.List;
public interface EmployeeDAO {
    void createEmployee(String firstName, String lastName, String gender, Integer age, Integer cityId);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    Employee updateEmployeeById(Integer id, String firstName, String lastName, String gender, Integer age,
                                Integer cityId);

    void deleteEmployeeById(Integer id);
}