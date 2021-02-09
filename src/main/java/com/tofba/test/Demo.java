package com.tofba.test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.tofba.model.Pair;
import com.tofba.model.ProgressRequestBody;
import com.tofba.model.ProgressResponseBody;
import com.tofba.okhttp3.ApiClient;
import com.tofba.okhttp3.ApiException;
import com.tofba.okhttp3.Configuration;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Response;

public class Demo {
    private ApiClient apiClient;
    
    Demo() {
        this(Configuration.getDefaultApiClient());
    }
    
    public Demo(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public ApiClient getApiClient() {
        return apiClient;
    }
    
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    /**
     * Build call for getMarketplaceParticipations
     * 
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public Call getMarketplaceParticipationsCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener)
        throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/api/amoebaSubjects";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {"application/json"};
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null)
            localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        apiClient.setBasePath("http://192.168.180.21:8085");
        
        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain)
                    throws IOException {
                    Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder().body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
                }
            });
        }        
        String[] localVarAuthNames = new String[] {};
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    public static void main(String[] args)
        throws ApiException {
        Demo demo = new Demo();
        Call call = demo.getMarketplaceParticipationsCall(null, null);
        Type localVarReturnType = new TypeToken<Object>() {
        }.getType();
        demo.apiClient.execute(call, localVarReturnType);        
    }    
}