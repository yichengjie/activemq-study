package com.yicj.study.hello;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

public class HelloWorldTest {


    @Test
    public void testMQProducerQueue() throws JMSException {
        //1. 创建工厂连接对象,需要绑定ip和端口
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.221.128:61616") ;
        //2. 使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection() ;
        //3. 开启连接
        connection.start();
        //4. 使用连接对象创建会话(session)对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5. 使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6. 使用会话对象创建一个消息对象
        MessageProducer producer = session.createProducer(queue);
        //7. 使用会话对象创建一个消息
        TextMessage textMessage = session.createTextMessage("hello ! test-queue");
        //8. 发送消息
        producer.send(textMessage);
        //9. 关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void testMQConsumerQueue() throws JMSException, IOException {
        //1. 创建工厂连接对象,需要绑定ip和端口
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.221.128:61616") ;
        //2. 使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection() ;
        //3. 开启连接
        connection.start();
        //4. 使用连接对象创建会话(session)对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5. 使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6. 使用会话对象创建消费者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //7. 想consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(message ->{
            if(message instanceof TextMessage){
                TextMessage textMessage = (TextMessage)message ;
                try {
                    System.out.println("====> " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        // 8. 程序等待接收用户消息
        System.in.read() ;
        //9. 关闭资源
        consumer.close();
        session.close();
        connection.close();
    }

}
