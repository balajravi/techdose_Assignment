import java.util.* ;
import java.io.*; 
public class Solution {
     public static int toSolve(int i,int j,int[] values,int[][] dp){
        if(i==j)
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps = values[i-1]*values[k]*values[j]+
                toSolve(i,k,values,dp)+toSolve(k+1,j,values,dp);

            mini=Math.min(mini,steps);
        }
        return dp[i][j]=mini;
     }
	public static int matrixMultiplication(int[] arr , int N) {
		    int n=arr.length;
        int[][] memo = new int[n][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return toSolve(1,n-1,arr,memo);
	}
}


class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][] dp = new int[n][n];
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps=values[i-1]*values[k]*values[j]+dp[i][k]+dp[k+1][j];// same recrusion code

                    mini=Math.min(mini,steps);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][n-1];
    }
}

/*
Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices. 
The cost of matrix multiplication is defined as the number of scalar multiplications. A Chain of matrices A1, A2, A3,.....An is represented by a 
sequence of numbers in an array ‘arr’ where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.

For example:
For arr[ ] = { 10, 20, 30, 40}, matrix A1 = [10 * 20], A2 = [20 * 30], A3 = [30 * 40]

Scalar multiplication of matrix with dimension 10 * 20 is equal to 200.
Input Format:

The first line of input contains an integer ‘T’, denoting the number of test cases. Then each test case follows.

The first line of each test case contains the Integer ‘N’ denoting the number of elements in the array.

The second and the last line of each test case contains ‘N’ single space-separated integers representing the elements of the array.
Output Format:

For each test case, print a single integer, denoting the minimum cost of matrix multiplication.

Output of each test case will be printed on a separate line.
*/
