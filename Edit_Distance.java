class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        int n1 = word1.length();
        int n2 = word2.length();
        int row = n1 + 1;
        int col = n2 + 1;
        int[][] dp = new int[row][col];
        for(int i = 0; i <= n1; ++i){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n2; ++j){
            dp[0][j] = j;
        }
        
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i+1][j], Math.min(dp[i][j], dp[i][j+1]))+1;
                }
            }
        }
        return dp[row-1][col-1];
    }
}