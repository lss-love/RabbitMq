package com.lian.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    //创建Queue队列
    @Bean
    public Queue createQue1(){
        return new Queue("FQue1");
    }
    @Bean
    public Queue createQue2(){
        return new Queue("FQue2");
    }

    //创建Exchange交换机
    @Bean
    public FanoutExchange createEx(){
        return new FanoutExchange("FanoutExchange",true,true);
    }

    //绑定队列
    @Bean
    public Binding buildFQue1(FanoutExchange fx){
        return BindingBuilder.bind(createQue1()).to(fx);
    }
    @Bean
    public Binding buildQue2(FanoutExchange fx){
        return BindingBuilder.bind(createQue2()).to(fx);
    }

}
