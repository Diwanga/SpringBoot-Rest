package com.diwanga.restapidemo.controller;

import com.diwanga.restapidemo.entity.Department;

import com.diwanga.restapidemo.error.DepartmentNotFoundException;
import com.diwanga.restapidemo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService; // property base Dependancy Injection

    @PostMapping("/dep")
public Department saveDepartment(@Valid @RequestBody Department department){ // getting entire json object to user object
LOGGER.info("Inside saveDepartment method");
 return departmentService.saveUser(department);

}
@GetMapping("/dep")
public List<Department> fetchDepartment() {
    LOGGER.info("Inside fetchDepartment method");
        return departmentService.fetchDepartment();
}

@GetMapping("/department/{id}")
public  Department fetchById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
return  departmentService.fetchDepartmentByID(departmentId);

}
@DeleteMapping("/department/{id}")
public String deleteDepartmentById(@PathVariable("id") Long id){
          departmentService.deleteDepartmentById(id);
          return "deleted successfully";
}
@PutMapping("/department/{id}")
public Department updateDepartment(@PathVariable("id") Long id,
                                   @RequestBody  Department department){
        return departmentService.updateDepartmentById(id,department);
}
@GetMapping("/department/name/{name}")
public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
}
}
