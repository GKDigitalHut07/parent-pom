package com.gkdigitalhut.parentpom.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(com.gkdigitalhut.parentpom.annotations.MethodExecutionLog)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("Entered method: {} at {}", joinPoint.getSignature(), startTime);

        try {
            // Proceed with the method execution
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("Exited method: {} at {}. Execution time: {} ms",
                    joinPoint.getSignature(), endTime, (endTime - startTime));
        }
    }
}
