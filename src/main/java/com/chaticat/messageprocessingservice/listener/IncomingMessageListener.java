package com.chaticat.messageprocessingservice.listener;

import com.chaticat.messageprocessingservice.chat.service.MessageService;
import com.chaticat.messageprocessingservice.config.KafkaConsumerConfig;
import com.chaticat.messageprocessingservice.payload.MessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncomingMessageListener implements MessageListener<String> {

    private final MessageService messageService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "${kafka.topic.incoming-message.name}", groupId = KafkaConsumerConfig.DEFAULT_GROUP_ID)
    @Override
    public void listen(String message) {
        log.info("message received: {}", message);
        MessageRequest messageRequest = objectMapper.readValue(message, MessageRequest.class);
        messageService.handleIncomingMessage(messageRequest);
    }
}
