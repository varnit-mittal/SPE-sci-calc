package com.example.calculator.dto;

import java.math.BigDecimal;

public class OperationResponse {
    private String operation;
    private BigDecimal result;
    private String extra; // any messages

    public OperationResponse() {}

    public OperationResponse(String operation, BigDecimal result, String extra) {
        this.operation = operation;
        this.result = result;
        this.extra = extra;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
