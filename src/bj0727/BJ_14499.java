package bj0727;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_14499 {
	static int[] dice = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int nx = sc.nextInt();
		int ny = sc.nextInt();
		
		int k = sc.nextInt();
		
		int[] dx = {0, 0, 0, -1, 1};
		int[] dy = {0, 1, -1, 0, 0};
		
		int[][] map = new int[n][m];
		Queue<Integer> order = new LinkedList<Integer>();
		
		for(int i = 0 ; i <n; i++) {
			for(int j = 0; j <m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < k ; i++) {
			order.offer(sc.nextInt());
		}
		
		while(!order.isEmpty()) {
			int go = order.poll();
			if(nx+dx[go]<0||nx+dx[go]>=n||ny+dy[go]<0||ny+dy[go]>=m) {
				continue;
			}
			nx += dx[go];
			ny += dy[go];
			
			roll(go);
			System.out.println(dice[1]);
			
			if(map[nx][ny]==0) {
				map [nx][ny] = dice[6];
			}else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}
		}
	}
	
	public static void roll(int k) {
		int[] temp = dice.clone();
		switch (k) {
		case 1:
			temp[1] = dice[4];
			temp[3] = dice[1];
			temp[4] = dice[6];
			temp[6] = dice[3];
			break;
		case 2:
			temp[1] = dice[3];
			temp[3] = dice[6];
			temp[4] = dice[1];
			temp[6] = dice[4];
			break;
		case 3:
			temp[1] = dice[5];
			temp[2] = dice[1];
			temp[5] = dice[6];
			temp[6] = dice[2];
			break;
		case 4:
			temp[1] = dice[2];
			temp[2] = dice[6];
			temp[5] = dice[1];
			temp[6] = dice[5];
			break;
		}
		dice = temp;
	}
}
