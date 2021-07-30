package bj0730;

import java.util.Scanner;

public class BJ_1717 {
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		parent = new int[N+1];
		for(int i = 1 ; i<= N; i++) {
			parent[i] = i;
		}
		int M = sc.nextInt();
		for(int i = 0 ; i< M; i++) {
			int cate = sc.nextInt();
			int temp1 = sc.nextInt();
			int temp2 = sc.nextInt();
			
			for(int j = 0; j<parent.length; j++) {
				System.out.print(parent[j]+" ");
			}
			System.out.println();
			
			if(cate==0) {
				union(temp1, temp2);
			}else {
				if(checkParent(temp1, temp2)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
		
	}
	
	public static int findParent(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = findParent(parent[x]);
	}
	
	public static void union(int temp1, int temp2) {
		temp1 = findParent(temp1);
		temp2 = findParent(temp2);
		
		if(temp1 != temp2) {
			if(temp1 < temp2) {
				parent[temp2] = temp1;
			}else {
				parent[temp1] = temp2;
			}
		}
	}
	
	public static boolean checkParent(int temp1, int temp2) {
		temp1 = findParent(temp1);
		temp2 = findParent(temp2);
		
		if(temp1 == temp2) {
			return true;
		}
		
		return false;
	}
	
	
}
