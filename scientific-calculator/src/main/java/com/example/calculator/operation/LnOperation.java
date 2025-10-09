package com.example.calculator.operation;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;
import com.example.calculator.exception.CalculationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LnOperation implements Operation {
    private final int scale = 10;

    @Override
    public OperationResponse execute(OperationRequest request) {
        BigDecimal x = request.getX();
        if (x == null) throw new CalculationException("Parameter x is required for ln");
        if (x.signum() <= 0) throw new CalculationException("Natural log domain error: x must be > 0");

        double val = Math.log(x.doubleValue());
        BigDecimal result = BigDecimal.valueOf(val).setScale(scale, RoundingMode.HALF_UP);
        return new OperationResponse("ln", result, null);
    }
}
