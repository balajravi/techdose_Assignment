class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        toFindSet(0,nums,list,new ArrayList<>());
        return list;
    }
    
public static void toFindSet(int ind,int[] arr,List<List<Integer>> list,List<Integer> ds){
        list.add(new ArrayList<>(ds));

        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1])
                continue;
            
            ds.add(arr[i]);
            toFindSet(i+1,arr,list,ds);
            
            ds.remove(ds.size()-1);
            
        }
    }
}
/*
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]


Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/
