package Doit_Algorithm_Java.Chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
 */
public class BOJ11660 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken()),    // 표 Line tn
        M = Integer.parseInt(stringTokenizer.nextToken());    // 답을 구해야 하는 횟수

    int[][] S = new int[N + 1][N + 1];
    int[][] A = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        S[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    //구간합 배열 생성
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        A[i][j] = A[i][j - 1] + A[i - 1][j] - A[i - 1][j - 1] + S[i][j];
      }
    }

    for (int i = 0; i < M; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(stringTokenizer.nextToken());
      int y1 = Integer.parseInt(stringTokenizer.nextToken());
      int x2 = Integer.parseInt(stringTokenizer.nextToken());
      int y2 = Integer.parseInt(stringTokenizer.nextToken());
      int result = A[x2][y2] - A[x1 - 1][y2] - A[x2][y1 - 1] + A[x1 - 1][y1 - 1];

      System.out.println(result);
    }
  }
}
