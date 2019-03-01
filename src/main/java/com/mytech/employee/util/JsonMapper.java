package com.mytech.employee.util;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

/***
 * 
 * 
 * @author somisettyv
 *
 * @param <T>
 */
public class JsonMapper<T> {
    
    private final ObjectMapper objectMapper;
    private final Class<T> type;

    public static <E> JsonMapper<E> serverInstance(Class<E> type) {
        return new JsonMapper<E>(type, ObjectMapper.newInstance());
    }
    
    
    
    /**
     * Private constructor.
     * <p>
     * Use {@link #apiInstance()} and {@link #mongoInstance()} instead.
     */
    private JsonMapper() {
        objectMapper = null;
        type = null;
    }
    
    private JsonMapper(Class<T> type, ObjectMapper objectMapper) {
        this.type = type;
        this.objectMapper = objectMapper;
    }
    
    public String toJson(T object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
    
    public T fromJson(String json) throws IOException {
        return objectMapper.readValue(json, type);
    }
}
