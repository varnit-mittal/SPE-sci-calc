package com.example.calculator.exception;

import com.example.calculator.dto.OperationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CalculationException.class)
    public ResponseEntity<OperationResponse> handleCalcException(CalculationException ex) {
        OperationResponse resp = new OperationResponse();
        resp.setOperation("error");
        resp.setExtra(ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<OperationResponse> handleAny(Exception ex) {
        OperationResponse resp = new OperationResponse();
        resp.setOperation("error");
        resp.setExtra("Internal server error");
        return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
