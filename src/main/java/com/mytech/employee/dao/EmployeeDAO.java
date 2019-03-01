package com.mytech.employee.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mytech.employee.service.model.QueryModel;
import com.mytech.employee.service.model.ResponseData;

@Service
public class EmployeeDAO implements BaseDAO{

	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * This method is go fetch the required data from Database and map the results with appropriate field
	 * 
	 */
	public ResponseData fetchData(QueryModel queryModel) {
		ResponseData map = this.jdbcTemplate.query(queryModel.getQuery(), new DefaultDataExtractor(queryModel));
		System.out.println("map /////   " + map);
		return map;
	}

}