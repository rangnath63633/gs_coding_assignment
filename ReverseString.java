package coderPadTset;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) {

        String s = "a good   example";
        s =  s.replaceAll(" +"," ");
        String[] word = s.split(" ");
        List<String> words = Arrays.asList(word);

//        Collections.reverse(words);
//
//        String reverseString = String.join(" ", words);
//        System.out.println(reverseString);

        StringBuffer sb = new StringBuffer();
        for(String w : words.reversed()){
            sb.append(w).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
