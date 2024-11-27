package com.stepanew.technicservice.controller.handler;

import com.stepanew.technicservice.exception.TechnicNotFoundException;
import com.stepanew.technicservice.exception.message.ErrorMessage;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class TechnicExceptionHandler {

    @ExceptionHandler(TechnicNotFoundException.class)
    public ErrorMessage handleNotFoundException(TechnicNotFoundException exception) {
        logError(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ErrorMessage(exception.getMessage(), HttpStatus.NOT_FOUND.toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorMessage handleConstraintViolationException(ConstraintViolationException exception) {
        logError(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
    }

    private static void logError(String exception, HttpStatus httpStatus) {
        log.error(
                "Перехвачена ошибка с сообщением: {} и статус-кодом: {}",
                exception,
                httpStatus.value()
        );
    }

}
