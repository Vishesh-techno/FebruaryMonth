import java.util.ArrayList;
import java.util.Arrays;

public class FiveFebruary {
    public static int[] productExceptSelf(int[] arr) {
        int[] product = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            product[i] = 1;
        }
        int left = 1;
        for (int i = 0; i < arr.length; i++) {
            product[i] *= left;
            left *= arr[i];
        }
        int right = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            product[i] *= right;
            right *= arr[i];
        }
        return product;
    }

    public static void reArrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        int idx = 0;
        while (left <= right) {
            if (idx < n) res[idx++] = nums[right--];
            if (idx < n) res[idx++] = nums[left++];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

    public static int[] reArrangeArrayWithNegative(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0, neg = 1;
        for (int i : nums) {
            if (i > 0) {
                res[pos] = i;
                pos += 2;
            } else {
                res[neg] = i;
                neg += 2;
            }
        }
        return res;
    }

    public static void reArrangeII(ArrayList<Integer> nums) {
        int n = nums.size();
        ArrayList<Integer> res = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            res.add(0);
        }

        int pos = 0, neg = 1;
        for (int i : nums) {
            if (i > 0) {
                res.set(pos, i);
                pos += 2;
            } else {
                res.set(neg, i);
                neg += 2;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            nums.set(i, res.get(i));
        }
    }

    public static void main(String[] args) {
        int[] nums = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int[] res = productExceptSelf(nums);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        reArrangeArray(arr);
        System.out.println(Arrays.toString(arr));

        int[] array = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(reArrangeArrayWithNegative(array)));

        ArrayList<Integer> list = new ArrayList<>();
        for (int x : array) {
            list.add(x);
        }
        reArrangeII(list);
        System.out.println(list);

    }
}
