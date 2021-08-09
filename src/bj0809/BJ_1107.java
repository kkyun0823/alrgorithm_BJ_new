package bj0809;

import java.util.Scanner;

public class BJ_1107 {
	static boolean[] broken;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int target = sc.nextInt();
		int m = sc.nextInt();
		broken = new boolean[10];
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			broken[x] = true;
		}
		int ans = Math.abs(100-target);
		
		for(int i = 0; i < 1000000; i++) {
			int temp = check(i);
			
			if(temp>0) {
				int temp2 = Math.abs(i-target);
				
				if(ans> temp+temp2) {
					ans = temp+temp2;
				}
			}
		}
		System.out.println(ans);
	}
	
	static int check(int x) {
		if(x ==0) {
			if(broken[x]) {
				return 0;
			}else return 1;
		}
		
		int cnt = 0;
		
		while(x>0) {
			if(broken[x%10]) {
				return 0;
			}
			cnt++;
			x = x/10;
		}
		
		return cnt;
	}
}
