package com.spring.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);


    @KafkaListener(topics = "quickstart-event", groupId = "myGroup")
    public void getEvent (String event) {
        LOGGER.info(String.format("Message Received from Kafka topic -> %s", event));
    }
}
