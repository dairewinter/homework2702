package org.example;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column (name = "city_id")
    private Integer cityId;

    public Employee(String firstName, String lastName, String gender, Integer age, Integer cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }
    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(gender, employee.gender) && Objects.equals(age, employee.age) && Objects.equals(cityId, employee.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, age, cityId);
    }

    @Override
    public String toString() {
        return "\nEmployee" +
                " firstName " + firstName + " lastName " + lastName +
                " gender " + gender + " age " + age +
                " cityId " + cityId;
    }
}
