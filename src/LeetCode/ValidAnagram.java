package LeetCode;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagaram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args){
        String s = "car";
        String t = "rat";
        boolean result = isAnagaram(s,t);
        System.out.println(result);
    }
}
