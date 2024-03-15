package com.example.departmentoperations.controller;


import com.example.departmentoperations.entity.Department;
import com.example.departmentoperations.error.DepartmentNotFoundException;
import com.example.departmentoperations.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment( @Valid @RequestBody  Department department)
    {
        System.out.println("in controller");
        LOGGER.info("Inside saveDepartment of Department Controller");
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
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping ("/getdepartmentbyname/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {

        return departmentService.fetchDepartmentByName(departmentName);
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
