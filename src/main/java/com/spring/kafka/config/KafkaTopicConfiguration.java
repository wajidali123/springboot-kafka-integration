package com.spring.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic quickStartTopicConfig () {
        return TopicBuilder.name("quickstart-event")
                .build();
    }

    @Bean
    public NewTopic JsonTopicConfig () {
        return TopicBuilder.name("quickstart-json")
                .build();
    }
}
