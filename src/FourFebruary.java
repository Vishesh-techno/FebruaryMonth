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

    public static boolean isSorted(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                return false;
            }
        }
        return true;
    }

    public static int findKthRotation(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                return i;
            }
        }
        return 0;
    }

    public static int findKthRotationII(int[] arr){
        int start = 0, end = arr.length-1;
        while(start < end){
            if(arr[start] <= arr[end]) return start;
            int mid = start+(end-start)/2;
            int next = (mid+1)%arr.length;
            int prev = (mid-1+arr.length) % arr.length;
            if(arr[mid] <= arr[next] && arr[mid] <= arr[prev]){
                return mid;
            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(findTriplets(arr));
        System.out.println(isSorted(arr));
        System.out.println(findKthRotation(arr));
        System.out.println(findKthRotationII(arr));

    }
}
