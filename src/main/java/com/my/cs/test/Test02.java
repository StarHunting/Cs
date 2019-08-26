package com.my.cs.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.Map;

public class Test02 {
    @Test
    public void cs(){
        Jedis jedis=new Jedis("192.168.40.131",6379);
        jedis.auth("root");
        System.out.println("连接成功...");
        System.out.println("主"+"6379"+":"+jedis.ping());

        jedis.hset("ma","id","1");
        jedis.hset("ma","name","瓜皮");
        jedis.hsetnx("ma","id","2");
        jedis.hsetnx("ma","age","19");

        Jedis jedis2=new Jedis("192.168.40.131",6380);
        jedis2.auth("root");
        System.out.println("从"+"6380"+":"+jedis2.ping());
        List<String> list=jedis2.hmget("ma","id");
        System.out.println("id数据:"+list);

        Map<String, String> ma = jedis2.hgetAll("ma");
        System.out.println("ma中的数据:"+ma);

        Jedis jedis3=new Jedis("192.168.40.131",6381);
        jedis3.auth("root");
        System.out.println("从"+"6381"+":"+jedis3.ping());
        boolean b=jedis.hexists("ma","cc");
        boolean b2=jedis.hexists("ma","age");
        System.out.println("是否存在cc:"+b+";是否存在age:"+b2);

        jedis.hincrBy("ma","id",1);
        String id=jedis.hget("ma","id");
        System.out.println("新id:"+id);
    }

}
