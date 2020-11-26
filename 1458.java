class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int M = n1 + 1;
        int N = n2 + 1;
        int[][] dp = new int[M][N];
        for(int[] d: dp){
            Arrays.fill(d, 0);
        }
        
        for(int i = 1; i < M; ++i){
            for(int j = 1; j < N; ++j){
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i - 1] * nums2[j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                
            }
        }
        
        if(dp[n1][n2] == 0){
            int max1 = Arrays.stream(nums1).max().getAsInt();
            int min1 = Arrays.stream(nums1).min().getAsInt();
            int max2 = Arrays.stream(nums2).max().getAsInt();
            int min2 = Arrays.stream(nums2).min().getAsInt();
            return Math.max(max1*min2, min1*max2);
        }
        
       return dp[n1][n2];
    }
}