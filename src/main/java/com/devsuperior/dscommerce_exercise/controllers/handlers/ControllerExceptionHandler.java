package com.devsuperior.dscommerce_exercise.controllers.handlers;

import com.devsuperior.dscommerce_exercise.dto.CustomError;
import com.devsuperior.dscommerce_exercise.dto.ValidationError;
import com.devsuperior.dscommerce_exercise.services.exceptions.ResourcesNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<CustomError> resourcesNotFound(ResourcesNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(Instant.now(), status.value(), "Invalid data", request.getRequestURI());

        for (FieldError field : e.getBindingResult().getFieldErrors()){
            error.addError(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }
}
