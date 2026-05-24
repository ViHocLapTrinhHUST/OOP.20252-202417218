package hw13a;
public class CalculatorLogic {
    public double calc(double a, double b, String op) throws ArithmeticException {
        switch(op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if(b == 0) throw new ArithmeticException("Div by 0");
                return a / b;
            case "%": return a % b;
            default: return 0;
        }
    }
}