package com.my.cs.test;

import com.my.cs.pojo.User;
import com.my.cs.server.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Test03 {
    @Autowired
    private UserSer u;

    @GetMapping("/getUser")
    @ResponseBody
    public User getUser(int id) {
        System.out.println("UsersController:"+id);
        return u.cc(id);
    }

}
