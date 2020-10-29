package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "DLQueue")
public class DeadLetterReceiver {
    @RabbitHandler
    public void DLQueue(String msg){
        System.out.println("msg = " + msg);
        System.out.println("延迟队列结束时间为："+System.currentTimeMillis()/1000);
    }
}
