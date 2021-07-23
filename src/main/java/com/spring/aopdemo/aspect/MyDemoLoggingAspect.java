package com.spring.aopdemo.aspect;

import com.spring.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
    //@Pointcut("execution(* add*(com.spring.aopdemo.Account))")
    @Pointcut("execution(* add*())")
    public void beforeDAO(){}

    //@Before("execution(public void addAccount())")
    //@Before("execution( public void com.spring.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(* add*())")
    @Before("beforeDAO()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {


        System.out.println("\n=====>>> Executing @Before advice ");
        //Account account= (Account) joinPoint.getArgs()[0];
        //System.out.println( account.getName());

    }

    @AfterReturning(pointcut = "execution(  com.spring.aopdemo.Account *())",returning = "result")
    public void afterReturn(Account result){
        System.out.println(result.getName());
       result.name=result.name.toUpperCase();
        System.out.println(result.getName()+"=====>>> Executing @AfterReturn advice\n ");

    }

    @AfterThrowing(pointcut = "execution(  * add*(..))",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println(ex+" =====>>> Executing @AfterThrowing advice\n ");
    }
    @After("execution(  * add*(..))")
    public void after(){
        System.out.println("=====>>> Executing @After advice\n ");

    }


    @Around("execution(void com.spring.aopdemo.dao.MembershipDAO.addAccount() )")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around advice begin");
         long begin=System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end=System.currentTimeMillis();
        System.out.println("@Around ends after:"+(end-begin)+"ms");
    }
}
