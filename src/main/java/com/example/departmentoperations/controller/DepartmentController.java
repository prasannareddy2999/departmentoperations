package com.example.departmentoperations.controller;


import com.example.departmentoperations.entity.Department;
import com.example.departmentoperations.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment( @RequestBody  Department department)
    {
        System.out.println("in controller");
        Department department1=departmentService.saveDepartment(department);
        System.out.println(department1);
       return department1;
    }

    @GetMapping ("/getdepartments")
    public List<Department> fetchDepartmentList()
    {

        return departmentService.fetchDepartmentList();
    }
    @GetMapping ("/getdepartmentbyid/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
    {

        return departmentService.fetchDepartmentById(departmentId);
    }

    @PutMapping  ("/updatedepartmentbyid/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department)
    {
        return departmentService.updateDepartmentById(departmentId,department);

    }

    @DeleteMapping ("/deletedepartmentbyid/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return"Successfully deleted";
    }

}
