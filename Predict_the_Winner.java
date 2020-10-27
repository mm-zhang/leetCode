class Solution {
    
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] d: dp){
            Arrays.fill(d, 0); 
        }
        dp[0][0] = nums[0];
        // return recursion(nums, 0, nums.length - 1) >= 0;
        return dp2(nums, dp) >= 0;
    }
    
    // method: 1 recursion
    private int recursion(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }else{
            return Math.max(nums[start]-recursion(nums, start + 1, end), nums[end]-recursion(nums, start, end - 1));
        }
    }
    
    //  method 2: 2d DP
    private int dp2(int[] nums, int[][] dp)
    {
        for(int length = 1; length < nums.length; ++length){
            dp[length][length] = nums[length];
            for(int i = 0, j = length; j < nums.length; ++i, ++j){
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1];
    }
}