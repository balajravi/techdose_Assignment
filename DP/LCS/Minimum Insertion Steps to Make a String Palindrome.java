class Solution {
    public int minInsertions(String s) {
        int len=s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[][]dp=new int[len+1][len+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
      // find the  longest palindromic sub-sequence length the subtract the length with LPS length
        int x = dp[len][len];
        return len-x;
    }
}
/*
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
*/
