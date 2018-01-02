package com.example.demo;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.broker.region.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kevin on 2017/12/23.
 */
@Component
@EnableScheduling
public class provider {
    /**Mq jms 实例**/
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(provider.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private  static final String SUBJECT ="TEST-ACTIVEMQ-queue";
   // @Autowired
   // private JmsMessagingTemplate jmsMessagingTemplate;
    private static int count =0;
    @Scheduled(fixedDelay = 5000)//每五秒执行一次测试
    public void send(){
        javax.jms.Destination destination = new ActiveMQQueue("TEST-QUEUE-LOG");//这里定义了queue 的key
        String message = "Send AMQ Test ..."+count;
        System.out.println("["+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"]"+message);
        count++;
        //this.jmsMessagingTemplate.convertAndSend(destination,message);

    }

}
