package com.spring.kafka.resources;

import com.spring.kafka.models.UserModel;
import com.spring.kafka.producer.JsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/api/v1/json/")
public class JsonEventResource {

    @Autowired
    private JsonProducer jsonProducer;

    @PostMapping("add/event")
    public ResponseEntity<String> addJsonEvent(@RequestBody UserModel user) {
        this.jsonProducer.addJsonEvent(user);
        return ResponseEntity.ok("Json event added to the topic");
    }
}
