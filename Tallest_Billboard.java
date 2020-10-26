class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int rod: rods){
            Map<Integer, Integer> temp = new HashMap<>(map);
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                map.put(key + rod, Math.max(map.getOrDefault(key + rod, 0), val));
                map.put(Math.abs(key - rod), Math.max(map.getOrDefault(Math.abs(key - rod), 0), val + Math.min(rod, key)));
            }
            
        }
        return map.get(0);
    }
}