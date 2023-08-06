package com.spring.kafka.producer;

import com.spring.kafka.models.UserModel;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;


    public void addJsonEvent(UserModel user) {
        LOGGER.info(String.format("Json Event added -> %s", user.toString()));
        Message<UserModel> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "quickstart-json")
                .build();
        kafkaTemplate.send(message);

    }
}
