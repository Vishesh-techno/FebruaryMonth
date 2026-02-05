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



    public static void main(String[] args) {
        int[] nums = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int[] res = productExceptSelf(nums);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
