import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EightFebruary {
    public static List<Integer> nextSmallerEle(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        res.add(-1);
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && arr[j] >= arr[i]) {
                j++;
            }
            if (j < n) {
                res.add(arr[j]);
            } else {
                res.add(-1);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(nextSmallerEle(nums));
    }
}
