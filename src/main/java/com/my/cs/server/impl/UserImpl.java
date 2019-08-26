package com.my.cs.server.impl;

import com.my.cs.pojo.User;
import com.my.cs.server.UserSer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserSer {
    //@CachePut(value="user", key="#id", condition="#id%2==1", unless="#result==null")
    @Cacheable(value="user", key="#id", condition="#id%2==0", unless="#result==null")
    public User cc(int id){
        User user=new User("哈士奇","3");
        user.setId(id);
        System.out.println("进入...");
        return user;
    }
}
