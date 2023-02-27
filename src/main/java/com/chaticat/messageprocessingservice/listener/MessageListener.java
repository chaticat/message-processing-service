package com.chaticat.messageprocessingservice.listener;

public interface MessageListener<T> {

    void listen(T message);
}
