import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SixFebruary {
    public static int longestSubArray(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static int longestSubArrayBetter(int[] arr, int k) {
//        this code is valid only non negative integers Exist
        int n = arr.length;
        int maxLen = 0;
        int l = 0, r = 0, sum = 0;
        while (r < n - 1) {
            sum = sum + arr[r];
            while (sum > k) {
                sum = sum - arr[l];
                l++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static int longestSubArrayOptimal(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int maxLen = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == k) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                res.add(pair);

                int lVal = arr[left];
                int rVal = arr[right];

                while (left < right && arr[left] == lVal) left++;
                while (left < right && arr[right] == rVal) right--;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 10};
        System.out.println(longestSubArray(arr, 15));
        System.out.println(longestSubArrayBetter(arr, 15));
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(getPairs(nums));
    }
}
