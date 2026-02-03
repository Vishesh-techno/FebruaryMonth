import java.util.Arrays;
import java.util.Scanner;

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

    }
}
