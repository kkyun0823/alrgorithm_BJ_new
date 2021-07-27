package bj0727;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_3190 {
	// map size
	static int n;
	// apples size
	static int k;
	// direction size;
	static int L;

	// apples location
	static List<Point> apples = new ArrayList<Point>();
	// turn time
	static List<Integer> sec = new ArrayList<Integer>();
	// direction
	static List<Character> dir = new ArrayList<Character>();

	// for direction (오른쪽으로 회전할때 +1, 왼쪽일 때 -1)
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int idx = 0;

	public static void main(String[] args) {
		List<Point> snake = new ArrayList<Point>();
		int size = 1;
		int time = 0;
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		k = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < k; i++) {
			String str = sc.nextLine();
			int x = Integer.parseInt(str.split(" ")[0]);
			int y = Integer.parseInt(str.split(" ")[1]);
			Point p = new Point(x, y);
			apples.add(p);
		}
		
		L = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < L; i++) {
			String str = sc.nextLine();
			sec.add(Integer.parseInt(str.split(" ")[0]));
			dir.add(str.split(" ")[1].charAt(0));
		}
		
		////////////////////////////
		int nx = 1;
		int ny = 1;
		snake.add(new Point(nx, ny));
		loop1 : while(true) {
			time++;
			nx += dx[idx];
			ny += dy[idx];
			
			//사과 획득
			for(int i = 0; i <k; i++) {
				Point p = apples.get(i);
				if (p.x == nx && p.y == ny) {
					size++;
					k--;
					apples.remove(i);
					break;
				}
			}
			
			for(int i = 0; i <snake.size(); i++) {
				Point p = snake.get(i);
				if(p.x==nx && p.y==ny) {
					break loop1;
				}
			}
			//뱀위치 추가
			snake.add(new Point(nx, ny));
			if(snake.size()>size) {
				snake.remove(0);
			}
			
			//game over 조건
			if(nx> n|| ny>n|| nx<1|| ny<1) {
				break;	
			}
			
			
			
			
			//방향전환
			if(sec.contains(time)) {
				char c = dir.get(0);
				dir.remove(0);
				if(c=='D') {
					idx+=1;
					if(idx>3) {
						idx = 0;
					}
				}else if(c=='L') {
					idx-=1;
					if(idx<0) {
						idx = 3;
					}
				}
			}
			
		}
		System.out.println(time);
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "x : "+x+" / y : "+y;
	}
}
