import java.util.Arrays;
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

    public static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }

    public static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <= 2) return nums.length;
        int idx = 2;
        for(int i = 2; i<nums.length; i++){
            if(nums[i] != nums[idx-2]){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicStrings("egg", "nee"));
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
        System.out.println(removeDuplicates(nums));
    }
}
