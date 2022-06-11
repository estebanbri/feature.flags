package com.example.feature.flags.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FeatureFlagService {

    Map<String, Boolean> featuresFlags = new HashMap<>();

    FeatureFlagService() {
        featuresFlags.put("XPRESS", true);
        featuresFlags.put("OFFNETQUOTING", false);
    }

    // TODO the result is hardcoded but here we can call db to check if feature is enabled
    public boolean isEnabled(String feature) {
        return featuresFlags.getOrDefault(feature,false);
    }


}
