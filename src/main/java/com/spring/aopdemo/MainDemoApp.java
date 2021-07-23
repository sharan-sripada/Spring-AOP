package com.spring.aopdemo;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);

        Account account=new Account("sai");

        try { boolean flag=true;
            accountDAO.addAccount(account,flag);
        }
        catch (Exception exception){
            System.out.println("inside main app ;exception: "+exception);
        }

        System.out.println(accountDAO.getAccount().getName()+"\n");
        membershipDAO.addAccount();

        context.close();
    }
}
