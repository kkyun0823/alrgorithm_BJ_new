package bj0728;

import java.util.Scanner;

public class BJ_1987 {
	static int R;
	static int C;
	static int[][] map;

	static boolean[] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int course = 1;
	static int maxCourse = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		map = new int[R][C];
		sc.nextLine();

		for (int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = (int) str.charAt(j) - 65;
			}
		}
		visited = new boolean[26];

		dfs(0, 0);
		System.out.println(maxCourse);
	}

	static void dfs(int x, int y) {
		int check = map[x][y];
		visited[check] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
			
			int nCheck = map[nx][ny];
			
			if(visited[nCheck]==true) continue;
			
			maxCourse = Math.max(maxCourse, ++course);
			dfs(nx, ny);
		}
		course--;
		visited[check] = false;
	}

}
