package bj0418;

import java.util.Scanner;

public class BJ_14503 {
	static int n, m;
	static int[][] map;
	static int dir;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		dir = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean finalFlag = true;
		map[x][y] = 2;
		while(true) {
			boolean flag = false;
			for(int i = 0; i<4; i++) {
				int nx = x +dx[(dir+3-i)%4];
				int ny = y +dy[(dir+3-i)%4];
				if(map[nx][ny]==0) {
					x = nx;
					y = ny;
					dir =(dir+3-i)%4;
					flag = true;
					map[x][y] =2;
					break;
				}
			}
			if(flag) continue;
			
			int nx = x+dx[(dir+2)%4];
			int ny = y+dy[(dir+2)%4];
			if(map[nx][ny]==1) {
				finalFlag = false;
			}else {
				x = nx;
				y = ny;
			}
			if(!finalFlag) break;
		}
		System.out.println(cal());
	}

	static int cal() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==2) cnt++;
			}
		}
		return cnt;
	}
}
