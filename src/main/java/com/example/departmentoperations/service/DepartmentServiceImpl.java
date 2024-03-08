package com.example.departmentoperations.service;


import com.example.departmentoperations.entity.Department;
import com.example.departmentoperations.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
   @Override
    public  Department saveDepartment(Department department)
    {
        System.out.println("in service");
        return departmentRepository.save(department);
    }
}
