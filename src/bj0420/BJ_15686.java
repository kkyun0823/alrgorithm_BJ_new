package bj0420;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BJ_15686 {
	static int m, n;
	static int[][] map;
	static List<Point> houses;
	static List<Point> chickens;
	static Stack<Point> selected;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		houses = new ArrayList<Point>();
		chickens = new ArrayList<Point>();
		selected = new Stack<Point>();
		
		map = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j<=n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) {
					houses.add(new Point(i, j));
				}else if(map[i][j] ==2) {
					chickens.add(new Point(i, j));
				}
			}
		}
		select(0,0);
		System.out.println(result);
	}
	
	public static void select(int start, int cnt) {
		if(cnt==m) {
			calc();
			return;
		}
		
		for(int i = start; i<chickens.size(); i++) {
			selected.push(chickens.get(i));
			select(i+1, cnt+1);
			selected.pop();
		}
	}
	
	public static void calc() {
		int sum=0;
		for(Point p : houses) {
			int min = Integer.MAX_VALUE;
			for(Point c : selected) {
				int r = Math.abs(p.x-c.x)+Math.abs(p.y-c.y);
				min = Math.min(r, min);
			}
			sum+=min;
		}
		result = Math.min(sum, result);
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
