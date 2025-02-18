package Basics;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicates {
    public static boolean hasDuplicates(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i< nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static boolean usingHashSet(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,2,3};
        boolean result = hasDuplicates(nums);
        boolean result2 = usingHashSet(nums);
        System.out.println(result);
        System.out.println(result2);
    }
}
