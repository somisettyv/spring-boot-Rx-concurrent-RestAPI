package com.mytech.employee.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;

/**
 * 
 * @author vsomis001c
 *
 */
public class ObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {

	private static final long serialVersionUID = 20130325L;

	private static final Map<String, ObjectMapper> OBJECT_MAPPERS = new HashMap<String, ObjectMapper>();

	private static ObjectMapper createV1Instance() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.WRAP_EXCEPTIONS, false);
		return objectMapper;
	}

	private ObjectMapper() {
		super();
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}


	public static ObjectMapper newInstance() {
		return new ObjectMapper();
	}

}
