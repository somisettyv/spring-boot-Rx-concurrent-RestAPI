package com.mytech.employee.dao.querybuilder;

import com.mytech.employee.service.model.QueryModel;

public interface QueryBuilder {

	String buildQuery(QueryModel queryModel);
}
