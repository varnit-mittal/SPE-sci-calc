package com.example.calculator.controller;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;
import com.example.calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calc")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/sqrt")
    public ResponseEntity<OperationResponse> sqrt(@RequestBody OperationRequest request) {
        OperationResponse resp = calculatorService.sqrt(request);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/factorial")
    public ResponseEntity<OperationResponse> factorial(@RequestBody OperationRequest request) {
        OperationResponse resp = calculatorService.factorial(request);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/ln")
    public ResponseEntity<OperationResponse> ln(@RequestBody OperationRequest request) {
        OperationResponse resp = calculatorService.ln(request);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/power")
    public ResponseEntity<OperationResponse> power(@RequestBody OperationRequest request) {
        OperationResponse resp = calculatorService.power(request);
        return ResponseEntity.ok(resp);
    }
}
