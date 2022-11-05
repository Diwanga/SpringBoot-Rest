package com.diwanga.restapidemo.service;

import com.diwanga.restapidemo.entity.Department;
import com.diwanga.restapidemo.error.DepartmentNotFoundException;
import com.diwanga.restapidemo.repository.DepartmentRepository;
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
    public List<Department> fetchDepartment() {
     return departmentRepository.findAll();

    }

    @Override
    public Department saveUser(Department department) {
       return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException {

         Optional<Department> department = departmentRepository.findById(departmentId); // get is added as findby id return Optional. we have to get();
   if(!department.isPresent()){
       throw new DepartmentNotFoundException("No Department having this ID");
   }
   return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
         departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department oldDepartment = departmentRepository.findById(id).get();//as optional // get is added as findby id return Optional. we have to get()
       //check for nulls and empty's

        if(Objects.nonNull(department.getDepartmentName())&&
                !"".equalsIgnoreCase(department.getDepartmentName()) ){
            oldDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&
                !"".equalsIgnoreCase(department.getDepartmentCode()) ){
            oldDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&
                !"".equalsIgnoreCase(department.getDepartmentAddress()) ){
            oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
return departmentRepository.save(oldDepartment);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
//        return  departmentRepository.findByDepartmentName(departmentName);
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        // have to handel not found case
    }
}
