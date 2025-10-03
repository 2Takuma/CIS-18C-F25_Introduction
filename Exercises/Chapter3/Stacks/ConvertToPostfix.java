import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;

// Modify the infixToPostfix function to be able to convert carets (^)

public class ConvertToPostfix {

    static HashMap<String, Integer> precedence = new HashMap<>();

    public static void initPrecedence() {
        precedence.put("*", 3);
        precedence.put("/", 3);
        precedence.put("^", 3); // Add carat operator and give it value 3 to make it above add/sub
        precedence.put("+", 2);
        precedence.put("-", 2);
        precedence.put("(", 1);
    }

    public static String infixToPostfix(String infixExpr) {
        final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String DIGITS = "0123456789";
        final String OPERATORS = "*/+-^()"; // add carat to operators

        Stack<String> opStack = new Stack<String>();
        ArrayList<String> postfixList = new ArrayList<String>();

        String[] tokenList = infixExpr.split("");

        for (String token: tokenList) {
            if (LETTERS.indexOf(token) >= 0 || DIGITS.indexOf(token) >= 0) {
                postfixList.add(token);
            }
            else if (token.equals("(")) {
                opStack.push(token);
            }
            else if (token.equals(")")) {
                // pop everything down to the matching open paren
                String topToken = opStack.pop();
                while (!topToken.equals("(")) {
                    postfixList.add(topToken);
                    topToken = opStack.pop();
                }
            } else if (OPERATORS.indexOf(token) >= 0) {
                // pop higher-precedence operations
                while (!opStack.isEmpty() && (precedence.get(opStack.peek()) >= precedence.get(token))) {
                    postfixList.add(opStack.pop());
                }
                // then push this operator
                opStack.push(token);
            }
        }

        // If any operators remain, add them to the postfix expression
        while (!opStack.isEmpty()) {
            postfixList.add(opStack.pop());
        }

        String result = "";
        for (String s: postfixList) {
            result = result + s + " ";
        }
        return result;

    }

    public static void main(String[] args) {
        initPrecedence();
        String expr = "A * B + C * D";
        System.out.println(expr + " --> " + infixToPostfix(expr));

        expr = "( A + B ) * C - ( D - E ) * ( F + G )";
        System.out.println(expr + " --> " + infixToPostfix(expr));

        expr = "5 * 3 ^ (4 - 2)"; // Should expect 5 3 * 4 2 - ^
        System.out.println(expr + " --> " + infixToPostfix(expr));
    }
}