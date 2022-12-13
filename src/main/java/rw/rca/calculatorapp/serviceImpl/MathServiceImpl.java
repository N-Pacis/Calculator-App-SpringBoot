package rw.rca.calculatorapp.serviceImpl;

import org.springframework.stereotype.Service;
import rw.rca.calculatorapp.exception.BadRequestException;
import rw.rca.calculatorapp.exception.InvalidOperationException;
import rw.rca.calculatorapp.service.IMathService;

@Service
public class MathServiceImpl implements IMathService {
    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if("/".equals(operation) && operand2 == (double) 0)
            throw new InvalidOperationException("Cannot divide by 0");

        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "**":
                return Math.pow(operand1,operand2);
            case "log":
                return operand1 * Math.log10(operand2);
            case "ln":
                return operand1 * Math.log(operand2);
            default:
                throw new BadRequestException("Unknown operation");
        }
    }
}
