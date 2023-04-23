class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr = new int[n+2];
        arr[0]=arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){// always starts with first index(1) 
                if(i>j)
                    continue;
                int maxi=0;
                for(int k=i;k<=j;k++){
                    int cost=arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
                    maxi=Math.max(maxi,cost);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][n];
    }
}

class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr = new int[n+2];
        arr[0]=arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return toFind(1,n,arr,dp);
    }
    public static int toFind(int i,int j,int[] arr,int[][] dp){
        if(i>j)
            return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxi=0;
        for(int k=i;k<=j;k++){
            int cost=arr[i-1]*arr[k]*arr[j+1]+toFind(i,k-1,arr,dp)+toFind(k+1,j,arr,dp); // recursively call the function i to k-1 & k+1 to j

            maxi=Math.max(cost,maxi);
        }
        return dp[i][j]=maxi;
    }
}
/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, 
then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:
Input: nums = [1,5]
Output: 10

*/
