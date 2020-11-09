  class Solution {
    int[][] dp;
    int[] copyCuts;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int N = m + 2;
        dp = new int[N][N];
        copyCuts = new int[N];
        Arrays.sort(cuts);
        copyCuts[0] = 0;
        copyCuts[N - 1] = n;
        for(int i = 0; i < m; ++i){
            copyCuts[i + 1] = cuts[i];
        }
        return helper(0, N - 1);  
    }
    
    private int helper(int start, int end){
        if(dp[start][end] > 0){
            return dp[start][end];
        }
        int leftCost = copyCuts[start];
        int rightCost = copyCuts[end];
        int minCost = Integer.MAX_VALUE;
        // if the interval is <= 1, then cant make a cut
        if(rightCost - leftCost <= 1){
            return 0;
        }
        
        for(int i = start + 1; i < end; ++i){
            minCost = Math.min(minCost, helper(start, i) + helper(i, end));
        }
        
        if(minCost == Integer.MAX_VALUE){
            return 0;
        }else{
            minCost += (rightCost - leftCost);
        }
        dp[start][end] = minCost;
        return minCost;
    }
    
}