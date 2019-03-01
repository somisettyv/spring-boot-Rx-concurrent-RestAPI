package com.mytech.employee.service.model;

public class DepartmentDto {


	private Long number;

	private String name;
	private String location;


	public DepartmentDto(Long number, String name, String location) {
		super();
		this.number = number;
		this.name = name;
		this.location = location;
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
