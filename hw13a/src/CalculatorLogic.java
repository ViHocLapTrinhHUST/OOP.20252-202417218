package hw13a.src;
public class CalculatorLogic {
    public double calculate(double a, double b, String op) throws ArithmeticException {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Div by zero");
                yield a / b;
            }
            case "%" -> a % b;
            default -> 0;
        };
    }
}