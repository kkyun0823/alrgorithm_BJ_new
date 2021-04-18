package bj0411;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2178 {
	static int n, m;
	static int arr[][];
	static boolean visited[][];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		m = Integer.parseInt(sc.next());
		arr = new int[n][m];
		visited = new boolean[n][m];
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt("" + str.charAt(j));
			}
		}
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(arr[n - 1][m - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nx = p.x;
			int ny = p.y;
			
			for(int i = 0 ; i <4; i++) {
				int nextX = nx+dx[i];
				int nextY = ny+dy[i];
				if(nextX<0||nextX>=n) {
					continue;
				}
				if(nextY<0||nextY>=m) {
					continue;
				}
				if(arr[nextX][nextY]==1 && visited[nextX][nextY]==false) {
					q.add(new Point(nextX, nextY));
					arr[nextX][nextY] = arr[nx][ny]+1;
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
