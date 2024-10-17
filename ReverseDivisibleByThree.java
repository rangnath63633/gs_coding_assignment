package coderPadTset;

import java.util.ArrayList;
import java.util.List;

public class ReverseDivisibleByThree {

    public static String findReverseDivisibleByThree(String s){
         /*
        Input: s = “12345632189”
        Output: "12945362183"
         */
        char[] chars = s.toCharArray();

        List<Integer> divisibleByThreeIndices = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - '0';
            if (digit % 3 == 0) {
                divisibleByThreeIndices.add(i);
            }
        }

        int left = 0;
        int right = divisibleByThreeIndices.size() - 1;
        while (left < right) {
            int leftIndex = divisibleByThreeIndices.get(left);
            int rightIndex = divisibleByThreeIndices.get(right);
            char temp = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
    public static void main(String[] args) {

        String s = "12345632189";
        System.out.println(findReverseDivisibleByThree(s));
    }
}
