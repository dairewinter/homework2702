package org.example;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceEmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void createEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee", Employee.class).list();
    }

    @Override
    public Employee updateEmployeeById(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Employee employee) {

    }

    @Override
    public void updateEmployeeByIdInConstructor(Employee employee) {

    }

    @Override
    public void deleteEmployeeByIdInConstructor(Employee employee) {

    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
