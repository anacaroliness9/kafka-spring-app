package br.com.lab.kafkaapp.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lab.kafkaapp.kafka.service.Producer;

@RestController 
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/produce_message")
    public void produceMessageToKafkaTopic(@RequestParam("mensagem") String message) {
        this.producer.sendMessage(message);
    }
    
}