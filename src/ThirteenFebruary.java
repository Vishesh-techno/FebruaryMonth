import java.util.*;

public class ThirteenFebruary {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();

        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String key = new String(ch);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for(Map.Entry<String, List<String>> e: map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
