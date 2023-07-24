package com.anhua.config;

import com.alibaba.fastjson2.JSON;
import com.anhua.dao.User;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @RabbitListener(queues = "simpleQueue2" )
    public void simpleListener(String message){
//        Gson gson = new Gson();
//        User myObject = gson.fromJson(message, User.class);
//
//        System.out.println(myObject.toString());
        System.out.println("简单模式监听器："+message.toString());
    }
    @RabbitListener(queues = "simpleQueue")
    public void simpleListener2(String message){
//        Gson gson = new Gson();
//        User myObject = gson.fromJson(message, User.class);
//
//        System.out.println(myObject.toString());
        System.out.println("简单模式监听器2："+message.toString());
    }
}
