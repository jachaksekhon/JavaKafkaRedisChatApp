package com.jachaks.chatapp.service;

import com.jachaks.chatapp.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "chat_topic", groupId = "group_id")
    public void consume(Message message) {
        System.out.printf("Consumed message: %s%n", message);
        // Logic to handle the received message,
    }
}
