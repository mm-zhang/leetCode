class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 0 || nums == null){
            return 0;
        }
        int[] dp = new int[N];
        dp[0] = nums[0];    // if only 1 value in nums
        
        if(N >= 2)
            dp[1] = Math.max(nums[0], nums[1]);     // if only 2 values in nums, then pick max
        for(int i = 2; i < N; ++i){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[N - 1];
    }
}