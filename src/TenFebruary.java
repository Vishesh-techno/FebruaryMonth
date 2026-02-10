public class TenFebruary {
    public static boolean isIPAddressValid(String s) {
        String[] ip = s.split("\\.");
        for (String part : ip) {
            if (part.isEmpty()) { // part.length() == 0 return false
                return false;
            }

            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            for (char c : part.toCharArray()) {
                if (isDigit(c)) {
                    return false;
                }
            }

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    public static String checkIPv4(String queryIP) {
        String[] ip = queryIP.split("\\.", -1);
        for (String part : ip) {
            if (part.isEmpty()) { // part.length() == 0 return false
                return "Neither";
            }

            if (part.length() > 1 && part.charAt(0) == '0') {
                return "Neither";
            }

            for (char c : part.toCharArray()) {
                if (isDigit(c)) {
                    return "Neither";
                }
            }

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public static String checkIPv6(String queryIP) {
        String[] ip = queryIP.split("\\.", -1);
        if (ip.length != 8) return "Neither";
        for (String part : ip) {
            if (part.isEmpty() || part.length() > 4) { // part.length() == 0 return false
                return "Neither";
            }

            for (char c : part.toCharArray()) {
                if (!isHex(c)) {
                    return "Neither";
                }
            }

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return "Neither";
            }
        }
        return "IPv6";
    }

    private static boolean isDigit(char c) {
        return c < '0' || c > '9';
    }

    private static boolean isHex(char c) {
        return c >= '0' && c <= '9' ||
                c >= 'A' && c <= 'F' ||
                c >= 'a' && c <= 'f';
    }

    public static String validIpAddress(String queryIP) {
        if (queryIP.contains(".")) return checkIPv4(queryIP);
        if (queryIP.contains(":")) return checkIPv6(queryIP);
        return "Neither";
    }

    public static void main(String[] args) {
        System.out.println(isIPAddressValid("222.111.111.111"));

    }
}
