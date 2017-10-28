import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class Main1 {
    public static void main(String[] args) {
    	int a = Integer.MAX_VALUE;
    	int b = Integer.MAX_VALUE;
    	int c = (a+b)/2;
    	System.out.println(c);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int []tx = {-1,1,0,0};
        int []ty = {0,0,1,-1};
        String []map = new String[n];
        for (int i=0;i<n;i++)
        	map[i] = in.next();
        int [][][][]dis = new int[n][m][n][m];
        Queue<Integer>qx = new LinkedList<Integer>();
        Queue<Integer>qy = new LinkedList<Integer>();
        Queue<Integer>qi = new LinkedList<Integer>();
        Queue<Integer>qj = new LinkedList<Integer>();
 //       Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0;i<n;i++)
        	for(int j=0;j<m;j++)
        		for (int u=0;u<n;u++)
        			for(int v=0;v<m;v++)
        				dis[i][j][u][v] = Integer.MAX_VALUE;
        int sx=-1,sy=-1,zx=-1,zy=-1;
        for(int i=0;i<n;i++)
        	for(int j=0;j<m;j++) {
        	
        		if (map[i].charAt(j)=='S') {
        			sx = i;
        			sy = j;
        			qx.offer(i);
        			qy.offer(j);
        		}
        		if (map[i].charAt(j)=='0') {
        			zx = i;
        			zy = j;
        			qi.offer(i);
        			qj.offer(j);
        		}
        	}
        if (sx<0||sy<0||zx<0||zy<0) {
        	System.out.println(-1);
            return;
        }
        dis[sx][sy][zx][zy] = 0;
        while(!qx.isEmpty()) {
        	int x = qx.poll(), y = qy.poll(), u=qi.poll(),v = qj.poll();
 //       	System.out.println(""+x+" "+y+" "+u+" "+v);
        	for(int k=0;k<4;k++) {
        		int kx = x+tx[k],ky = y+ty[k];
        		if (kx>=0&&ky>=0&&kx<n&&ky<m&&map[kx].charAt(ky)!='#') {
        			if (kx!=u || ky!=v) {
        				if (dis[kx][ky][u][v]>dis[x][y][u][v]+1) {
        					dis[kx][ky][u][v]=dis[x][y][u][v]+1;
 //       					System.out.println(""+kx+" "+ky+" "+u+" "+v+" "+dis[kx][ky][u][v]);
        					qx.offer(kx);
        					qy.offer(ky);
        					qi.offer(u);
        					qj.offer(v);
        				}
        			}else {
        				int ku = u+tx[k], kv = v+ty[k];
        				if (ku>=0&&kv>=0&&ku<n&&kv<m&&map[ku].charAt(kv)!='#') {
        					if (dis[kx][ky][ku][kv]>dis[x][y][u][v]+1) {
            					dis[kx][ky][ku][kv]=dis[x][y][u][v]+1;
            					qx.offer(kx);
            					qy.offer(ky);
            					qi.offer(ku);
            					qj.offer(kv);
  //          					System.out.println(""+kx+" "+ky+" "+ku+" "+kv+" "+dis[kx][ky][ku][kv]);
            					if (map[ku].charAt(kv)=='E') {
            						System.out.println(dis[kx][ky][ku][kv]);
            						return;
            					}
            				}
        				}
        			}
        		}
        	}
        	
        }
        
        System.out.println(-1);
        return;
            
        }
}