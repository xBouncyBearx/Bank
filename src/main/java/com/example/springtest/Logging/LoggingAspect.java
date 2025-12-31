package com.example.springtest.Logging;

import com.example.springtest.Entity.LogEvent;
import com.example.springtest.Repository.LogEventRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final LogEventRepository logEventRepository;

    public LoggingAspect(LogEventRepository logEventRepository) {
        this.logEventRepository = logEventRepository;
    }

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object logApiCalls(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Capture API details
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String apiName = signature.getDeclaringTypeName() + "." + signature.getName();
        String httpMethod = signature.getMethod().getAnnotations()[0].annotationType().getSimpleName();

        Object requestPayload = joinPoint.getArgs();

        // Proceed with the API execution
        Object response = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;

        // Capture response details and save the log
        LogEvent logEvent = new LogEvent();
        logEvent.setApiName(apiName);
        logEvent.setHttpMethod(httpMethod);
        logEvent.setRequestPayload(Arrays.toString((Object[]) requestPayload));
        logEvent.setResponsePayload(response.toString());
        logEvent.setExecutionTime(executionTime);
        logEvent.setTimestamp(LocalDateTime.now());

        logEventRepository.save(logEvent);

        return response;
    }
}
