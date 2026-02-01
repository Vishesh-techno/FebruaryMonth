import java.util.Scanner;

public class OneFebruary {
    public static boolean areAnagrams(String s1, String s2) {
//         if s1 and s2 have same character with their character count return true;
        if (s1.length() != s2.length()) return false;
        int[] res = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            res[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            res[s2.charAt(i) - 'a']--;
        }

        for (int re : res) {
            if (re != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int start = 0, end = ch.length - 1;
        while (start <= end) {
            if (ch[start] != ch[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The First String: ");
        String s = sc.next();
        System.out.print("Enter The Second String: ");
        String t = sc.next();
        if (areAnagrams(s, t)) {
            System.out.println("The Strings are Anagrams");
        } else {
            System.out.println("The Strings are not Anagrams");
        }
        System.out.print("Enter The String: ");
        String s1 = sc.next();
        if (isPalindrome(s1)) {
            System.out.println("The Strings is Palindrome");
        } else {
            System.out.println("The Strings is not a palindrome");
        }
        System.out.print("Enter The String: ");
        String s2 = sc.next();
        String res = reverseString(s2);
        System.out.println(res);
    }
}
