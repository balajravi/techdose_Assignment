public class Solution {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int left=0,right=0,maxLength=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLength=Math.max(maxLength,2*right);
            }else if(right>=left){
                left=right=0;
            }
        }
        left=right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLength=Math.max(maxLength,2*left);
            }else if(left>=right){
                left=right=0;
            }
        }
        return maxLength;
    }
}
/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring.

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
*/
