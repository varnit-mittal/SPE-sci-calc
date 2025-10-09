package com.example.calculator.operation;

import com.example.calculator.dto.OperationRequest;
import com.example.calculator.dto.OperationResponse;
import com.example.calculator.exception.CalculationException;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FactorialOperation implements Operation {

    @Override
    public OperationResponse execute(OperationRequest request) {
        BigDecimal x = request.getX();
        if (x == null) throw new CalculationException("Parameter x is required for factorial");

        try {
            int n = x.intValueExact();
            if (n < 0) throw new CalculationException("Factorial domain error: x must be >= 0 and integer");

            BigInteger fact = factorial(BigInteger.valueOf(n));
            // return result as BigDecimal (lossy for very large factorials) but include extra info
            BigDecimal result = new BigDecimal(fact);
            return new OperationResponse("factorial", result, "exactValueAsInteger: " + fact.toString());
        } catch (ArithmeticException ae) {
            throw new CalculationException("Factorial requires an integer value that fits in an int");
        }
    }

    private BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return BigInteger.ONE;
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(i);
        }
        return res;
    }
}
