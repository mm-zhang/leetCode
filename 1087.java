// reference: https://leetcode.jp/leetcode-1087-brace-expansion-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
class Solution {
    List<String> res = new ArrayList<>();
    
    List<List<Character>> list = new ArrayList<>();
    
    public String[] expand(String S) {
        char[] char_str = S.toCharArray(); 
        List<Character> current = new ArrayList<>();
        Boolean isOpenBraces = false;
        for(char ch: char_str){
            if(ch == ','){
                continue;
            }
            if(ch == '{' || ch == '}'){
                isOpenBraces = ch == '{';
                list.add(current);
                current = new ArrayList<>();
                continue;
            }
            
            current.add(ch);
            if(!isOpenBraces){
                list.add(current);
                current = new ArrayList<>();
            }
        }
        // recursion
        helper(list, 0, "");
        String[] arr = new String[res.size()];
        for(int i = 0; i < res.size(); ++i){
            arr[i] = res.get(i);
        }
       Arrays.sort(arr);
        return arr;
        
    }
    
    private void helper(List<List<Character>> list, int index, String str){
        if(index == list.size()){
            res.add(str);
            return;
        }
        List<Character> charList = list.get(index);
        if(charList.size() == 0){
            helper(list, index + 1, str);
            return;
        }
        
        for(Character c: list.get(index)){
            helper(list, index + 1, str + c);
        }
        
    }
}