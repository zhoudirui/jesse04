package com.example.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by kevin on 2017/12/23.
 */
public class ActiveMqTest {

    /**
     *
     */
    public static void main(String[] args)throws  Exception {

        //1 建立ConnectionFactory 工厂对象，需要填写用户名密码。，以及要连接的地址。
        //使用默认的即可，端口号"tcp://localhost:61616"
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616"
        );
        //2 通过ConnectionFactory工厂对象建立一个 connection 连接对象；
        //connection默认是关闭的，需要 .start(） 方法启动
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3  通过connection连接对象创建session 会话（上下文环境对象），用于及受消息。
        //args 1 :是否启动事务 args2:签收模式，一般设置为自动签收。
        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);//Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOLEDGE);
        //connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);//手工签收，实际开发 这种机制更安全。自动签收 发生异常时数据会丢失。
        //4 通过session创建destination对象，用来指定 生产消息的目标 和 消费消息来源的对象。
        // ptp中：destination 称作 queue ; pub/sub中：destination 称作 Topic 主题。程序中可以有多个queue/topic
        Destination destination = session.createQueue("queue1");//Destination destination = session.createQueue("queue2");
        Destination destination2= session.createTopic("topic1");
        //5 通过session 对象产生消息 的生产者/消费者
        MessageProducer messageProducer = session.createProducer(destination);

        MessageProducer messageProducer2 = session .createProducer(destination2);
        //6 设置生产者的消息持久化类型
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //7 最后我们用JMS规范的TextMessage形式创建数据（通过session对象）并且用messageProducer的send
        //发送数据，同理客户端使用receive方法进行数据的接收。最后记得关闭connection连接。
        for (int i = 0; i <10 ; i++) {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("我是消息内容："+i);
            //messageProducer.send(textMessage);
            messageProducer.send(destination,textMessage,DeliveryMode.NON_PERSISTENT,i,5000);
            messageProducer2.send(textMessage);

           // messageProducer2.send(textMessage);
            System.out.println("生产者："+textMessage.getText());
        }
        if(connection!=null){
            connection.close();
            System.out.println("-------------------over-------------------");
        }

    }

}
