package com.lian.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/directSender")
    public String DirectSender(String msg,String key){
        rabbitTemplate.convertAndSend("DirectExchange",key,msg);
        return "OK";
    }
}
