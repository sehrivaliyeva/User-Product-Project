package az.codebridge.task.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMethodsLog {

    @Before("execution(* az.codebridge.task.service.*.*(..))")
    public void logServiceMethodsBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("METHODS WILL EXECUTED: " + className + "." + methodName);
    }


    @After("execution(* az.codebridge.task.service.*.*(..))")
    public void logServiceMethodsAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("METHODS  EXECUTED: " + className + "." + methodName);
    }


}
