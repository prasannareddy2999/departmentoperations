package com.example.departmentoperations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    private String departmentAddress;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    private String departmentCode;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    private String departmentName;

    @Override
    public String toString() {
        return "Department{" +
                "departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
