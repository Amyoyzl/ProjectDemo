package com.amy.common.exception;

public class MessageException extends RuntimeException {

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
