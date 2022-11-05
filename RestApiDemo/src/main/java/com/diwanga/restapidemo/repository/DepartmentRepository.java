package com.diwanga.restapidemo.repository;

import com.diwanga.restapidemo.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //no method for fetch by name. So we have to create it. But only naming Convention is needed
    Department findByDepartmentName(String departmentName); // naming convention is needed

    Department findByDepartmentNameIgnoreCase(String departmentName);
// more complex -> @Quary("wright jpql or sql ")  see JPA documentation
//    jpql --> ?1 ?2 for input
    // sql  ..... , 1 , 2
}
