class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        int asciiSum1 = 0;
        int asciiSum2 = 0;
        
        for(int i = 0; i < n1; i++) {
            asciiSum1 += s1.charAt(i);
        }
        for(int j = 0; j < n2; j++) {
            asciiSum2 += s2.charAt(j);
        }
        
        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 当前到dp, based on previous char
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    // get the max number of equal chars
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return asciiSum1 + asciiSum2 - (2 * dp[n1][n2]);
        
    }
}