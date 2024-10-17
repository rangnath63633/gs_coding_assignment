package coderPadTset;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix product
        result[0] = 1;  // The first element has no prefix, so set it to 1
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix product and multiply with the prefix product
        int suffixProduct = 1;  // Initially 1 because there is no element after the last one
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

        public static void main(String[] args) {
            int[] nums1 = {1, 2, 3, 4};
            int[] result1 = productExceptSelf(nums1);
            // Output: [24, 12, 8, 6]
            System.out.println(Arrays.toString(result1));

            int[] nums2 = {-1, 1, 0, -3, 3};
            int[] result2 = productExceptSelf(nums2);
            // Output: [0, 0, 9, 0, 0]
            System.out.println(Arrays.toString(result2));
        }
}
