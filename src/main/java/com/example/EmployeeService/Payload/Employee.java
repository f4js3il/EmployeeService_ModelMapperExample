package com.example.EmployeeService.Payload;

import com.example.EmployeeService.Model.EmployeeDO;

import java.util.Objects;

public class Employee extends EmploymentStatus implements Comparable<Employee> {
    private String employee_name;
    private Double employee_salary;
    private Integer employee_age;
    private String id;

    public Employee(){}

    public Employee(EmployeeDO employeeDO){
        this.employee_name = employeeDO.getName();
        this.employee_age = employeeDO.getAge();
    }

    public Employee(String employee_name, Double employee_salary, Integer employee_age) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_age=" + employee_age +", employed ="+this.getEmployed()+
                ",lastPromotionDate="+this.getLastPromotionDate()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee_name.equals(employee.employee_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_name);
    }

    @Override
    public int compareTo(Employee o) {
       return this.employee_salary.compareTo(o.employee_salary);
    }

    @Override
    public void changeEmployment() {
        this.setEmployed(!this.getEmployed());
    }
}
