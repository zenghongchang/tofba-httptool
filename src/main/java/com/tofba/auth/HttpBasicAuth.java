package com.tofba.auth;

import java.util.List;
import java.util.Map;

import com.tofba.model.Pair;

import okhttp3.Credentials;

/**
 * 
 * <用户名密码认证.>
 * 
 * @author Henry(fba02)
 * @version [版本号, 2021-2-9]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HttpBasicAuth implements Authentication {
    private String username;    
    private String password;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
        if (username == null && password == null) {
            return;
        }
        headerParams.put("Authorization", Credentials.basic(username == null ? "" : username, password == null ? "" : password));
    }
}