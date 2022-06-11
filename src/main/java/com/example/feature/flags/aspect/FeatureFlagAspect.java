package com.example.feature.flags.aspect;

import com.example.feature.flags.annotation.FeatureFlag;
import com.example.feature.flags.service.FeatureFlagService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class FeatureFlagAspect {


    @Autowired
    private FeatureFlagService featureFlagService;

    @Around("execution(* *()) && @annotation(com.example.feature.flags.annotation.FeatureFlag)")
    public void checkFeatureFlagEnabled(ProceedingJoinPoint joinPoint) throws Throwable {
        String featureName = getAnnotationValue(joinPoint);
        if(!featureFlagService.isEnabled(featureName)) { return; }
        joinPoint.proceed();
    }

    private String getAnnotationValue(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        FeatureFlag annotation = method.getAnnotation(FeatureFlag.class);
        return annotation.value();
    }

}
