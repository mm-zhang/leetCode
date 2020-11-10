class Solution {
    int[][] dp;
    int N;
    public int strangePrinter(String s) {
        N = s.length();
        dp = new int[N][N];
        for(int[] d: dp){
            Arrays.fill(d, 0);
        }
        return helper(s, 0, N - 1);
    }
    private int helper(String s, int start, int end){
        if(start > end){
         return 0;   
        }
        if(dp[start][end] > 0){
            return dp[start][end];
        }
        int minTurns = helper(s, start + 1, end) + 1;
        for(int k = start + 1; k <= end; ++k){
            if(s.charAt(start) == s.charAt(k)){
                minTurns = Math.min(minTurns, helper(s, start, k - 1) + helper(s, k + 1, end));
            }
        }
        dp[start][end] = minTurns;
        return minTurns;
        
    }
} 