package com.my.cs.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String age;
    private int id;

    public User() {
    }
    //注释
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
