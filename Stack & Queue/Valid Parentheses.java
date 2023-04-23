class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if(ch==')' && stack.peek()=='('){
                    stack.pop();
                }else if(ch=='}' && stack.peek()=='{'){
                    stack.pop();
                }else if(ch==']' && stack.peek()=='['){
                    stack.pop();
                }else{
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
