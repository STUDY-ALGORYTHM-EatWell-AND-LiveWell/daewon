package week_1;

// 접근: 시간 복잡도를 고려해서 commands 안에서 array를 순회
// 시간복잡도: O(100 * 50)
// 풀이: 반복문 or ArraysCopyRange() 활용


import java.util.Arrays;

public class P1_K번째수 {

    public int[] solution1(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int[] info = commands[i];
            int start = info[0] - 1;
            int end = info[1] - 1;
            int targetIndex = info[2] - 1;

            int[] cutArr = new int[end - start + 1];
            for (int j = 0; j < cutArr.length; j++) cutArr[j] = array[start++];
            Arrays.sort(cutArr);
            answer[i] = cutArr[targetIndex];
        }

        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int[] info = commands[i];
            int start = info[0] - 1;
            int end = info[1] - 1;
            int targetIndex = info[2] - 1;

            int[] copyArr = Arrays.copyOfRange(array, start, end + 1);
            Arrays.sort(copyArr);
            answer[i] = copyArr[targetIndex];
        }

        return answer;
    }

}
