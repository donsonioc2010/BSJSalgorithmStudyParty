package Doit_Algorithm_Java.Chapter02;

/*
정렬, 투포인터 문제
N 세제곱이 되지 않도록 해야함.

첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

10
1 2 3 4 5 6 7 8 9 10

8
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] A = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      A[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(A);
    int count = 0;
    for (int i = 0; i < N; i++) {
      long findNum = A[i];
      int start = 0;
      int end = N - 1;

      while (true) {
        if (start == i) {
          start++;
        } else if (end == i) {
          end--;
        }

        if (start == end) {
          break;
        }
        long sum = A[start] + A[end];
        if (sum > findNum) {
          end--;
        } else if (sum < findNum) {
          start++;
        } else {
          count++;
          break;
        }
      }
    }
    System.out.println(count);
    br.close();
  }
}
