// tabulation on O(mn) way ans space O(m)
public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

// tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){ // fill the first row based on the denominations
            dp[0][i]=(i%coins[0]==0)?1:0;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake=dp[i-1][j];

                int take=0;

                if(coins[i]<=j){
                    take=dp[i][j-coins[i]];
                }

                dp[i][j]=take+notTake;
            }
        }
        return dp[n-1][amount];
    }
}

// recrusion with memo
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] memo = new int[n][amount+1];
        for(int[] row:memo)
        {
            Arrays.fill(row,-1);
        }
        return toFindCount(n-1,amount,coins,memo);
    }
    public static int toFindCount(int ind,int amount,int[] coins,int[][] memo){
        if(ind==0)
        {
            if(amount % coins[ind]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(memo[ind][amount]!=-1){
            return memo[ind][amount];
        }

        int notTake=toFindCount(ind-1,amount,coins,memo);

        int take=0;
        if(coins[ind]<=amount)
            take=toFindCount(ind,amount-coins[ind],coins,memo);

        return memo[ind][amount]=take+notTake;
    }
}
