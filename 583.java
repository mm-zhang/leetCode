// 类型 和712 一样
class Solution {
    public int minDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        //total step = n1 + n2 if there is no same chars
        for(int i = 1; i <= n1; ++i){
            for(int j = 1; j <= n2; ++j){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][ j - 1]);
                }
            }
        }
        return n1+ n2 - 2 * dp[n1][n2];
    }
}