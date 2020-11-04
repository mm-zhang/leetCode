class Solution {
    int N;
    int[][] dp1;
    public int minScoreTriangulation(int[] A) {
        N = A.length;
        dp1 = new int[N][N];
        for(int[] d: dp1){
            Arrays.fill(d, 0);
        }
        return getTotalSum(A, 0, N - 1);
    }
    
     // method 1: using recursion
    // reference: https://www.youtube.com/watch?v=q1tM-6lXwEU
    private int getTotalSum(int[] A, int start, int end){
        // 邻边的情况
        if(start >= end - 1){
            return 0;
        }
        if(dp1[start][end] > 0){
            return dp1[start][end];
        }
        int score = Integer.MAX_VALUE;
        for(int k = start + 1; k < end; ++k){
            score = Math.min(score, getTotalSum(A, start, k) + 
                             getTotalSum(A, k, end) 
                             + A[start] * A[k] * A[end]);
        }
        dp1[start][end] = score;
        return score;
    }
}