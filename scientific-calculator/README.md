# Scientific Calculator Backend (Spring Boot)

APIs (POST JSON):

- POST /api/v1/calc/sqrt
  - body: { "x": 9 }
- POST /api/v1/calc/factorial
  - body: { "x": 5 }
- POST /api/v1/calc/ln
  - body: { "x": 2.718281828459045 }
- POST /api/v1/calc/power
  - body: { "x": 2, "b": 3 }

Responses:
```
{
  "operation": "sqrt",
  "result": 3.0000000000,
  "extra": null
}
```

Notes & OOP: 
- Each operation implements `Operation` interface.
- `CalculatorServiceImpl` composes operation objects (single responsibility).
- `GlobalExceptionHandler` centralizes error handling.
- `FactorialOperation` uses `BigInteger` for exact integer factorials.

To run:
- `mvn spring-boot:run` or build with `mvn package`.

Example curl:
```
curl -X POST http://localhost:8080/api/v1/calc/sqrt -H "Content-Type: application/json" -d '{"x": 16}'
```
