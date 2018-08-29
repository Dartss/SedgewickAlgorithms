import java.util.*;

public class Dijkstra {
    private static char[] OPS = new char[]{'+', '-', '*', '/'};

    public static int calculate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        char[] exprArr = expression.toCharArray();

        for (int i = 0; i < exprArr.length; i++) {
            char c = exprArr[i];
            if (c == ' ' || c == '(') continue;

            if (contains(OPS, c)) {
                operators.push(c);
            } else if (Character.isDigit(c)) {
                String val = "";
                do {
                    val = val.concat("" + c);
                    c = exprArr[++i];
                } while (Character.isDigit(c));
                values.push(Integer.valueOf(val));
                i--;
            } else if (c == ')') {
                compute(values, operators);
            }
        }

        while (!operators.isEmpty()) {
            compute(values, operators);
        }
        return values.pop();
    }

    private static void compute(Stack<Integer> values, Stack<Character> operators) {
        Integer a = values.pop();
        Integer b = values.pop();
        char op = operators.pop();
        switch (op) {
            case '+':
                values.push(a + b);
                break;
            case '-':
                values.push(b - a);
                break;
            case '*':
                values.push(a * b);
                break;
            case '/':
                values.push(b / a);
                break;
        }
    }

    private static boolean contains(char[] a, char e) {
        for (char c : a) {
            if (c == e) return true;
        }
        return false;
    }

}
