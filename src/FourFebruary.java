import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourFebruary {
    public static boolean findTriplets(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    return true;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int findKthRotation(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return i;
            }
        }
        return 0;
    }

    public static int findKthRotationII(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] <= arr[end]) return start;
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void mergeArray(int[] a, int[] b) { // without extra space
        int i = 0, j = 0, endA = a.length - 1, endB = b.length - 1;
        while (i <= endA && j <= endB) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] >= b[j]) {
                int temp = a[endA];
                a[endA] = b[j];
                b[j] = temp;

                j++;
                endA--;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static int firstRepeated(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) > 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> findOcc(int[] arr, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = find(arr, x, true);
        int right = find(arr, x, false);
        res.add(left);
        res.add(right);
        return res;
    }

    public static int find(int[] arr, int x, boolean isLeft) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                ans = mid;
                if (isLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(findTriplets(arr));
        System.out.println(isSorted(arr));
        System.out.println(findKthRotation(arr));
        System.out.println(findKthRotationII(arr));
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArray(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        int[] nums = {1, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeated(nums));
        int[] nums1 = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        System.out.println(findOcc(nums1, 5));
    }
}
