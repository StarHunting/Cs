package com.my.cs.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class test {

    @Test
    public void demo01(){
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securitymanager=factory.getInstance();
        SecurityUtils.setSecurityManager(securitymanager);
        Subject subject=SecurityUtils.getSubject();
        AuthenticationToken token =new UsernamePasswordToken("my","123");
        try {
            subject.login(token);
            System.out.println("通过...");
        } catch (AuthenticationException e) {
            System.out.println("输入错误...");
            e.printStackTrace();
        } finally {
            System.out.println("结束...");
        }
        boolean b= subject.isAuthenticated();
    }
}
