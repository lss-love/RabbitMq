package com.lian.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FanoutSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/anoutSender")
    public String FanoutSender(String msg){
        rabbitTemplate.convertAndSend("FanoutExchange","",msg);
        return "OK";
    }
}
