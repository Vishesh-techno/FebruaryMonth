public class ElevenFebruary {
    public static boolean isRotated(String s1, String s2) {
        // s1 is rotated 2 places if s2 is same then true;
        if (s1.length() != s2.length()) return false;
        if (s1.length() < 2) {
            return s1.equals(s2);
        }
        String left = s1.substring(2) + s1.substring(0, 2);
        String right = s1.substring(s1.length() - 2) + s1.substring(0, s1.length() - 2);
        return s2.equals(left) || s2.equals(right);
    }

    public static void main(String[] args) {

    }
}
