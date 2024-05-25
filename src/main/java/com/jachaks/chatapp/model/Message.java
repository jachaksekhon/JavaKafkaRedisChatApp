package com.jachaks.chatapp.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Message {
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime timestamp;
}
