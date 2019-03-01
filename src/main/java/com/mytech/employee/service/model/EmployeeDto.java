package com.mytech.employee.service.model;

import com.mytech.employee.dao.model.Employee;

public class EmployeeDto {

	private Long number;
	
	private String name;
	private String jobName;
	private String managerName;
	private Double salary;
	private DepartmentDto department;
	
	public EmployeeDto() {
		
	}
	public EmployeeDto(Employee p) {
		number = p.getNumber();
		name   = p.getName();
		jobName = p.getJobName();
		managerName = p.getManagerName();
		salary = p.getSalary();

		if (p.getDepartment() != null) {
			department = new DepartmentDto(p.getDepartment().getNumber(), p.getDepartment().getName(),
					p.getDepartment().getLocation());
		}
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}
	  
	  
}
