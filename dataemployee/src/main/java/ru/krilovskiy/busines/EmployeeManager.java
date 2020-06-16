package ru.krilovskiy.busines;

import ru.krilovskiy.dao.EmployeeDao;
import ru.krilovskiy.domain.Employee;
import ru.krilovskiy.view.EmployeeRequest;
import ru.krilovskiy.view.EmployeeResponse;

import java.util.List;

public class EmployeeManager {

    private EmployeeDao employeeDao;

    public EmployeeResponse findEmployees(EmployeeRequest request) {
        List<Employee> employees = employeeDao.findEmployees(request);
        return new EmployeeResponse();
    }
}
