package ru.krilovskiy.dao;

import org.junit.Test;
import ru.krilovskiy.domain.Employee;
import ru.krilovskiy.view.EmployeeRequest;

import java.util.List;

public class EmployeeDaoTest {

    @Test
    public void findEmployees() {
        EmployeeDao dao = new EmployeeDao();
        EmployeeRequest request = null;
        List<Employee> employees = dao.findEmployees(request);
        employees.forEach(e -> {
            System.out.println("Name "+e.getGivenName());
            System.out.println("Telephone  "+e.getTelNumbers().size());
            System.out.println("Address "+e.getWorkAddress());
        });
    }

    @Test
    public void findEmployeeTelephone() {
        EmployeeDao dao = new EmployeeDao();
        List<Employee> employees = dao.findEmployeeTelephone();
        employees.forEach(e -> {
            System.out.println("Name "+e.getGivenName());
            System.out.println("TelNumbers "+e.getTelNumbers());
        });
    }

    @Test
    public void saveEmployee() {
    }
}