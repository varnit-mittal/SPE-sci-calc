package com.example.calculator.dto;

import java.math.BigDecimal;

public class OperationRequest {
    // primary input x
    private BigDecimal x;

    // optional exponent b (used for power)
    private BigDecimal b;

    public OperationRequest() {}

    public OperationRequest(BigDecimal x, BigDecimal b) {
        this.x = x;
        this.b = b;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }
}
