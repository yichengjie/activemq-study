package com.yicj.study;

import com.yicj.study.consumer.SpringIntegrationConsumerApp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

@SpringBootTest(classes = SpringIntegrationConsumerApp.class)
@RunWith(SpringRunner.class)
public class SpringIntegrationConsumerTest {

    @Autowired
    private JmsTemplate jmsTemplate ;

    @Resource(name ="itemAddTopic" )
    private Destination queueDestination ;




}
