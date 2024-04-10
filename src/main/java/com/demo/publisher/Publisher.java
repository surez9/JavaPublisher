package com.demo.publisher;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");

            /*
            * if multiple consumer are listening to the message then the queue pass the message in round robin
            * eg. 1st, 4th message to consumer 1
            *     2nd, 3rd message to consumer 2
             */

            String[] messages = {"First message","Second Message", "Third message", "Fourth message"};

            MessageProducer producer = session.createProducer(destination);

            for (String message: messages
                 ) {
                TextMessage textMessage = session.createTextMessage(message);
                producer.send(textMessage);
            }

            System.out.println("Message Published");
            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
