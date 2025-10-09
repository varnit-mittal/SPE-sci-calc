package com.example.calculator.service;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private final CalculatorServiceImpl service = new CalculatorServiceImpl();

    @Test
    void sqrtTest() {
        OperationResponse r = service.sqrt(new OperationRequest(new BigDecimal("9"), null));
        assertEquals(0, r.getResult().compareTo(new BigDecimal("3.0000000000")));
    }

    @Test
    void factorialTest() {
        OperationResponse r = service.factorial(new OperationRequest(new BigDecimal("5"), null));
        assertEquals(0, r.getResult().compareTo(new BigDecimal("120")));
    }

    @Test
    void lnTest() {
        OperationResponse r = service.ln(new OperationRequest(new BigDecimal(String.valueOf(Math.E)), null));
        // ln(e) = 1
        assertTrue(r.getResult().doubleValue() > 0.999);
    }

    @Test
    void powerTest() {
        OperationResponse r = service.power(new OperationRequest(new BigDecimal("2"), new BigDecimal("3")));
        assertEquals(0, r.getResult().compareTo(new BigDecimal("8.0000000000")));
    }
}
