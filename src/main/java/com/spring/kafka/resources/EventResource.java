package com.spring.kafka.resources;

import com.spring.kafka.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/api/v1/")
public class EventResource {

    @Autowired
    private KafkaProducerService kafkaProducer;

    @PostMapping("add/event")
    public ResponseEntity<String> addEvent(@RequestParam("event") String event) {
        this.kafkaProducer.addEvent(event);
        return ResponseEntity.ok("Event added to kafka topic!");
    }
}
