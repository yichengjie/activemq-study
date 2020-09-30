package com.yicj.study;

import com.yicj.study.producer.SpringIntegrationProducerApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.*;

@SpringBootTest(classes = SpringIntegrationProducerApp.class)
@RunWith(SpringRunner.class)
public class SpringIntegrationProducerTest {

    @Autowired
    private JmsTemplate jmsTemplate ;
    @Resource(name ="itemAddTopic" )
    private Destination destination ;

    @Test
    public void send(){
        jmsTemplate.send(destination,session ->  {
            TextMessage textMessage = session.createTextMessage("345");
            return textMessage ;
        });

    }
}
