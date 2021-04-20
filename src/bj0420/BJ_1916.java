package bj0420;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1916 {
	static int n, m;
	static ArrayList<Distance>[] list;
	static int[] costList;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		costList = new int[n + 1];
		visited = new boolean[n+1];
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Distance>();
		}
		Arrays.fill(costList, Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int dest = sc.nextInt();
			int cost = sc.nextInt();
			list[start].add(new Distance(dest, cost));
		}
		int s = sc.nextInt();
		int f = sc.nextInt();
		dijkstra(s);
		System.out.println(costList[f]);

	}
	
	static void dijkstra(int start) {
		costList[start] = 0;
		PriorityQueue<Distance> pq = new PriorityQueue<Distance>();
		pq.add(new Distance(start, 0));
		while(!pq.isEmpty()) {
			Distance d = pq.poll();
			if(visited[d.dest]) {
				continue;
			}
			visited[d.dest] = true;
			for(Distance s : list[d.dest]) {
				if(costList[s.dest]>costList[d.dest]+s.cost) {
					costList[s.dest] = costList[d.dest]+s.cost;
					pq.add(new Distance(s.dest, costList[s.dest]));
				}
			}
		}
	}
}

class Distance implements Comparable<Distance> {
	int dest;
	int cost;

	public Distance(int dest, int cost) {
		this.dest = dest;
		this.cost = cost;
	}

	@Override
	public int compareTo(Distance o) {
		return this.cost - o.cost;
	}

}