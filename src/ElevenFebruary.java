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

    public static String multiplyString(String s1, String s2) {
//        this is valid for smaller values
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int ab = a * b;
        return Integer.toString(ab);
    }

    public static String multiply(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(isRotated("amazon", "azonam"));
        System.out.println(multiplyString("0033", "2"));
    }
}
