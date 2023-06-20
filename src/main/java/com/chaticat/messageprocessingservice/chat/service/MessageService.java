package com.chaticat.messageprocessingservice.chat.service;

import com.chaticat.messageprocessingservice.payload.Message;
import com.chaticat.messageprocessingservice.payload.MessageRequest;
import com.chaticat.messageprocessingservice.payload.MessageResponse;
import com.chaticat.messageprocessingservice.repository.MessageRepository;
import com.chaticat.messageprocessingservice.sender.OutComingMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final OutComingMessageSender outComingMessageSender;

    public void handleIncomingMessage(MessageRequest messageRequest) {
        var message = messageRequest.getMessage();

        Mono<Message> savedMessageMono = messageRepository.save(message);

        savedMessageMono.subscribe(savedMessage -> {
            var messageResponse = new MessageResponse();
            messageResponse.setMessage(message);

            outComingMessageSender.send(messageResponse);
        });
    }
}
