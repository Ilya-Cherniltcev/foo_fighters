package com.example.spring_boot_foo_fighters.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class RestExceptionResponse {

    private final LocalDateTime timestamp;
    private final Integer status;
    private final String path;
    private final String code;
    private final String message;

}