package week_2;

import java.util.*;

public class P2_프로세스 {

    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            pq.offer(priority);
            queue.offer(new int[] {i, priority});
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[1] == pq.peek()) {
                answer++;
                pq.poll();

                if (now[0] == location) break;
            } else {
                queue.offer(now);
            }
        }

        return answer;
    }
}
