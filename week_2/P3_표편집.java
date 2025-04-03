package week_2;

import java.util.*;

public class P3_표편집 {

    public String solution(int n, int k, String[] cmd) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Stack<Integer> stack3 = new Stack<>();
        n -= 1;
        for (int i = 0; i <= k; i++) stack1.push(i);
        for (int i = n; i > k; i--) stack2.push(i);

        for (String command : cmd) {
            String[] opers = command.split(" ");
            String oper = opers[0];
            if (opers.length > 1) {
                int mv = Integer.parseInt(opers[1]);

                if (oper.equals("U")) {
                    while (mv != 0) {
                        stack2.push(stack1.pop());
                        mv--;
                    }
                } else {
                    while (mv != 0) {
                        stack1.push(stack2.pop());
                        mv--;
                    }
                }
            } else {
                if (oper.equals("C")) {
                    stack3.push(stack1.pop());

                    if (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                } else {
                    int idx = stack3.pop();

                    if (!stack1.isEmpty() && idx < stack1.peek()) {
                        int cnt = 0;
                        while (!stack1.isEmpty() && stack1.peek() > idx) {
                            cnt++;
                            stack2.push(stack1.pop());
                        }

                        stack1.push(idx);
                        while (cnt != 0) {
                            cnt--;
                            stack1.push(stack2.pop());
                        }
                    } else {
                        int cnt = 0;
                        while (!stack2.isEmpty() && stack2.peek() < idx) {
                            cnt++;
                            stack1.push(stack2.pop());
                        }

                        stack2.push(idx);
                        while (cnt != 0) {
                            cnt--;
                            stack2.push(stack1.pop());
                        }
                    }
                }
            }
        }

        int[] result = new int[n + 1];
        while (!stack3.isEmpty()) {
            result[stack3.pop()] = 1;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n + 1; i++) {
            if (result[i] == 0) {
                answer.append("O");
            } else {
                answer.append("X");
            }
        }

        return answer.toString();
    }
}
