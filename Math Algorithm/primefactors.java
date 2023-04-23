// TC - O(log(n)) -->  efficient program by TC
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	long N=sc.nextInt();
	findprimeFactors(N);
	}
	public static void findprimeFactors(long N){
	    int div=2;
	    while(N>1){
	        if(N%div==0){
	            System.out.print(div+" ");
	            N/=div;
	        }else{
	            div++;
	        }
	    }
	}
}


// TC - O(sqrt(n))
import java.io.*;
import java.lang.Math;
 
class Main
{
    // A function to print all prime factors
    // of a given number n
    public static void primeFactors(int n)
    {
        // Print the number of 2s that divide n
        while (n%2==0)
        {
            System.out.print(2 + " ");
            n /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                System.out.print(i + " ");
                n /= i;
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            System.out.print(n);
    }
 
    public static void main (String[] args)
    {
        int n = 315;
        primeFactors(n);
    }
}


