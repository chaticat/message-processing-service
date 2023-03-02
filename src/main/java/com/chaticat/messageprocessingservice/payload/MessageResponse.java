package com.chaticat.messageprocessingservice.payload;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MessageResponse implements Serializable {

    private Message message;
    private Throwable exception;
}
