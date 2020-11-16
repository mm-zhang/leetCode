class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        int m = nums.length;
        int n = quantity.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num: nums){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(quantity);
        return dfs(new ArrayList<>(counts.values()), n - 1, quantity);
    }
    
    private boolean dfs(List<Integer> cnts, int pos, int[] quantity){
        if (pos < 0) {
            return true;
        }
        for (int i = 0; i < cnts.size(); ++i) {
            if (cnts.get(i) >= quantity[pos]) {
                cnts.set(i, cnts.get(i) - quantity[pos]);
                if (dfs(cnts, pos - 1, quantity)) {
                    return true;
                }
                cnts.set(i, cnts.get(i) + quantity[pos]);
            }
        }
        return false;
    }
}