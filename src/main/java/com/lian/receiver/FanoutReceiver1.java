package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "FQue2")
public class FanoutReceiver1 {

    @RabbitHandler
    public void FanoutReceiver1(String msg){
        System.out.println("msg2 = " + msg);
    }

}
