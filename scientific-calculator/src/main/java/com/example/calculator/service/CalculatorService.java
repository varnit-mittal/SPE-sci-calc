package com.example.calculator.service;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;

public interface CalculatorService {
    OperationResponse sqrt(OperationRequest request);
    OperationResponse factorial(OperationRequest request);
    OperationResponse ln(OperationRequest request);
    OperationResponse power(OperationRequest request);
}
