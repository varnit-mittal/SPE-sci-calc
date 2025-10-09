package com.example.calculator.operation;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;
import com.example.calculator.exception.CalculationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerOperation implements Operation {
    private final int scale = 10;

    @Override
    public OperationResponse execute(OperationRequest request) {
        BigDecimal x = request.getX();
        BigDecimal b = request.getB();
        if (x == null || b == null) throw new CalculationException("Parameters x and b are required for power");

        double val = Math.pow(x.doubleValue(), b.doubleValue());
        BigDecimal result = BigDecimal.valueOf(val).setScale(scale, RoundingMode.HALF_UP);
        return new OperationResponse("power", result, null);
    }
}
