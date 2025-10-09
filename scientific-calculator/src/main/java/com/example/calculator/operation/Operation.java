package com.example.calculator.operation;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;

public interface Operation {
    OperationResponse execute(OperationRequest request);
}
