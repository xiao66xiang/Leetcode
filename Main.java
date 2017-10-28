import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		HashSet<Integer> s = new HashSet<Integer>();
		boolean b[] = new boolean[n];
		for (int i=0;i<n;i++) {
			a[i] = in.nextInt();
			b[i] = false;
			s.add(a[i]);
		}
		
		Arrays.sort(a);
		for (int i=0;i<n-1;i++)
			if (a[n-1]/a[i]<n-i) {
			for (int j=2;j<=(a[n-1]/a[i]);j++) 
				if(s.contains(a[i]*j)){
				b[i] = true;
				break;
			}}
			else {
				for (int j=i+1;j<n;j++)
					if (a[j]%a[i]==0) {
						b[i] = true;
						break;
					}
			}
		boolean first = true;
		
		for (int i=0;i<n;i++)
			if(!b[i]){
				if (first) {System.out.print(a[i]);
				first = false;
				}else
				System.out.print(" "+a[i]);
			}
		
		
		
		
	}
	
}
