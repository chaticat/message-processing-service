package com.chaticat.messageprocessingservice.chat.service;

import com.chaticat.messageprocessingservice.sender.OutComingMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final OutComingMessageSender outComingMessageSender;

    public void handleIncomingMessage(String message) {
        outComingMessageSender.send(message);
    }
}
