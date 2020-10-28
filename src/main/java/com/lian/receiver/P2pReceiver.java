package com.lian.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 创建消费者
 */
@Component
@RabbitListener(queues = "java2004lss")
public class P2pReceiver {

    @RabbitHandler
    public void P2pReceiver(String msg){
        System.out.println("msg = " + msg);
    }

}
