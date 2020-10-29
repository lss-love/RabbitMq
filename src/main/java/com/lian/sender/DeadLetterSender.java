package com.lian.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeadLetterSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/DeadLetterSender")
    public String DeadLetterSender(String msg){
        System.out.println("延迟队列开始时间为："+System.currentTimeMillis()/1000);
        rabbitTemplate.convertAndSend(null,"Delay-queue",msg);
        return "OK";
    }
}
