class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int pOnPopped = 0;
        
        for(int e: pushed){
            stack.push(e);
            while(!stack.empty() && stack.peek() == popped[pOnPopped] && pOnPopped < n){
                stack.pop();
                pOnPopped++;
            }
        }
        
        if(pOnPopped != n || !stack.isEmpty()){
            return false;
        }

        return true;
    }
}