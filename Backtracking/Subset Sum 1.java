// print only the sum
import java.util.*;
class TUF {
    static void subsetSumsHelper(int ind, int sum, ArrayList < Integer > arr, int N, ArrayList < Integer > sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }

        // pick the element 
        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

        // Do-not pick the element
        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
    }

    static ArrayList < Integer > subsetSums(ArrayList < Integer > arr, int N) {

        ArrayList < Integer > sumSubset = new ArrayList < > ();
        subsetSumsHelper(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    public static void main(String args[]) {
        ArrayList < Integer > arr = new ArrayList < > ();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList < Integer > ans = subsetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
/*
Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

Examples:

Example 1:

Input: N = 3, arr[] = {5,2,1}
Output: 0,1,2,3,5,6,7,8

Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],
so the sums we get will be  0,1,2,3,5,6,7,8

Input: N=3,arr[]= {3,1,2}
Output: 0,1,2,3,3,4,5,6

Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. 
[3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
*/



// print the subsets
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
	    List<List<Integer>> list = new ArrayList<>();
	    toFindSubSet(0,nums,nums.length,list1,list);
        return list;
    }
    
    public static void toFindSubSet(int ind,int[] arr,int n,List<Integer> list1,List<List<Integer>> list){
	    if(ind==n){
	        list.add(new ArrayList<>(list1));
	        return;
	    }
	    // Pick the element
	    list1.add(arr[ind]);
	    toFindSubSet(ind+1,arr,n,list1,list);
	    
	    list1.remove(list1.size()-1);
	    // do not pick the element
	    toFindSubSet(ind+1,arr,n,list1,list);
	}
}


/*
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/
