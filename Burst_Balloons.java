// 思路 和1039. Minimum Score Triangulation of Polygon 差不多
class Solution {
    int[] copyNums;
    int[][] dp;
    int N;
    public int maxCoins(int[] nums) {
        int n = nums.length; 
        N = n + 2;
        copyNums = new int[N]; //need one extra on left, and one extra on right. for index = 0 left and index = length - 1 right
        copyNums[0] = copyNums[N - 1] = 1;
        for(int i = 0; i < n; ++i){
            copyNums[i + 1] = nums[i];
        }
        
        dp = new int[N][N];
        return getMaxCoins(0, N - 1);
    }
    
    private int getMaxCoins(int start, int end){
        if(start + 1 >= end){
            return 0;
        }
        if(dp[start][end] > 0){
            return dp[start][end];
        }
        int totalCoins = Integer.MIN_VALUE;
        for(int i = start + 1; i < end; ++i){
            totalCoins = Math.max(totalCoins, getMaxCoins(start, i) + copyNums[start]*copyNums[i]*copyNums[end] + getMaxCoins(i, end) );
        }
        dp[start][end] = totalCoins;
        return totalCoins;
    }
}