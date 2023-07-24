package com.anhua.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitSimpleConfig {
    @Bean
    public Queue simpleQueue(){
        return new Queue("simplequeue");
//        return new Queue("workQueue");
    }
}
