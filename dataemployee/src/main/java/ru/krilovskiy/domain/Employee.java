package ru.krilovskiy.domain;

import ru.krilovskiy.util.LocalDateAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "kgnc_employee_data")
@NamedQueries({
     @NamedQuery(name = "employee.findEmployees",
     query = "SELECT em FROM Employee em "+
             "LEFT JOIN FETCH em.telNumbers tn "+
             "INNER JOIN FETCH em.workAddress wa"),
        @NamedQuery(name = "employee.findEmployeeTelephone",
        query = "SELECT em FROM Employee em "+
                "LEFT JOIN FETCH Telephone t ON t.employee = em.employeeId")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "sur_name")
    private String surName;
    @Column(name = "given_name")
    private String givenName;
    @Column(name = "patronymic")
    private String patronymic;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "position")
    private String position;
    @Column(name = "tabel_number")
    private String tabelNumber;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,
    mappedBy = "employee")
    private WorkAddress workAddress;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
    mappedBy = "employee")
    private List<Telephone> telNumbers;

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTabelNumber() {
        return tabelNumber;
    }

    public void setTabelNumber(String tabelNumber) {
        this.tabelNumber = tabelNumber;
    }

    public WorkAddress getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(WorkAddress workAddress) {
        this.workAddress = workAddress;
    }

    public List<Telephone> getTelNumbers() {
        return telNumbers;
    }

    public void setTelNumbers(List<Telephone> telNumbers) {
        this.telNumbers = telNumbers;
    }
}
