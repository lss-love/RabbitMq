package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "FQue1")
public class FanoutReceiver {

    @RabbitHandler
    public void FanoutReceiver1(String msg){
        System.out.println("msg1 = " + msg);
    }

}
