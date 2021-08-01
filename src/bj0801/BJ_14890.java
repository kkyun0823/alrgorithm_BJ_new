package bj0801;

import java.util.Scanner;

public class BJ_14890 {
	static int N;
	static int L;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			// 가로 길
			ans += check(map[i]);

			// 세로 길
			int[] temp = new int[N];
			for (int j = 0; j < N; j++) {
				temp[j] = map[j][i];
			}
			ans += check(temp);

		}
		System.out.println(ans);

	}

	static int check(int[] road) {
		boolean[] ramp = new boolean[N];

		for (int i = 1; i < N; i++) {
			if (road[i - 1] < road[i]) {
				if (road[i] - road[i - 1] > 1) {
					return 0;
				}
				int temp = road[i - 1];
				for (int j = 0; j < L; j++) {
					if (i - 1 - j < 0) {
						return 0;
					}
					if (ramp[i - 1 - j]) {
						return 0;
					}
					if (road[i - 1 - j] != temp) {
						return 0;
					}
					ramp[i - 1 - j] = true;
				}

			} else if (road[i - 1] > road[i]) {
				if (road[i - 1] - road[i] > 1) {
					return 0;
				}
				int temp = road[i];
				for (int j = 0; j < L; j++) {
					if (i + j >= N) {
						return 0;
					}
					if (ramp[i + j]) {
						return 0;
					}
					if (road[i + j] != temp) {
						return 0;
					}
					ramp[i + j] = true;
				}
			}
		}

		return 1;
	}
}
