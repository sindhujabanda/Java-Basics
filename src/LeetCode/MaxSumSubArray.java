package LeetCode;

public class MaxSumSubArray {
    public static int subArrayMaxSum(int[] nums){
        int max_sum = nums[0];
        int current_sum = nums[0];

        for(int i =1; i < nums.length; i++){
            current_sum = Math.max(nums[i], nums[i] + current_sum);
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = subArrayMaxSum(nums);
        System.out.println(result);
    }
}
