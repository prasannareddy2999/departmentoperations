package com.example.departmentoperations.service;


import com.example.departmentoperations.entity.Department;
import com.example.departmentoperations.error.DepartmentNotFoundException;
import com.example.departmentoperations.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    @Override
    public List<Department> fetchDepartmentList()
    {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(departmentId);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId)
    {
          departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department)
    {
        //get the object from thedatabase
        Department depDB=departmentRepository.findById(departmentId).get();
        //modify it, if any values are null leave it otehrwise update it

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());}

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentName(department.getDepartmentCode());}

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentName(department.getDepartmentAddress());}
        //saving the value in database
        return departmentRepository.save(depDB);
    }
    @Override
    public Department fetchDepartmentByName(String departmentName)
    { return departmentRepository.findBydepartmentName(departmentName);
    }
}
