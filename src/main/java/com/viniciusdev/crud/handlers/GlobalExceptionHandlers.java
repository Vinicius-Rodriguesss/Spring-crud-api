package com.viniciusdev.crud.handlers;

import com.viniciusdev.crud.exceptions.InvalidTaskDataException;
import com.viniciusdev.crud.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidTaskDataException.class)
    private ResponseEntity<ErrorDTO> InvalidTask(InvalidTaskDataException exception){
        ErrorDTO error = new ErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    private ResponseEntity<ErrorDTO> TaskNotFound(TaskNotFoundException exception){
        ErrorDTO error = new ErrorDTO(HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
