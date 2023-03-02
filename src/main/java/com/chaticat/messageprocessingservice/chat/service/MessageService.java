package com.chaticat.messageprocessingservice.chat.service;

import com.chaticat.messageprocessingservice.payload.MessageRequest;
import com.chaticat.messageprocessingservice.payload.MessageResponse;
import com.chaticat.messageprocessingservice.sender.OutComingMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final OutComingMessageSender outComingMessageSender;

    public void handleIncomingMessage(MessageRequest messageRequest) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage(messageRequest.getMessage());
        outComingMessageSender.send(messageResponse);
    }
}
