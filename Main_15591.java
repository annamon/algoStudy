package annapro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_15591 {

	static int N, Q, answer; 
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		Q = scann.nextInt();

		List<int[]>[] mootube = new ArrayList[N+1]; // 문제에서 영상 번호가 1부터기에 인덱스 맞춰줌

		for (int i = 1; i <= N; i++)
			mootube[i] = new ArrayList<>();

		for (int i = 1; i < N; i++) {
			int p = scann.nextInt();
			int q = scann.nextInt();
			int r = scann.nextInt();
			mootube[p].add(new int[] {q, r});
			mootube[q].add(new int[] {p, r});
			// 동영상 p, q, r(USADO) 입력받아 저장하기
		}

		for (int t = 0; t < Q; t++) {
			// 영상 v를 볼 때, k(USADO) 이상인 추천동영상 개수 찾기
			int k = scann.nextInt();
			int v = scann.nextInt();
			boolean[] watch = new boolean[N+1]; // 문제에서 영상 번호가 1부터기에 인덱스 맞춰줌
			watch[v] = true; // 영상 v 시청
			answer = 0;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(v);

			while (!q.isEmpty()) {
				int now = q.poll(); // 현재 영상
				List<int[]> list = mootube[now]; // 현재 영상과 연결된 영상 가져오기
				for (int i = 0; i < list.size(); i++) {					
					if (!watch[list.get(i)[0]] && list.get(i)[1] >= k) { // 연결된 영상을 아직 안 골랐고, 그 영상의 usado가 k 이상이라면
						q.add(list.get(i)[0]);  // 영상 추가
						watch[list.get(i)[0]] = true; // 추천 true
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

}
