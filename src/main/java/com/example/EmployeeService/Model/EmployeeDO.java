package com.example.EmployeeService.Model;

import com.example.EmployeeService.Payload.Employee;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee")
public class EmployeeDO {

    private Integer id;
    private String name;
    private Integer age;
    private Boolean employed;
    private Date startDate;
    private Date promotionDate;

    public EmployeeDO(Employee employee) {
        this.name = employee.getEmployee_name();
        this.age = employee.getEmployee_age();
        this.employed = employee.getEmployed();
        this.startDate = employee.getEmploymentStartDate();
        this.promotionDate = employee.getLastPromotionDate();
    }

    public EmployeeDO() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="Name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="Age")
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name="Employed")
    public Boolean getEmployed() {
        return employed;
    }
    public void setEmployed(Boolean employed) {
        this.employed = employed;
    }

    @Column(name="StartDate")
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name="PromotionDate")
    public Date getPromotionDate() {
        return promotionDate;
    }
    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }
}
