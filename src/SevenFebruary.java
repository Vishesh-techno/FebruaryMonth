import java.util.HashMap;

public class SevenFebruary {
    public static int trappingRainWater(int[] arr) {
        int[] left = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }

        int[] right = new int[arr.length];
        right[right.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < arr.length; i++) {
            int waterLevel = Math.min(left[i], right[i]);
            trappedWater += waterLevel - arr[i];
        }
        return trappedWater;
    }

    public static int maxLength(int[] arr) {
        int maxLen = 0;
        int left = 0, right = 0, sum = 0;
        while (right < arr.length) {
            sum = sum + arr[right];
            if (sum == 0) {
                maxLen = Math.max(right - left + 1, maxLen);
            } else if (sum > 0) {
                sum = sum - arr[left];
                left++;
            }
            right++;
        }
        return maxLen;
    }

    public static int maxLengthOptimal(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int minSizeSubArray(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                sum -= nums[left];
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(trappingRainWater(arr));
        System.out.println(maxLength(arr));
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLengthOptimal(nums));
        System.out.println(minSizeSubArray(7, nums));
    }
}
