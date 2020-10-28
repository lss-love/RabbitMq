package com.lian.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    //创建队列
    @Bean
    public Queue createDirect1(){
        return new Queue("createDirect1");
    }
    @Bean
    public Queue createDirect2(){
        return new Queue("createDirect2");
    }
    //创建Direct交换机
    @Bean
    public DirectExchange createDirectExchange(){
        return new DirectExchange("DirectExchange",true,true);
    }

    //绑定并指定路由关键字
    @Bean
    public Binding bindQue1(DirectExchange directExchange){
        return BindingBuilder.bind(createDirect1()).to(directExchange).with("bindQue1");
    }
    @Bean
    public Binding bindQue2(DirectExchange directExchange){
        return BindingBuilder.bind(createDirect2()).to(directExchange).with("bindQue2");
}
}
