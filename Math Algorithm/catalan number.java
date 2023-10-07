class catalan{
	public static void main(String[] args) {
		System.out.println(catalanNos(5));
	}
	static int catalanNos(int N){
		return printNCR(2*N,N)/(N+1);
	}
	static int printNCR(int N,int R){
		int[][] dp = new int[N+1][N+1];
		dp[0][0]=1;
		for(int i=1;i<=N;i++){
			dp[i][0]=1;
			for(int j=1;j<=i;j++){
				dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
			}
		}
		return dp[N][R];
	}
}
Formula to find catalan number : (2n)! / ((n + 1)! n!)
