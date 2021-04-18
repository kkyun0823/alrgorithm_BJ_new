package bj0418;

import java.util.Scanner;

public class BJ_1753_fail {
	static int V, E, K;
	static int INF = 100000;
	static int[][] map;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();

		map = new int[V + 1][V + 1];
		answer = new int[V + 1];
		visited = new boolean[V + 1];
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			map[u][v] = w;
		}
		for (int i = 1; i < V + 1; i++) {
			for (int j = 1; j < V + 1; j++) {
				if (map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		}
		dijkstra(K);
		for(int i = 1 ; i < V+1; i++) {
			if(answer[i]==0) {
				System.out.println(0);
			}else if(answer[i]==INF) {
				System.out.println("INF");
			}else {
				System.out.println(answer[i]);
			}
		}
	}

	public static void dijkstra(int start) {
		for (int i = 1; i < V + 1; i++) {
			answer[i] = map[start][i];
		}
		answer[start] =0;
		visited[start] = true;
		for(int i = 1; i<V-1; i++) {
			int next = getMin();
			visited[next]=true;
			for(int j = 1; j <V+1; j++) {
				if(!visited[j]) {
					if(answer[next]+map[next][j] < answer[j]) {
						answer[j] = answer[next]+map[next][j];
					}
				}
			}
		}
	}
	
	public static int getMin() {
		int min = INF;
		int index = 0;
		for(int i = 1; i <V+1; i++) {
			if(!visited[i]&&answer[i]<min) {
				min = answer[i];
				index= i;
			}
		}
		return index;
	}
}
