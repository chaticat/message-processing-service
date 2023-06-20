package com.chaticat.messageprocessingservice.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class OutComingMessageSender implements MessageSender<Object> {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic.out-coming-message.name}")
    private String outComingMessageTopic;

    @SneakyThrows
    public void send(Object message) {
        String messageString = objectMapper.writeValueAsString(message);
        CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(outComingMessageTopic, messageString);
        completableFuture.whenComplete((msg, exp) -> {
            if (exp == null) {
                log.debug("Sent message [ %s ] to topic [ %s ]".formatted(message, outComingMessageTopic));
            } else {
                log.error(exp.getMessage());
            }
        });
    }
}