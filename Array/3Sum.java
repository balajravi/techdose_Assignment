// Time complexity: O(n^2 logn) // where n is the size of array
// Sorting takes O(nlogn) time and loop takes O(n^2) time, So the overall time complexity is O(nlogn + n^2 logn) - O(n^2 logn)
// Space complexity: O(n) // for taking hashset.
    
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List> set = new HashSet<>();
        if(nums.length==0)
            return new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        for(List<Integer> a:set)
            list.add(a);
        
        return list;
    }
}

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
*/
