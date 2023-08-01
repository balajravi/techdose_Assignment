// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         int len=nums.length;
//         return nums[len/2];
//     }
// }


class Solution {
    public int majorityElement(int[] nums) {
        // Moore Voting Algorithm
        int count=0,candidate=0;
        for(int num:nums){
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}


Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
