package com.spring.aopdemo.dao;


import com.spring.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public  Account getAccount(){
        //System.out.println(getClass()+" :get an account");
        //return account.getName();
        Account account=new Account("sharan");
        return account;

    }
    public  void addAccount(Account account, boolean flag){
        if(flag==true){
            throw new RuntimeException("Exception Thrown\n");
        }
        System.out.println(getClass()+" :Add an account");
    }
}
