package com.mytech.employee.service.model;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class QueryModel {

	private String tableName;
	private String query;
	private Map<String, String> logicalRealFieldMap;
	private FilterModel filterModel;

	public QueryModel() {

	}

	public QueryModel(String tableName, String query, Map<String, String> logicalRealFieldMap) {
		this.tableName = tableName;
		this.logicalRealFieldMap = logicalRealFieldMap;
		this.query = query;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Map<String, String> getLogicalRealFieldMap() {
		return logicalRealFieldMap;
	}

	public void setLogicalRealFieldMap(Map<String, String> logicalRealFieldMap) {
		this.logicalRealFieldMap = logicalRealFieldMap;
	}

	public FilterModel getFilterModel() {
		return filterModel;
	}

	public void setFilterModel(FilterModel filterModel) {
		this.filterModel = filterModel;
	}

	public static class QueryModelBuilder {

		private final QueryModel queryModel;

		public QueryModelBuilder() {
			this.queryModel = new QueryModel();
		}

		public QueryModel build() {
			return queryModel;
		}

		public QueryModelBuilder withTableName(String tableName) {
			this.queryModel.tableName = tableName;
			return this;
		}

		public QueryModelBuilder withQuery(String query) {
			this.queryModel.query = query;
			return this;
		}

		public QueryModelBuilder withLogicalRealFieldMap(Map logicalRealFieldMap) {
			this.queryModel.logicalRealFieldMap = logicalRealFieldMap;
			return this;
		}

	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
