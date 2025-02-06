package com.tsoft.poc.elastic.aspect;

import com.tsoft.poc.elastic.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogExecutionTimeAspect {
    @Around("@annotation(logExecutionTime)")
     public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
         long start = System.currentTimeMillis();
         Object proceed = joinPoint.proceed();
         long executionTime = System.currentTimeMillis() - start;
         log.info(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
         return proceed;
     }


}
