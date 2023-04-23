/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

Constraints:

2 <= k <= 9
1 <= n <= 60
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[9];
        for(int i=0;i<9;i++){
            arr[i]=i+1;
        }
        toFindCombination(0,arr,list,0,k,n,new ArrayList<>());
        return list;
    }
    public static void  toFindCombination(int ind,int[] arr,List<List<Integer>> list,int sum,int k,int n,List<Integer> ds){
        if(ind==arr.length){
            if(sum==n && ds.size()==k)
                list.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(arr[ind]);
        sum+=arr[ind];
        toFindCombination(ind+1,arr,list,sum,k,n,ds);
        
        sum-=arr[ind];
        ds.remove(ds.size()-1);
        toFindCombination(ind+1,arr,list,sum,k,n,ds);
    }
}
