/*
class Solution {
public:
    int minStickers(vector<string>& stickers, string target) 
    {
        int n = target.size();
        vector<int>dp(1<<n,INT_MAX);
        dp[0] = 0;

        for (int state=0; state<(1<<n); state++)
        {
            if (dp[state]==INT_MAX) continue;
            for (string str:stickers)
            {
                int new_state = findNextStatusByUsingStr(state,target,str);
                dp[new_state] = min(dp[new_state], dp[state]+1);
            }
        }
        return dp[(1<<n)-1]==INT_MAX?-1: dp[(1<<n)-1];
    }
    
    int findNextStatusByUsingStr(int status, string target, string s)
    {
        int n = target.size();
        for (auto ch:s)
        {
            // loop over each character in target, if equals to ch and not filled, then set as filled
            for (int k=0; k<n; k++)
            {
                if (((status>>k)&1)==0 && target[k]==ch)
                {
                    status = status+(1<<k);   
                    break;
                }              
            }
        }
        return status;
    }
};
*/


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