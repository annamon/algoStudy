import java.util.Scanner;

/**
 * 2021.06.06
 * 128MB/1초
 * 
 * 성냥개비를 모두 사용해서 만들 수 있는 가장 작은 수와 큰 수
 * n개  (2 ≤ n ≤ 100)
 * 0~9 : 6 2(1) 5 5 4 5 6 3(7) 7 6
 * n=2 > 1 1
 * n=3 > 7 7
 * n=4 > 4 4
 * n=5 > 2 71
 * n=6 > 6 111
 * n=7 > 8 711
 * n=8 > 10 1111
 * n=9 > 18 7111
 * n=10 > 22 11111
 * 
 * 최대
 * n : 홀수 > 7 + (n-3)/2 개의 1
 * n : 짝수 > n/2 개의 1
 * 
 * 최소는 어케함? ㅠ
 */
public class Main_3687_성냥개비 {

	static int T, N;
	static String min, max;
	static int[] number = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			System.out.println(min + " " + max);
		}
	}

}
