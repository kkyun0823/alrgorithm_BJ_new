package bj0801;

import java.util.Scanner;

public class BJ_11054 {
	static int[] seq;
	static int[] r_dp;
	static int[] l_dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		seq = new int[N];
		r_dp = new int[N];
		l_dp = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			up(i);
			down(i);
		}


		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int temp = r_dp[i] + l_dp[i] - 1;
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);
	}

	static int up(int x) {
		if (r_dp[x] == 0) {
			r_dp[x] = 1;
			for (int i = x - 1; i >= 0; i--) {
				if (seq[i] < seq[x]) {
					r_dp[x] = Math.max(r_dp[x], up(i) + 1);
				}
			}
		}
		return r_dp[x];
	}

	static int down(int x) {
		if (l_dp[x] == 0) {
			l_dp[x] =1;
			for (int i = x + 1; i < l_dp.length; i++) {
				if (seq[i] < seq[x]) {
					l_dp[x] = Math.max(l_dp[x], down(i) + 1);
				}
			}
		}
		return l_dp[x];
	}
}
