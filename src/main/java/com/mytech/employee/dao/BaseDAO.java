package com.mytech.employee.dao;

import com.mytech.employee.service.model.QueryModel;
import com.mytech.employee.service.model.ResponseData;

public interface BaseDAO {

	/**
	 * This method is to make a Database Query call and extract the data from the ResultSet
	 * 
	 * 
	 * @param queryModel
	 * @return
	 */
	public ResponseData fetchData(QueryModel queryModel);

}
