import React, { useState } from "react";
import "./Calculator.css"; // Importing CSS for styling

const Calculator = () => {
  let [number, setNumber] = useState("");
  const [base, setBase] = useState("");
  const [result, setResult] = useState("");
  const [activeField, setActiveField] = useState("number");

  const backend = "http://localhost:8081/api/v1/calc"; // Spring Boot server

  const handleCalculate = async (operation) => {
    let url = "";
    let body = {};

    if (operation === "power") {
      url = `${backend}/power`;
      if (!number) {
        number = 1;
      }
      body = { "x": parseFloat(base), "b": parseFloat(number) };
    } else {
      url = `${backend}/${operation}`;
      body = { "x": parseFloat(base) };
    }

    try {
      const response = await fetch(url, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body),
      });
      const data = await response.json();
      setResult(data.result ?? "Error");
    } catch {
      setResult("Server error");
    }
  };

  const handleClear = () => {
    setNumber("");
    setBase("");
    setResult("");
  };

  const handleNumberClick = (value) => {
    if (activeField === "number") {
      setNumber((prev) => prev + value);
    } else {
      setBase((prev) => prev + value);
    }
  };

  return (
    <div className="calculator">
      <div className="display">
        <input
          type="text"
          value={number}
          onFocus={() => setActiveField("number")}
          onChange={(e) => setNumber(e.target.value)}
          placeholder="Enter value (x)"
          className="display-input"
        />
        <input
          type="text"
          value={base}
          onFocus={() => setActiveField("base")}
          onChange={(e) => setBase(e.target.value)}
          placeholder="Enter base value (b)"
          className="display-input"
        />
        <div className="result-display">{result && `Result: ${result}`}</div>
      </div>

      <div className="keypad">
        {[1, 2, 3, 4, 5, 6, 7, 8, 9, 0].map((num) => (
          <button key={num} onClick={() => handleNumberClick(num)} className="key">{num}</button>
        ))}
        <button onClick={() => setNumber("")} className="key clear">Clear x</button>
        <button onClick={() => setBase("")} className="key clear">Clear b</button>
      </div>

      <div className="buttons">
        <button onClick={() => handleCalculate("sqrt")} className="button">√x</button>
        <button onClick={() => handleCalculate("factorial")} className="button">x!</button>
        <button onClick={() => handleCalculate("ln")} className="button">ln(x)</button>
        <button onClick={() => handleCalculate("power")} className="button">x^b</button>
        <button className="button clear" onClick={handleClear}>Clear All</button>
      </div>
    </div>
  );
};

export default Calculator;
