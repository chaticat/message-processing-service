package com.chaticat.messageprocessingservice.payload;

import com.chaticat.messageprocessingservice.enumeration.MessageStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Message {

    private String chatId;
    private Sender from;
    private String content;
    private LocalDateTime timestamp;
    private MessageStatus status;
}
