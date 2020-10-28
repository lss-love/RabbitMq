package com.lian.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    //创建队列
    @Bean
    public Queue createTopic1(){
        return new Queue("TopicQueue1");
    }
    @Bean
    public Queue createTopic2(){
        return new Queue("TopicQueue2");
    }

    //创建交换机
    @Bean
    public TopicExchange createTopicExchange(){
        return new TopicExchange("TopicExchange",true,true);
    }

    //绑定队列,#号代表任意单词，*代表一个或多个单词
    @Bean
    public Binding bindTopic1(TopicExchange topicExchange){
        return BindingBuilder.bind(createTopic1()).to(topicExchange).with("TopicQueue1.#");
    }
    @Bean
    public Binding bindTopic2(TopicExchange topicExchange){
        return BindingBuilder.bind(createTopic2()).to(topicExchange).with("TopicQueue2.*");
    }
}
