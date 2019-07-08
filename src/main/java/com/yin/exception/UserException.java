package com.yin.exception;

public class UserException extends RuntimeException {
    private String code;

    public UserException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public UserException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }
}
