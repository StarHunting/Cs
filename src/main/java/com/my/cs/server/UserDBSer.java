package com.my.cs.server;

import com.my.cs.pojo.User;

import java.util.List;

public interface UserDBSer {

    public int insert(User u);

    public List<User> query_name();

    public List<User> query();
}
