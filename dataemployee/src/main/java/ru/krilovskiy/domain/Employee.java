package ru.krilovskiy.domain;

import ru.krilovskiy.util.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class Employee {

    private int employee_id;
    private String surName;
    private String givenName;
    private String patronymic;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate dateOfBirth;
    private String position;
    private String tabelNumber;
    private WorkAddress workAddress;
    private Telephone telNumber;
}
