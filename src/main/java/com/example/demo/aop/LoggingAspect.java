package com.example.demo.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Calendar;
import java.util.TimeZone;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.demo.endpoint..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("+05:30"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        Logger log = LogManager.getLogger(joinPoint.getTarget().getClass());
        log.info("Class: " + joinPoint.getTarget().getClass().getName());
        log.info(new StringBuilder(" ##Execution Time: ").append(stopWatch.getTotalTimeMillis()).append(" ms").toString());
        return result;
    }

    @Before("execution(* com.example.demo.service..*.*(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("+05:30"));
        Logger log = LogManager.getLogger(joinPoint.getTarget().getClass());
        log.info(new StringBuilder(" #Input: ").append(joinPoint.getArgs()));
    }



    @After("execution(* com.example.demo.service..*.*(..))")
    public void exitingMethod(JoinPoint joinPoint) throws Throwable {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("+05:30"));
        Logger log = LogManager.getLogger(joinPoint.getTarget().getClass());
        log.info(new StringBuilder("#####Exiting").toString());
    }

    @AfterThrowing(pointcut = "execution(* com.example.demo..*.*(..))", throwing = "exception")
    public void exception(JoinPoint joinPoint, Throwable exception) throws Throwable {

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("+05:30"));
        Logger log = LogManager.getLogger(joinPoint.getTarget().getClass());
        log.error(new StringBuilder("$$Exception: ").append(exception.getMessage()).toString());
    }

}
