package com.my.cs.server.impl;

import com.mongodb.BasicDBObject;
import com.my.cs.pojo.User;
import com.my.cs.server.UserDBSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserDB implements UserDBSer {
    @Autowired
    private MongoTemplate mtp;

    public int insert(User u){
        mtp.insert(u);
        return 1;
    }

    public List<User> query_name(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("嗷嗷嗷"));
        List<User> name = mtp.find(query, User.class);
        return name;
    }

    @Override
    public List<User> query() {
        Query query = new Query();
        Criteria criteria=new Criteria();
        Pattern pattern=Pattern.compile("^.*"+"嗷"+".*$",Pattern.CASE_INSENSITIVE);
        query.addCriteria(criteria.and("name").regex(pattern));
        List<User> name = mtp.find(query,User.class);
        return name;
    }
}
