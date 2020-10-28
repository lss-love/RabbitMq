package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "TopicQueue1")
public class TopicReceiver1 {

    @RabbitHandler
    public void TopicQueue1(String msg){
        System.out.println("msg1 = " + msg);
    }

}
