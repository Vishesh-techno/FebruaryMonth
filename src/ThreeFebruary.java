import java.util.*;

public class ThreeFebruary {
    public static void reverseInGroups(int[] nums, int k) {
        int n = nums.length;
        if (k <= 1) return;
        if (k >= n) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int i = 0; i < n; i += k) {
            int end = Math.min(i + k - 1, n - 1);
            reverse(nums, i, end);
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean hasTripletSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            map.put(arr[i], map.get(arr[i]) - 1);
            for (int j = i + 1; j < arr.length; j++) {
                map.put(arr[j], map.get(arr[j]) - 1);
                int twoSum = arr[i] + arr[j];
                int required = target - twoSum;
                if (map.getOrDefault(required, 0) > 0) {
                    return true;
                }
                map.put(arr[j], map.get(arr[j]) + 1);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        return false;
    }

    public static boolean hasTripletSumII(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = arr[start] + arr[end] + arr[i];
                if (sum == target) return true;
                else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return false;
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    public static ArrayList<Integer> removeDuplicatesII(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr.length == 0) return res;
        res.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                res.add(arr[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the" + n + " values: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the K: ");
        int k = sc.nextInt();
        reverseInGroups(nums, k);
        System.out.println("Reverse in group Operation is performed and the final Array is:");
        System.out.println(Arrays.toString(nums));
        System.out.println(hasTripletSum(nums, k));
        System.out.println(hasTripletSumII(nums, k));
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicatesII(nums));
    }
}
