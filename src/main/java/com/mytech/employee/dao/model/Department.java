package com.mytech.employee.dao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.persistence.OneToMany;

@Entity
public class Department {

	// Generate Ids using Database Sequence

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_Sequence")
	@SequenceGenerator(name = "dept_Sequence", sequenceName = "DEP_SEQ")
	@Column(name = "depno")
	private Long number;

	@Column(name = "depname")
	private String name;
	@Column(name = "deploc")
	private String location;

	// This would have one-to-many relation with employees
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "department")
	List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
