package com.example.demo;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kevin on 2017/12/23.
 */
@Component
public class Consumer {
    //
    @JmsListener(destination ="TEST_QUEUE_LOG")
    public void removeMessage(String msg) {
        System.out.println("["+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"]Receive:"+msg);
    }

}
