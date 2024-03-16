//Alperen Bugay Taşkıran
import java.util.Stack;

public class InfixEvaluator {
    private static int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == '*' || op == '/')
            return 2;
        return 0;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static double applyOperation(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Error");
                }
                return a / b;
        }
        return 0;
    }

    public static double evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            char token = tokens[i];
            if (Character.isDigit(token)) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i++]);
                }
                operandStack.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
                    if (operandStack.size() < 2) {
                        System.out.println("Error");
                        return Double.MIN_VALUE;
                    }
                    operandStack.push(applyOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                operatorStack.push(token);
            } else if (token != ' ') {
                System.out.println("Error" + token);
                return Double.MIN_VALUE;
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operandStack.size() < 2) {
                System.out.println("Error");
                return Double.MIN_VALUE;
            }
            operandStack.push(applyOperation(operatorStack.pop(),  operandStack.pop() ,operandStack.pop()));
        }

        if (operandStack.size() != 1) {
            System.out.println("Error");
            return Double.MIN_VALUE;
        }

        double result = operandStack.pop();
        if (!Double.isFinite(result)) {
            System.out.println("ERROR");
            return Double.MIN_VALUE;
        }

        return result;
    }
}
