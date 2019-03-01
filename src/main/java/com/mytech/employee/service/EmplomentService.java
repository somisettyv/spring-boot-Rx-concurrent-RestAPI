package com.mytech.employee.service;

import java.util.List;

import com.mytech.employee.dao.model.Employee;
import com.mytech.employee.service.model.EmployeeDto;

public interface EmplomentService {
	public List<EmployeeDto> getAllEmployees(long departmentId);
	public void addEmployee(String name, String job, String manager, double salary);
	public void updateEmployee(Long deptNo, Long employeeNumber, Employee employee);
}
