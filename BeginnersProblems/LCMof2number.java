import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(findLCM(num1,num2));
    }
    public static int findLCM(int n1,int n2){   
      return (n1/find(n1,n2))*n2;
    }
    public static int find(int n1,int n2){
        return (n1==0)? n2 :find(n2%n1, n1);
    } 
}
