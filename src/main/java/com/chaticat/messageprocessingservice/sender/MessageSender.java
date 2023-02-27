package com.chaticat.messageprocessingservice.sender;

public interface MessageSender<T> {

    void send(T message);
}
