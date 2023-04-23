class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0,s,path,list);
        return list;
    }
    public static void solve(int index,String s,List<String> path,List<List<String>> list){
        if(index==s.length()){
            list.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalinderom(s,index,i))
            {
                path.add(s.substring(index,i+1));
                solve(i+1,s,path,list);  
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean isPalinderom(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]
*/
