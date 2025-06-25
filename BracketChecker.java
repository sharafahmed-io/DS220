import java.util.Stack;

public class BracketChecker {
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') ||
                    (c == '}' && open != '{') ||
                    (c == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "{[()]}";
        System.out.println("Balanced: " + isBalanced(expr));
    }
}