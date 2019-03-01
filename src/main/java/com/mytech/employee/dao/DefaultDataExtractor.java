package com.mytech.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.mytech.employee.service.model.FieldModel;
import com.mytech.employee.service.model.QueryModel;
import com.mytech.employee.service.model.ResponseData;

public class DefaultDataExtractor implements ResultSetExtractor<ResponseData> {

	private QueryModel queryModel;
	private ResponseData result = new ResponseData();
	
	
	public DefaultDataExtractor(QueryModel queryModel) {
		this.queryModel=queryModel;
	}

	@Override
	public ResponseData extractData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			queryModel.getLogicalRealFieldMap().entrySet().stream().forEach(e -> {
				try {
					result.addFieldModel(e.getKey(),
							new FieldModel(rs.getString(e.getKey()), e.getKey(), queryModel.getTableName()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
		}
		return result;
	}
}