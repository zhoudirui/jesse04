package com.example.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by kevin on 2017/12/23.
 */
public class ReceiverTest {

    /**
     *
     */
    public static void main(String[] args)throws  Exception {
        //1
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616"
        );
        //2
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3
        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        //4
        Destination destination = session.createQueue("queue1");

        Destination destinatio2 = session.createTopic("topic1");
        //5
        MessageConsumer messageConsumer = session.createConsumer(destination);

        MessageConsumer messageConsumer2 = session.createConsumer(destinatio2);
        //6 生产者才有的  是否持久化。消费者不需要此步骤
       // messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //7
       /* for (int i = 0; i <5 ; i++) {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("我是消息内容："+i);
            //messageProducer.send(textMessage);
            //System.out.println("生产者："+textMessage.getText());
        }*/

while (true){
        TextMessage msg = (TextMessage)messageConsumer.receive();

    TextMessage msg2 = (TextMessage)messageConsumer2.receive();
        if (msg2 ==null)break;
        System.out.println("收到的内容："+msg.getText()+"topic1:"+msg2.getText());
        }

        if(connection!=null){
        connection.close();
        System.out.println("===============over==============");
        }

        }

        }
