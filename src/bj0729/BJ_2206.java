package bj0729;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2206 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		N = Integer.parseInt(temp.split(" ")[0]);
		M = Integer.parseInt(temp.split(" ")[1]);
		map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		answer = Integer.MAX_VALUE;
		bfs(0, 0);

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	static void bfs(int x, int y) {
		Queue<Info> q = new LinkedList<Info>();
		q.add(new Info(x, y, 1, 0));
		visited[x][y] = 0;

		while (!q.isEmpty()) {
			Info info = q.poll();
			if (info.x == N - 1 && info.y == M - 1) {
				answer = info.step;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = info.x + dx[i];
				int ny = info.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (visited[nx][ny] <= info.breaks)
					continue;

				if (map[nx][ny] == 0) {
					visited[nx][ny] = info.breaks;
					q.add(new Info(nx, ny, info.step + 1, info.breaks));
				} else {
					if (info.breaks == 0) {
						visited[nx][ny] = info.breaks + 1;
						q.add(new Info(nx, ny, info.step + 1, info.breaks + 1));
					}
				}
			}

		}
	}

}

class Info {
	int x;
	int y;
	int step;
	int breaks;

	Info(int x, int y, int step, int breaks) {
		this.x = x;
		this.y = y;
		this.step = step;
		this.breaks = breaks;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x : " + x + " | y : " + y + " | step : " + step + " | breaks : " + breaks;
	}
}
