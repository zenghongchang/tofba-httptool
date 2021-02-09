package com.tofba.auth;

import java.util.List;
import java.util.Map;

import com.tofba.model.Pair;

/**
 * 
 * <OAuth认证。>
 * 
 * @author Henry(fba02)
 * @version [版本号, 2021-2-9]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OAuth implements Authentication {
    private String accessToken;
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
        if (accessToken != null) {
            headerParams.put("Authorization", "Bearer " + accessToken);
        }
    }
}