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
            int waterLevel = Math.max(left[i], right[i]);
            trappedWater += waterLevel - arr[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {

    }
}
