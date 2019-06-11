package br.com.lab.kafkaapp.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    
    @Value("${app.topic-name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String mensagem) {
        logger.info(String.format("------> Mensagem enviada ao Tópico %s: %s", topicName,mensagem));
        this.kafkaTemplate.send(topicName, mensagem);
    }
}