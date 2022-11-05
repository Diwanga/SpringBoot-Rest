package com.diwanga.restapidemo.service;

import com.diwanga.restapidemo.entity.Department;
import com.diwanga.restapidemo.error.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {
    public List<Department> fetchDepartment() ;

    Department saveUser(Department department);

    Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartmentById(Long id, Department department);

    Department fetchDepartmentByName(String departmentName);
}
