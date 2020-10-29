package com.lian.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class DeadLetterConfig {

    //创建延迟队列
    @Bean
    public Queue createDelayQueue(){
        //创建一个map集合，放延迟队列的设置信息
        HashMap<String, Object> map = new HashMap<>();
        //设置时间，单位毫秒
        map.put("x-message-ttl",10000);
        //设置死信交换机
        map.put("x-dead-letter-exchange","dead-exchange");
        //设置死信路由关键字
        map.put("x-dead-letter-routing-key","dead-routkey");
        //创建延迟队列
        return QueueBuilder.durable("Delay-queue").withArguments(map).build();
    }

    //创建死信队列
    @Bean
    public Queue createDLQueue(){
        return new Queue("DLQueue");
    }

    //创建死信交换机，注意必须和延迟队列中的名字一样
    @Bean
    public DirectExchange createDirectExchange(){
        return new DirectExchange("dead-exchange",true,true);
    }

    //将死信队列和死信交换机绑定在一起
    @Bean
    public Binding bindDirectExchange(DirectExchange directExchange){
        return BindingBuilder.bind(createDLQueue()).to(directExchange).with("dead-routkey");
    }

}
