class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        if(s.isBlank()){
            return 0;
        }
        
        String str = s;
        String[] arr = str.replaceAll("[\\+\\-\\*\\/]", " ").split(" ");
        int i = 0;
        stack.push(Integer.parseInt(arr[i]));
        i++;
        for(int j = 0; j < s.length(); ++j){
            char operation = s.charAt(j);
            if(!Character.isDigit(operation)){
                if(operation == '+'){
                    stack.push(Integer.parseInt(arr[i]));
                }else if(operation == '-'){
                    stack.push(-Integer.parseInt(arr[i]));
                }else if(operation == '*'){
                    stack.push(stack.pop() * Integer.parseInt(arr[i]));
                    
                }else if(operation == '/'){
                    stack.push(stack.pop() / Integer.parseInt(arr[i]));
                }
                i++;
            }
        }
        
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        
        return res;
    }
}