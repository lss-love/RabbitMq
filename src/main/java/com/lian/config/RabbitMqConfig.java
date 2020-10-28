package com.lian.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //配置注解，可替换xml配置文件
public class RabbitMqConfig {

    @Bean //产生bean对象，交给Spring管理
    public Queue createQue() {
        return new Queue("java2004lss");
    }
}
