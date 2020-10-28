package com.lian.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建发送者
 */
@RestController
public class P2pSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/p2p")
    public String sendMsg(String msg){
        rabbitTemplate.convertAndSend("","java2004lss",msg);
        return "OK";
    }
}
