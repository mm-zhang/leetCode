class Solution {
    boolean [][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        
        // append extra char in the front of each string, just for easier search and mapping in dp
        s1 = "#" + s1;
        s2 = "#" + s2;
        s3 = "#" + s3;
        
        
        dp = new boolean[m + 1][n + 1]; // since s1 and s2's length increased by 1
        
        for(boolean[] d: dp){
            Arrays.fill(d, false);
        }
        
        // compare the first chars
        dp[0][0] = true; // since the first two chars same
        
        // only compare s1's each char with s2's first char
        for(int i = 1; i <= m; ++i){
            dp[i][0] = (dp[i - 1][0] == true && s1.charAt(i) == s3.charAt(i));
        }
        
        // only compare s2's each char with s1's first char
        for(int j = 1; j <= n; ++j){
            dp[0][j] = (dp[0][j - 1] == true && s2.charAt(j) == s3.charAt(j));
        }
        
        // compare i to j
        // either ends with s1's last char, or ends with s2's last char
        /* 
            by pattern if:
                        s1: xxxx i
                        s2: yyyy j
                    then:
                        s3: zzzzzz i or zzzzzz j
            in example 2: false, 
            1. assume ends by cc, then last two chars in s3 are from s1 last two chars
                thus previous chars could be s2's last chars, should be a. however, s3.length - 3 positon is c, not matched, false
            2. assume ends by c, then not correct, s2 ends by a, false
            
        */
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                
                // 1st condition: 
                if(s1.charAt(i) == s3.charAt(i + j) && dp[i - 1][j] == true){
                    dp[i][j] = true;
                }
                // 2nd condition: 
                else if(s2.charAt(j) == s3.charAt(i + j) && dp[i][j- 1] == true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
        
    }
}