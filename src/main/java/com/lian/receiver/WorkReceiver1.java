package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "java2004lss")
public class WorkReceiver1 {

    @RabbitHandler
    public void WorkReceiver(String msg){
        System.out.println("msg2 = " + msg);
    }
}
