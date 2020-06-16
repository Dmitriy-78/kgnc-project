package ru.krilovskiy.controllers;

import ru.krilovskiy.busines.EmployeeManager;
import ru.krilovskiy.view.EmployeeRequest;
import ru.krilovskiy.view.EmployeeResponse;

public class EmployeeController {

    private EmployeeManager employeeManager;

    public EmployeeResponse findEmployee(EmployeeRequest request) {
        return employeeManager.findEmployees(request);
    }
}
