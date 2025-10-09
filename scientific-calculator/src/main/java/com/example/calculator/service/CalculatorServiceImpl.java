package com.example.calculator.service;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;
import com.example.calculator.operation.*;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final Operation sqrtOp = new SqrtOperation();
    private final Operation factorialOp = new FactorialOperation();
    private final Operation lnOp = new LnOperation();
    private final Operation powerOp = new PowerOperation();

    @Override
    public OperationResponse sqrt(OperationRequest request) {
        return sqrtOp.execute(request);
    }

    @Override
    public OperationResponse factorial(OperationRequest request) {
        return factorialOp.execute(request);
    }

    @Override
    public OperationResponse ln(OperationRequest request) {
        return lnOp.execute(request);
    }

    @Override
    public OperationResponse power(OperationRequest request) {
        return powerOp.execute(request);
    }
}
