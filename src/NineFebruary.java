import java.util.Stack;

public class NineFebruary {
    public static boolean validParenthesis(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                char top = stk.pop();
                if (c == ']' && top != '[' || c == '}' && top != '{' || c == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis("{{{}}}{([])}"));
    }
}
