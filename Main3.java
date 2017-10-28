import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        x-=1;
        int []a=new int[n];
        int min=Integer.MAX_VALUE,lx=0,ly,ax=x;
        for (int i=0;i<n;i++){
        	a[i] = in.nextInt();
        	if (a[i]<min) {
        		min = a[i];
        		lx = i;
        	}
        }

        ly = n*(min+1)-lx;
//        System.out.println(ly);
        a[lx]=ly;
        for(int i=0;i<n;i++)
        	if(i!=lx) 
        		a[i]-=ly/n;
        for(int i=1;i<=ly%n;i++) {
        	a[(i+lx)%n]--;
        }
        System.out.print(a[0]);
        for(int i=1;i<n;i++)
        	System.out.print(" "+a[i]);
    }
}