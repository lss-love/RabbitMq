package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "createDirect2")
public class DirectReceiver1 {

    @RabbitHandler
    public void DirectReceiver1(String msg){
        System.out.println("msg2 = " + msg);
    }

}
