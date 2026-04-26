1249. Minimum Remove to Make Valid Parentheses

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb = new StringBuilder();
        int open = 0;
        //1. Pass 1 to remove extra close bracket ')'
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
                sb.append(ch);
            }
            else if(ch == ')'){
                if(open > 0){
                    open--;
                    sb.append(ch);
                }
            }
            else{
                sb.append(ch);
            }
        }
        //2. pass 2 to remove extra open bracket '(' BACK TRAVERSAL
        StringBuilder result = new StringBuilder();
        for(int i = sb.length()-1; i>=0; i--){
            char ch = sb.charAt(i);
            if(ch== '(' && open >0){
                open--;
                continue;
            }
            result.append(ch);
        }
        return result.reverse().toString();
    }
}
