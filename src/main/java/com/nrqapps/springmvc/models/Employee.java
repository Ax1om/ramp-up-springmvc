package com.nrqapps.springmvc.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mauricio on 8/17/17.
 * NrqApps © 2017
 */
@Entity
@Table (name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String country;

    @Column(name = "brith_date")
    private Date birthDate;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
