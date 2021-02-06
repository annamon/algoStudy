package annapro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class stackqueue_기능개발 {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		Queue<Double> work = new LinkedList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < progresses.length; i++) {
			double n = (double) (100 - progresses[i]) / (double) speeds[i];
			work.offer(Math.ceil(n));
		}
		double count = work.peek();
		int finish = 0;
		while (!work.isEmpty()){
			if (work.peek() <= count) {
				work.poll();
				finish++;
			} else {
				answer.add(finish);
				finish = 0;
				count = work.peek();
			}
		}
		answer.add(finish);
		System.out.println(answer);
	}
}