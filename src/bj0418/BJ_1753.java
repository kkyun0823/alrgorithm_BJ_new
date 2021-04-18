package bj0418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1753 {
	static int v,e,k;
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		k = sc.nextInt();
		dist = new int[v+1];
		list = new ArrayList[v+1];
		visited = new boolean[v+1];
		for(int i = 0; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;
		
		for(int i = 0 ; i < e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			list[u].add(new Node(v, w));
		}
		dijkstra();
		for(int i = 1; i < v+1; i++ ) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq =new PriorityQueue<Node>();
		pq.add(new Node(k, 0));
		while(!pq.isEmpty()) {
			Node c = pq.poll();
			if(visited[c.index]) {
				continue;
			}
			visited[c.index] = true;
			for(Node o : list[c.index]) {
				if(dist[c.index]+o.weight < dist[o.index]) {
					dist[o.index] = dist[c.index]+o.weight;
					pq.add(new Node(o.index, dist[o.index]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int index, weight;
	
	public Node(int index, int weight) {
		this.index = index;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		//우선순위큐 이므로 이부분이 중요함!
		return this.weight-o.weight;
	}
	
}
