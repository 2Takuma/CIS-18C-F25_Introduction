import java.util.Stack;
import java.util.HashMap;
import java.util.Scanner;

public class InfixEvaluator {
    static HashMap<String, Integer> precedence = new HashMap<>();

    public static void initPrecedence() { // Call to place values in hashmap
        precedence.put("*", 3);
        precedence.put("/", 3);
        precedence.put("^", 3);
        precedence.put("+", 2);
        precedence.put("-", 2);
        precedence.put("(", 1);
    }
    public static Integer infixEval(String expression) {
        final String DIGITS = "0123456789";
        final String OPERATORS = "*/+-^()";

        Stack<Integer> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        String[] tokenList = expression.split(" ");

        for (String token : tokenList) {
            if (DIGITS.indexOf(token) >= 0) { // if token is a digit, push it to operand stack
                operandStack.push(Integer.valueOf(token));
            }
            else if (token == "(") { // if the token is an open parenthesis, push it to the operator stack
                operatorStack.push(token);
            }
            else if (token == ")") { // if the token is a closing parenthesis, while the top item in the operator stack is not an opening parenthesis, 
                while (operatorStack.peek() != "(") { //                pop the next 2 operands and work operation. Push the result to the operand stack
                    int operand2 = operandStack.pop();
                    int operand1 = operandStack.pop();
                    int result = doMath(operatorStack.pop(), operand1, operand2);
                    operandStack.push(result);
                }
                operatorStack.pop(); // pop the (
            }
            else if (OPERATORS.indexOf(token) >= 0) { // if the token is an operator
                while (!operatorStack.isEmpty() && (precedence.get(operatorStack.peek()) >= precedence.get(token))) { // while the operator stack is not empty, and the precedence of the previous operator is greater than or equal to the token operator
                    int operand2 = operandStack.pop();
                    int operand1 = operandStack.pop();
                    int result = doMath(operatorStack.pop(), operand1, operand2);
                    operandStack.push(result);
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) { // while operator stack is not empty, solve
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = doMath(operatorStack.pop(), operand1, operand2);
                operandStack.push(result);
        }
        return operandStack.pop();
    }

   public static Integer doMath(String operator, Integer operand1, Integer operand2) {
        if (operator.equals("*")) {
            return operand1 * operand2;
        }
        else if (operator.equals("/")) {
            return operand1 / operand2;
        }
        else if (operator.equals("+")) {
            return operand1 + operand2;
        }
        else if (operator.equals("-")) {
            return operand1 - operand2;
        }
        else {
            System.out.println("Error with operator.");
            return -1;
        }
    }

    public static void main(String[] args) {
        initPrecedence();
        System.out.println("Enter infix expression (like 5 + 2 - (2 * 3)): ");
        Scanner scanner = new Scanner(System.in);
        String exprsn = scanner.nextLine();
        System.out.println(infixEval(exprsn));
        scanner.close();
    }

}