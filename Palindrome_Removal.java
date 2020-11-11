// reference: https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC%2B%2BPython3-DP-with-Details-Comments
class Solution {
    public int minimumMoves(int[] arr) {
        int N = arr.length;
        int[][] dp = new int[N + 1][N + 1];
        // initial
        for(int[] d: dp){
            Arrays.fill(d, 0);
        }
        // len is the length of the subString we are consider
        for(int len = 1; len <= N; ++len){
            for(int start = 0, end = len - 1; end < N; start++, end++){
                if(len == 1){
                    // 1 step is needed
                    dp[start][end] = 1;
                }else{
                    // current is from subproblem (start + 1, end)
                    dp[start][end] = 1 + dp[start + 1][end];
                    if(arr[start] == arr[start + 1]){
                        dp[start][end] = Math.min(1 + dp[start + 2][end], dp[start][end]);
                    }
                    for(int k = start + 2; k <= end; ++k){
                        if(arr[start] == arr[k]){
                            dp[start][end] = Math.min(dp[start + 1][k - 1] + dp[k + 1][end], dp[start][end]);
                        }
                    }
                }
            }
            
        }
        return dp[0][N - 1];
    }
}