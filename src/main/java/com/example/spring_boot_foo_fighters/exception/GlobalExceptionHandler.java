package com.example.spring_boot_foo_fighters.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotValidAgeException.class)
    public RestExceptionResponse handleServiceExceptions(NotValidAgeException ex,
                                                         HttpServletRequest request) {
        log.error("Service error, status: message: {}", ex.getMessage());

        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .code("-1")
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestExceptionResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                         HttpServletRequest request) {
        log.error("Service error, status: message: {}", ex.getMessage());

        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .code("-1")
                .message(ex.getFieldError().getDefaultMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerException.class)
    public RestExceptionResponse handleServiceExceptions(ServerException ex,
                                                         HttpServletRequest request) {
        log.error("Service error, status: message: {}", ex.getMessage());

        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .path(request.getRequestURI())
                .code("-1")
                .message("Internal server error")
                .build();
    }

}
