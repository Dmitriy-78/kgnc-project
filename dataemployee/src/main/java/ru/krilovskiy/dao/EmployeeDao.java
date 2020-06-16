package ru.krilovskiy.dao;

import ru.krilovskiy.domain.Employee;
import ru.krilovskiy.domain.WorkAddress;
import ru.krilovskiy.view.EmployeeRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDao {

    private EntityManager entityManager;

    public EmployeeDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    //@Override
    public List<Employee> findEmployees(EmployeeRequest request) {
        return entityManager.createNamedQuery("employee.findEmployees")
                             .getResultList();
    }

    public List<Employee> findEmployeeTelephone() {
        return entityManager.createNamedQuery("employee.findEmployeeTelephone")
                .getResultList();
    }

    //@Override
    public long saveEmployee(Employee employee) {
        long id = -1;
        employee = buildEmployee();

        try {
            entityManager.getTransaction().begin();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return 0;
    }

    private Employee buildEmployee() {
        Employee result = new Employee();
        result.setSurName("Иванов");
        result.setGivenName("Bdfy");
        result.setPatronymic("Bdfyjdbx");
        result.setDateOfBirth(LocalDate.of(1978,04,10));
        result.setPosition("Ведущий инженер");
        result.setTabelNumber("04061515");
        WorkAddress adr = new WorkAddress();
        adr.setEmployee(result);
        adr.setBuilding("24 Бис(Б)");
        adr.setOfficeNumber("321");
        result.setWorkAddress(adr);

        return result;
    }
}
