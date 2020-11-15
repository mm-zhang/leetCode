class Solution {
    int[] dp;
    int n;
    public int minStickers(String[] stickers, String target) {
        n = target.length();
        int N = 1 << n;
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int state = 0; state < N; ++state){
            if(dp[state] == Integer.MAX_VALUE){
                continue;
            }
            for(String sticker: stickers){
                int newState = findNextStatusBasedOnCurrentSticker(sticker, target, state);
                dp[newState] = Math.min(dp[newState], dp[state] + 1);
            }
            
        }
        return dp[N-1]==Integer.MAX_VALUE? -1: dp[N-1];
    }
    
    private int findNextStatusBasedOnCurrentSticker(String sticker, String target, int state){
        for (int i = 0; i < sticker.length(); ++i)
        {
            // loop over each character in target, if equals to ch and not filled, then set as filled
            for (int k=0; k<n; k++)
            {
                if (((state>>k)&1)==0 && target.charAt(k)==sticker.charAt(i))
                {
                    state = state+(1<<k);   
                    break;
                }              
            }
        }
        return state; 
    }
}