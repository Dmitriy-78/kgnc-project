package ru.krilovskiy.dao;

import ru.krilovskiy.domain.Employee;
import ru.krilovskiy.exception.DaoException;

public interface EmployeeDao {
    Employee findByName(String surName) throws DaoException;
    long saveEmployee() throws DaoException;
}
