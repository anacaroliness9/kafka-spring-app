package br.com.lab.kafkaapp.kafka.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    
    @KafkaListener(topics = "${app.topic-name}")
    public void receive(String mensagem) throws IOException {
        logger.info(String.format("------> Mensagem consumida do Tópico: %s ", mensagem ));
    }
}