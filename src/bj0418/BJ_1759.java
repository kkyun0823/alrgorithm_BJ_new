package bj0418;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1759 {
	static int l ,c;
	static char[] arr;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		l = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		arr = new char[c];
		result = new int[c];
		str = sc.nextLine().split(" ");
		for(int i =0; i<c; i++) {
			arr[i] = str[i].charAt(0);
		}
		Arrays.sort(arr);
		dfs(0,0,0,0);
		
	}
	
	static void dfs(int start, int dept, int cons, int vow) {
		for(int i = start; i <c;i++) {
			result[i] = 1;
			dfs(i+1, dept+1, cons+(checkVowel(arr[i])? 0:1), vow+(checkVowel(arr[i])? 1:0));
			result[i] = 0;
		}
		if(dept==l&&cons>=2&&vow>=1) {
			print();
		}
	}
	
	static void print() {
		for(int i = 0 ; i <c; i++) {
			if(result[i]==1) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
	
	static boolean checkVowel(char cha) {
		if(cha=='a'||cha=='e'||cha=='i'||cha=='o'||cha=='u') {
			return true;
		}
		return false;
	}
}
