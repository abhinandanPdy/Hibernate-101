package org.abhinandanpdy.entity;

public class Employee {

    private int empId;
    private String empName;
    private String empDesignation;
    private int empSalary;

    // Constructors
    public Employee() {}

    public Employee(String name, String empDesignation, int empSalary) {
        this.empName = name;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }
}
