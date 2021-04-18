package bj0411;

import java.util.Scanner;

public class BJ_9663 {
	static int n;
	static int[] arr;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];

		nQueen(0);
		System.out.println(count);
	}

	public static void nQueen(int start) {
		if (start == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[start] = i;
			
			if(check(start)) {
				nQueen(start+1);
			}
		}
	}
	
	public static boolean check(int now) {
		for(int i =0; i <now ; i++) {
			if(arr[i] ==arr[now]) {
				return false;
			}
			
			if(Math.abs(i-now)==Math.abs(arr[i]-arr[now])) {
				return false;
			}
		}
		return true;
	}
}
