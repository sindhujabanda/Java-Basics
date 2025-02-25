package LeetCode;

import java.util.HashMap;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(target == nums[mid]){
                return mid;
            } else if(target > nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        int[] nums = {1,2,4,5};
        int target = 3;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }
}
