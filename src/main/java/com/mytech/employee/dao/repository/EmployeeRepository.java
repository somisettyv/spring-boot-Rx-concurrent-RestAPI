package com.mytech.employee.dao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytech.employee.dao.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	

	List<Employee> findByDepartmentNumber(long teamId);
	
	


}