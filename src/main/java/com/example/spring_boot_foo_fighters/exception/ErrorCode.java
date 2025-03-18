package com.example.spring_boot_foo_fighters.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public enum ErrorCode {

    AGE_NOT_VALID("Your age less than 6"),
    NAME_NOT_VALID("Your name: %s length must be less than 15 symbols");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }

}
