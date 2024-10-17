package coderPadTset;

public class ShortestSubArrayWithSumK {

    public static int shortestSubArray(int[] arr, int K){

        // nt[] arr = {2, 4, 6, 10, 2, 1}, K = 12
        int minLength = Integer.MAX_VALUE;
        int currentSum =0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            while (currentSum >= K) {
                if (currentSum == K) {
                    minLength = Math.min(minLength, right - left + 1);
                }
                currentSum -= arr[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4,4,2, 6, 10, 2, 1};
        int K = 12;
        System.out.println(shortestSubArray(arr, K));
    }
}
