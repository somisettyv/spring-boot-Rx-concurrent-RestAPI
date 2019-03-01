package com.mytech.employee.service.model;

public class FieldModel {

	private String value;
	private Location location;
	private String name;
	
	public FieldModel(String value, String name, String tableName) {
		this.value = value;
		location = new Location(tableName);
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
