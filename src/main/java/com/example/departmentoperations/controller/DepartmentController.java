package com.example.departmentoperations.controller;


import com.example.departmentoperations.entity.Department;
import com.example.departmentoperations.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
