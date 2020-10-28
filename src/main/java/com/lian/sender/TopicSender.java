package com.lian.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/topic")
    public String topicSender(String msg,String key){
        rabbitTemplate.convertAndSend("TopicExchange",key,msg);
        return "OK";
    }
}
