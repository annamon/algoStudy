import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2021.06.06
 * 256MB/2초
 * 14148KB/132ms/조합
 * 
 * NxN 크기의 복도  (3 ≤ N ≤ 6) 
 * T 선생님들은 자신의 위치에서 상, 하, 좌, 우 4가지 방향으로 감시를 진행
 * 복도에 장애물이 위치한 경우, 선생님은 장애물 뒤편에 숨어 있는 학생들은 볼 수 없다. 
 * 장애물로 막히기 전까지의 학생들은 모두 볼 수 있다.
 * 3개의 장애물을 설치
 */
public class Main_18428_감시피하기 {

	static int N;
	static String answer = "NO";
	static char[][] hall;
	static ArrayList<int[]> teacher = new ArrayList<int[]>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hall = new char[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				hall[i][j] = st.nextToken().charAt(0);
				if(hall[i][j]=='T') teacher.add(new int[] {i,j});   // 선생님 목록 
			}
		}
		
		run(0,0);
		System.out.println(answer);
	}
	
	private static void run(int cnt, int start) {
		if(cnt==3) {	// 장애물 3개 다 세우면
			boolean canHide = true;	 // 학생들 숨었다
			for (int i = 0; i < teacher.size(); i++) {		// 학생찾기
				if(check(teacher.get(i))) canHide = false;  // 선생님이 학생찾으면 숨기 실패
			}
			if(canHide) answer="YES";
			return;
		}
		
		// 장애물
		for (int i = start; i < N*N; i++) {
			int r = i/N; // 행
			int c = i%N; // 열
			if(hall[r][c]=='X') {
				hall[r][c]='O';   // 장애물 세우기
				run(cnt+1, start+1);
				hall[r][c]='X';   // 원래대로 돌려놓기
			}
		}
	}

	private static boolean check(int[] teacher) {
		boolean findStudent = false;
		for (int d = 0; d < 4; d++) { // 선생님 사방탐색
			if(find(d, teacher)) {
				findStudent = true;
			}
		}
		return findStudent;
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	private static boolean find(int d, int[] teacher) {
		int r = teacher[0];
		int c = teacher[1];
		while(true) {
			r += dr[d];
			c += dc[d];
			if(r<0 || r>=N || c<0 || c>=N) return false; // 복도 끝까지 가면 학생 못 찾음
			if(hall[r][c] == 'O') return false; // 장애물 보면 학생 못 찾음
			if(hall[r][c] == 'S') return true;  // 학생 발견
		}
	}

	

}
