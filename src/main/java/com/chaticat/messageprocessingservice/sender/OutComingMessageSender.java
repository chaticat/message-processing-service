package com.chaticat.messageprocessingservice.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class OutComingMessageSender implements MessageSender<String> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.topic.out-coming-message.name}")
    private String outComingMessageTopic;

    public void send(String message) {
        CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(outComingMessageTopic, message);
        completableFuture.whenComplete((msg, exp) -> {
            if (exp == null) {
                log.info("Sent message [ %s ] to topic [ %s ]".formatted(message, outComingMessageTopic));
            } else {
                log.error(exp.getMessage());
            }
        });
    }
}