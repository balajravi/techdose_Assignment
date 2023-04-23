class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        toFindPermutation(nums,list,new ArrayList<>(),new boolean[nums.length]);
        return list;
    }
    public static void toFindPermutation(int[] arr,List<List<Integer>> list,List<Integer> ds,boolean[] used){
        if(ds.size()==arr.length){
            list.add(new ArrayList<>(ds));
        }
        else{
            for(int i=0;i<arr.length;i++){
                if(used[i] || i>0 && arr[i]==arr[i-1] && !used[i-1])
                    continue;
                
                used[i]=true;
                ds.add(arr[i]);
                
                
                toFindPermutation(arr,list,ds,used);
                
                used[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }
}

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2], [1,2,1], [2,1,1]]
 
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
