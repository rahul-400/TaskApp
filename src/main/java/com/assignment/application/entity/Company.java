package com.assignment.application.entity;

import javax.persistence.*;

@Entity
@Table(name="company_info")
public class Company{

    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="industry_type")
    private String industryType;
    @Column(name="employee_count")
    private Long employeeCount;
    @Column(name="head_office")
    private String headOffice;
    @Column(name="founder")
    private String founder;

    public Company(){

    }

    public Company(Long id, String name, String industryType, Long employeeCount, String headOffice, String founder) {
        this.id = id;
        this.name = name;
        this.industryType = industryType;
        this.employeeCount = employeeCount;
        this.headOffice = headOffice;
        this.founder = founder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="industry_type")
    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    @Column(name="employee_count")
    public Long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Long employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Column(name="head_office")
    public String getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }
}
