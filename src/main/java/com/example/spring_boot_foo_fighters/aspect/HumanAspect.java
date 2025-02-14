//package com.example.spring_boot_foo_fighters.aspect;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class HumanAspect {
//
//  public static Integer counter = 0;
//
//  @Pointcut("within(com.example.spring_boot_foo_fighters.service.*)")
//  public void allMethodPointcut() {
//  }  // getHumans, getHumanById, saveHuman
//
//  @Pointcut("execution(public * com.example.spring_boot_foo_fighters.service.HumanService.getHumans(..))")
//  public void getHumansPointcut() {
//  }  // getHumans
//
//  @Before("allMethodPointcut()")
//  public void loggingAdvice(JoinPoint jp) {
//    String args = Arrays.stream(jp.getArgs())
//            .map(Object::toString)
//            .collect(Collectors.joining());
//    log.info("loggingAdvice " + args);
//  }
//
//  @After("getHumansPointcut()")
//  public void loggingAfterAdvice() {
//    counter++;
//    log.info("loggingAfterAdvice: " + counter);
//  }
//
//  @Around("within(com.example.spring_boot_foo_fighters.service.*)")
//  public void aroundAdvice(ProceedingJoinPoint joinPoint) {
//    System.out.println("Before invoking method " + joinPoint.getSignature());
//
//    Object value = null;
//
//    try {
//      value = joinPoint.proceed();
//    } catch (Throwable e) {
//      e.printStackTrace();
//    }
//
//    System.out.println("After invoking method. Return value " + value);
//  }
//
//}
//
