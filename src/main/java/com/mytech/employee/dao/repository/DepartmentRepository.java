package com.mytech.employee.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytech.employee.dao.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

	 Department findByEmployees(long deptId);
}
