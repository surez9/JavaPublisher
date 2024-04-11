package com.demo.queue;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;

public class RealTImeExample {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");

            JSONObject json = new JSONObject();
            json.put("from_date","01-Jan-2019");
            json.put("to_date","31-Dec-2021");
            json.put("email", "acb@gmail.com");
            json.put("query", "Select * from data");

            TextMessage textMessage = session.createTextMessage(json.toString());

            MessageProducer producer = session.createProducer(destination);
            producer.send(textMessage);

            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
