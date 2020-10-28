package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "TopicQueue2")
public class TopicReceiver2 {
    @RabbitHandler
    public void TopicQueue2(String msg){
        System.out.println("msg2 = " + msg);
    }
}
