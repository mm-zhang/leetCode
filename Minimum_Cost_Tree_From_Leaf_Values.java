// reference: https://www.youtube.com/watch?v=xcYkzSrgOmY&t=14s

class Solution {
    public int mctFromLeafValues(int[] arr){
        int N = arr.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for(int cur: arr){
            while(stack.peek() < cur){
                int minValue = stack.pop();    // this value will be dropped, because is smaller than either left or right side value
                int leafNode = stack.peek();
                int secondSmallerValue = Math.min(leafNode, cur);   // decide pick either left or right as second smallest value as one of the leaf node
                int parent = secondSmallerValue * minValue;
                res += parent;
            }
            stack.push(cur);
        }
        
        while(stack.size() > 2){
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
    
