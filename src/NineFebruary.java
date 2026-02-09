import java.util.*;

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

    public static String reverseWords(String s) { //Reverse String with no extra dots
        String[] words = s.split("\\.");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].isEmpty()) continue;
            if (!res.isEmpty()) {
                res.append(".");
            }
            res.append(words[i]);
        }
        return res.toString();
    }

    public static boolean areStringRotated(String s1, String s2) {
        return (s1 + s1).contains(s2);
    }

    public static char firstRepeatingChar(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
        }
        return '$';
    }

    public static char nonRepeatingChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '$';
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis("{{{}}}{([])}"));
        System.out.println(reverseWords("..geeks..for.geeks."));
        System.out.println(areStringRotated("abcd", "cdab"));
        System.out.println(nonRepeatingChar("geeksforgeeks"));
        System.out.println(firstRepeatingChar("Leetcode"));
    }
}
