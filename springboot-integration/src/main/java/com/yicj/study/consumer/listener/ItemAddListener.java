package com.yicj.study.consumer.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ItemAddListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            // 从消息中获取itemid
            TextMessage textMessage = (TextMessage)message ;
            String text = textMessage.getText() ;
            System.out.println("item is : " + text);
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
