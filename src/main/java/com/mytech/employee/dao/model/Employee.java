package com.mytech.employee.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_Sequence")
	@SequenceGenerator(name = "emp_Sequence", sequenceName = "EMP_SEQ")
	@Column(name="empno")
	private Long number;
	
	@Column(name="ename")
	private String name;
	@Column(name="job")
	private String jobName;
	@Column(name="mgr")
	private String managerName;
	@Column(name="sal")
	private Double salary;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depno", nullable = false)
	Department department;
	
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	  
	  
}
