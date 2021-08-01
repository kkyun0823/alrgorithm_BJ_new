package bj0801;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1005 {
	static int N; // node
	static int K; // edge
	static int[] temp; // time

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		while (t!=0) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			for(int i = 0 ; i< N+1; i ++) {
				list.add(new ArrayList<Integer>());
			}
			temp = new int[N+1];
			
			for(int i = 1; i < temp.length; i++) {
				temp[i] = sc.nextInt();
			}
			
			int[] indegree = new int[N+1];
			
			
			for(int i = 0; i< K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				list.get(x).add(y);
				indegree[y]++;
			}
			int w = sc.nextInt();
			
			System.out.println(topologicalSort(indegree, list, w));
			
			t--;
		}

	}
	
	static int topologicalSort(int[] indegree, List<List<Integer>> list, int w) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] result = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			result[i] = temp[i];
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(Integer i : list.get(now)) {
				result[i] = Math.max(result[i], result[now]+temp[i]);
				indegree[i]--;
				if(indegree[i]==0) {
					q.offer(i);
				}
			}
		}
		return result[w];
	}
}
