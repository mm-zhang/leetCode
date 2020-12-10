class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        return calculate(s, 0, s.length() - 1);
    }

    // calculate res from s {start - end} portion
    private int calculate(String s, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        int prevOps = '+';
        
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            
            // recursion, open (, close )
            if (ch == '(') {
                int positionOfCloseParathese = findPairdCloseParathese(s, i, end);
                num = calculate(s, i + 1, positionOfCloseParathese - 1);
                i = positionOfCloseParathese;
            }
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            }
            if(!Character.isDigit(ch) || i == end){
                 if (prevOps == '+'){
                     stack.push(num);
                 } else if (prevOps == '-') {
                     stack.push(-num);
                 }else if(prevOps == '*'){
                     stack.push(stack.pop() * num);
                 }else if (prevOps == '/') {
                     stack.push(stack.pop() / num);
                 }
                num = 0;
                prevOps = ch;
            }
           
        
            if(ch == ')'){
                continue;
            }
        }
        
        return sumStack(stack);
    }
    
    private int findPairdCloseParathese(String s, int start, int end) {
        int open = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '(') open++;
            if (s.charAt(i) == ')') open--;
            if (open == 0) return i;
        }
        
        return -1;
    }
    
     private int sumStack(Stack<Integer> stack){
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}