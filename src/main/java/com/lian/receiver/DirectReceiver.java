package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "createDirect1")
public class DirectReceiver {

    @RabbitHandler
    public void DirectReceiver(String msg){
        System.out.println("msg1 = " + msg);
    }

}
