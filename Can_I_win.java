class Solution {
    Map<Integer, Boolean> cache = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)
            return true;
        int sum = maxChoosableInteger * (maxChoosableInteger+1) / 2; 
        if (sum < desiredTotal)
            return false;
        return win(maxChoosableInteger, desiredTotal, 0);
    }
    
    boolean win(int maxChoosableInteger, int desiredTotal, int startBit) {
        if (desiredTotal <= 0)
            return false;
        if (cache.containsKey(startBit))
            return cache.get(startBit);
        boolean ans = false;
        for (int i = 0; i < maxChoosableInteger; i++)
            if ((1 << i & startBit) == 0) {
                if (!win(maxChoosableInteger, desiredTotal-i-1, 1 << i | startBit)) {
                    ans = true;
                    break;
                }
            }
        cache.put(startBit, ans);
        return ans;
    }
}