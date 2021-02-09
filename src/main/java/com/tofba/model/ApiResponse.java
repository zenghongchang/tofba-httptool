package com.tofba.model;

import java.util.List;
import java.util.Map;

/**
 * 
 * <API响应结果.>
 * 
 * @author Henry(fba02)
 * @version [版本号, 2021-2-9]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ApiResponse<T> {
    final private int statusCode;    
    final private Map<String, List<String>> headers;    
    final private T data;
    
    /**
     * @param statusCode The status code of HTTP response
     * @param headers The headers of HTTP response
     */
    public ApiResponse(int statusCode, Map<String, List<String>> headers) {
        this(statusCode, headers, null);
    }
    
    /**
     * @param statusCode The status code of HTTP response
     * @param headers The headers of HTTP response
     * @param data The object deserialized from response bod
     */
    public ApiResponse(int statusCode, Map<String, List<String>> headers, T data) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.data = data;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public Map<String, List<String>> getHeaders() {
        return headers;
    }
    
    public T getData() {
        return data;
    }
}