package com.assignment.application.entity;


import javax.persistence.*;

@Entity
@Table(name="salary")
public class Salary {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="emp_id" , columnDefinition = "text")
    private String employeeId;
    @Column(name="emp_name")
    private String employeeName;
    @Column(name="salary")
    private Double salary;
    @Column(name="acc_no")
    private String accountNo;
    @Column(name="comp_id")
    private Long companyId;
    @Column(name="dept_id")
    private Long departmentId;
    @OneToOne
    @JoinColumn(name="emp_id", referencedColumnName = "emp_id" , insertable=false, updatable=false)
    private Employee employee;

    public Salary(){

    }

    public Salary(Long id, String employeeId, String employeeName, Double salary, String accountNo, Long companyId, Long departmentId) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.accountNo = accountNo;
        this.companyId = companyId;
        this.departmentId = departmentId;
    }

    public Salary(String employeeId, String employeeName, Double salary, String accountNo, Long companyId, Long departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.accountNo = accountNo;
        this.companyId = companyId;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
