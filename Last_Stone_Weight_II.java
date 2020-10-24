class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone: stones){
            sum += stone;
        }
        // we want to find the target in the dp or the num in the dp is closest to target
        int target = sum / 2;
        
        boolean[] dp = new boolean[target + 1];
        // dp[i] represents when sum == i exists, true
        dp[0] = true;
        
        // the number is the closest to target is max
        int max = 0;
        for(int stone: stones){
            for(int i = target; i >= stone; i--){ // i represents the sum
                /* 
                *   for current stone, if exists the sum of (i - stone)
                *   then (i - stone) + stone = i also is the possible sum we want
                */
                dp[i] = dp[i] || dp[i - stone];
                if(dp[i]){
                    if(i == target){
                        // if exists the sum to i, and i == target, return 
                        return sum - target - target;
                    }
                    max = Math.max(i, max); // update, update the max number which is closest to target
                }
            }
        }
        return sum - max - max;
    }
}