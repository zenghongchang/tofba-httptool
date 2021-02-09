package com.tofba.auth;

import java.util.List;
import java.util.Map;

import com.tofba.model.Pair;

public interface Authentication {
    void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}