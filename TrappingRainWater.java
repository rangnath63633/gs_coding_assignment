package coderPadTset;

public class TrappingRainWater {

    // Method to calculate the total trapped water
    public static int trap(int[] arr){

        // Edge case: if the array is empty or null, return 0
        if(arr == null && arr.length == 0){
            return 0;
        }
        //{4,2,0,3,2,5};
       // [0,1,0,2,1,0,1,3,2,1,2,1]

        // left starting from the left end, right from the right end
        int left = 0, right =arr.length-1;
        // Variables to store the maximum arr encountered from the left and right sides
        int leftMax = 0, rightMax = 0;
        // Variable to store the total amount of trapped water
        int trapWater = 0;

        // Loop until the two pointers meet
        while(left < right){
            // If the arr at the left pointer is less than the arr at the right pointer
            if(arr[left] < arr[right]){
                // If the current arr at the left is greater than or equal to leftMax, update leftMax
                if(arr[left] >= leftMax){
                    leftMax = arr[left];
                }else{
                    // Else, calculate trapped water by subtracting the current arr from leftMax
                    trapWater += leftMax - arr[left];
                }
                left++;
            }else {
                // If the arr at the right pointer is less than or equal to the arr at the left
                // If the current arr at the right is greater than or equal to rightMax, update rightMax
                if(arr[right] >= rightMax){
                    rightMax = arr[right];
                }else{
                    // Else, calculate trapped water by subtracting the current arr from rightMax
                    trapWater += rightMax - arr[right];
                }
                right--;
            }
        }
        return trapWater;
    }
    public static void main(String[] args) {
      //  int[] arr = {4,2,0,3,2,5};
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
