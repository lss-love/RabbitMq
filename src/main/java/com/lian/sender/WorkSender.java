package com.lian.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/work")
    public String workMq(String msg){
        rabbitTemplate.convertAndSend("java2004lss",msg);
        return "OK";
    }

}
