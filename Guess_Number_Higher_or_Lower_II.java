// reference: http://www.noteanddata.com/leetcode-375-Guess-Number-Higher-or-Lower-II-java-solution-note.html
class Solution {
    public int getMoneyAmount(int n) {
        int[] arr = new int[n];
        // put the n numbers in array
        for(int i = 0; i < n; ++i){
            arr[i] = i + 1;
        }
        int[][] dp = new int[n][n];
        for(int[] dpi: dp){
            Arrays.fill(dpi, -1);
        }
        return findMinAmount(arr, dp, 0, n - 1);
    }
    private int findMinAmount(int[] arr, int[][] dp, int from, int to){
        if(to <= from){
            return 0;
        }
        if(dp[from][to] != -1){
            return dp[from][to];
        }
        int min = Integer.MAX_VALUE;
        for(int i = from; i <= to; ++i){
            // Math.max(cost[from,i-1], cost[i+1][to]) + arr[i]
            int left = findMinAmount(arr, dp, from, i - 1);
            int right = findMinAmount(arr, dp, i + 1, to);
            int cost = Math.max(left, right) + arr[i];
            min = Math.min(min, cost);
        }
        
        dp[from][to] = min;
        return min;
    }
}