package ru.krilovskiy.domain;

import javax.persistence.*;

@Entity
@Table(name = "kgnc_work_address")
public class WorkAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_address_id")
    private Long workAddressId;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "building")
    private String building;
    @Column(name = "office_number")
    private String officeNumber;

    public WorkAddress() {
    }

    public Long getWorkAddressId() {
        return workAddressId;
    }

    public void setWorkAddressId(Long workAddressId) {
        this.workAddressId = workAddressId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        return "WorkAddress{" +
                "workAddressId=" + workAddressId +
                ", employee=" + employee +
                ", building='" + building + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                '}';
    }
}
