class Solution {
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for(int i = 0; i < N; ++i){
            B[i] = i;
        }
        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));
        int res = 0;
        int m = N;
        for(int i: B){
            res = Math.max(res, i - m);
            m = Math.min(m, i);
        }
        return res;
    }
}                                  