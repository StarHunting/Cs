package com.my.cs.test;

import com.my.cs.pojo.User;
import com.my.cs.server.UserDBSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Test04 {
    @Autowired
    private UserDBSer udb;

    @GetMapping("/mongodb")
    @ResponseBody
    public int insert() {
        System.out.println("进入....");
        User u=new User();
        u.setId(3);
        u.setAge("10");
        u.setName("嗷嗷嗷");
        return udb.insert(u);
    }

    @GetMapping("/mongodb_query")
    @ResponseBody
    public List<User> name(){
        System.out.println("进入查询....");
        return udb.query_name();
    }

    @GetMapping("/mongodb_query_mh")
    @ResponseBody
    public List<User> query_mh(){
        System.out.println("进入模糊查询....");
        return udb.query();
    }
}
