package com.example.spring_boot_foo_fighters.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotValidAgeException extends RuntimeException {

    public NotValidAgeException(String message) {
        super(message);
    }

}
