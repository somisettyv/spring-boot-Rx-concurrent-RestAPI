package com.mytech.employee.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperResponse {

	private Map<String, List<FieldModel>> tags = new HashMap<String, List<FieldModel>>();

	public Map<String, List<FieldModel>> getTags() {
		return tags;
	}

	public void setTags(Map<String, List<FieldModel>> resultMap) {
		this.tags = resultMap;
	}
	
	/**
	 * 
	 * 
	 * @param key
	 * @param fieldModel
	 */
	public void addFieldModel(String key, FieldModel fieldModel) {
		if (tags != null) {
			if (tags.containsKey(key)) {
				tags.get(key).add(fieldModel);
			} else {
				List<FieldModel> fieldModelList = new ArrayList<FieldModel>();
				fieldModelList.add(fieldModel);
				tags.put(key, fieldModelList);
			}
		}
	}
}
