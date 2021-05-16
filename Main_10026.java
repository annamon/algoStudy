package annapro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_10026 {

	static int N, normal, rg;
	static char[][] picture1, picture2;
	static boolean[][] isVisited1, isVisited2;
	// 1은 일반인(normal), 2는 적록색약인 사람(rg)

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		picture1 = new char[N][N];
		picture2 = new char[N][N];
		isVisited1 = new boolean[N][N];
		isVisited2 = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = scann.next();
			for (int j = 0; j < N; j++) {
				picture1[i][j] = s.charAt(j); // 그림에 칠해진 색 저장
				picture2[i][j] = s.charAt(j);
				if (s.charAt(j) == 'G') {
					picture2[i][j] = 'R';
					// 적록색약인 사람은 빨강과 초록을 하나로 인식하므로 계산하기 편하게 처음부터 초록을 빨강으로 바꾸어 저장
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited1[i][j]) { // 일반인 bfs
					go(i, j, 1);
					normal++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited2[i][j]) { // 적록색약인 사람 bfs
					go(i,j, 2);
					rg++;
				}
			}
		}
		System.out.println(normal + " " + rg);
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	
	private static void go(int x, int y, int num) { // num==1:일반인, num==2:적록색약
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		if(num==1) isVisited1[x][y] = true;
		if(num==2) isVisited2[x][y] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(check(nr,nc)) {	// 범위 먼저 체크
					if(num==1) {	// 일반인		
						if (picture1[now[0]][now[1]] == picture1[nr][nc] && !isVisited1[nr][nc]) {
							// 현재 색과 이동할 색이 같고, 방문하지 않은 곳이라면
							queue.offer(new int[] {nr,nc});						
							isVisited1[nr][nc] = true;
						}
					}
					if(num==2) {	// 적록색약
						if (picture2[now[0]][now[1]] == picture2[nr][nc] && !isVisited2[nr][nc]) {
							queue.offer(new int[] {nr,nc});						
							isVisited2[nr][nc] = true;
						}
					}
				}
			}
		}
	}

	private static boolean check(int r, int c) { // 범위체크
		return r>=0 && r<N && c>=0 && c<N;
	}


}
