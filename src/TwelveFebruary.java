import java.util.HashMap;
import java.util.Map;

public class TwelveFebruary {
    public static boolean isIsomorphicStrings(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (!mapST.containsKey(chS) && !mapTS.containsKey(chT)) {
                mapST.put(chS, chT);
                mapTS.put(chT, chS);
            } else if (mapST.get(chS) == null) {
                return false;
            } else if (mapTS.get(chT) == null) {
                return false;
            } else if (mapST.get(chS) != chT && mapTS.get(chT) != chS) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicStrings("egg", "nee"));
    }
}
