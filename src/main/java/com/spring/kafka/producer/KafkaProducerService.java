package com.spring.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
    @Value("${kafka.topic.name}")
    private String kafkaTopicName;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void addEvent(String event) {
        LOGGER.info(String.format("Event added to kafka topic %s",event));
        kafkaTemplate.send(kafkaTopicName, event);
    }
}
