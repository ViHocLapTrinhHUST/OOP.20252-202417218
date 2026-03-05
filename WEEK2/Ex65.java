import java.util.Scanner;

public class Ex65 {
    public static void main(String[] args) {
         Scanner scanner=  new Scanner(System.in);
         System.out.print(" n = ");
         int n= scanner.nextInt();
         int[] a= new int[n];
         
         for(int i=0;i<n;i++) {
            a[i]= scanner.nextInt();
    }
    int temp;
    for(int i=0;i<n;i++) {
        for(int j=i;j<n-i-1;j++) {
            if(a[j]>a[j+1]) {
                temp=a[j+1];
                a[j+1]=a[j];
                a[j]=temp;
            }
        }
    }
    for(int i=0;i<n;i++) {
        System.out.print(a[i]+ " ");
    }
    scanner.close();
    }
    
}
