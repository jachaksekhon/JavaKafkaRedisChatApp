package com.jachaks.chatapp.controller;

import com.jachaks.chatapp.model.Message;
import com.jachaks.chatapp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
