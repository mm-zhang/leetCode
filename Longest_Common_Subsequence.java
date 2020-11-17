class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        dp = new int[n1 + 1][n2 + 1];
        for(int i = 0; i < n1; ++i){
            for(int j = 0; j < n2; ++j){
                dp[i][j] = -1;
            }
        }
        return helper(text1, 0, text2, 0);
    }
    
    private int helper(String text1, int p1, String text2, int p2){
        if (dp[p1][p2] != -1){
            return dp[p1][p2];
        }
        int res = 0;
        if(text1.charAt(p1) == text2.charAt(p2)){
            res = 1 + helper(text1, p1 + 1, text2, p2 + 1);
        }else{
            res = Math.max(helper(text1, p1 + 1, text2, p2), helper(text1, p1, text2, p2 + 1));
        }
        dp[p1][p2] = res;
        return res;
    }
}