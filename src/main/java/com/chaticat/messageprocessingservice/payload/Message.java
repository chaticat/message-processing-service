package com.chaticat.messageprocessingservice.payload;

import com.chaticat.messageprocessingservice.enumeration.MessageStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Message {

    @Id
    private String messageId;
    private String chatId;
    private Sender from;
    private String content;
    private LocalDateTime timestamp;
    private MessageStatus status;
}
