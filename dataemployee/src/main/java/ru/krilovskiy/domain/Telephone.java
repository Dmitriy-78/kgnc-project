package ru.krilovskiy.domain;

import javax.persistence.*;

@Entity
@Table(name = "kgnc_telephone")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tel_number_id")
    private Long telNumberId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "tel_number")
    private String telNumber;

    public Telephone() {
    }

    public Long getTelNumberId() {
        return telNumberId;
    }

    public void setTelNumberId(Long telNumberId) {
        this.telNumberId = telNumberId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "telNumberId=" + telNumberId +
                ", employee=" + employee +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
