package Doit_Algorithm_Java.Chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

투포인터 문제

첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다. 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다.
그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유한 번호는 100,000보다 작거나 같은 자연수이다.

6
9
2 7 4 1 5 3
 */
public class BOJ1940 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);
    int count = 0;

    // 1번 솔루션

    int i = 0;
    int j = N - 1;
    while (i < j) {
      if (A[i] + A[j] < M) {
        i++;
      } else if (A[i] + A[j] > M) {
        j--;
      } else {
        i++;
        j--;
        count++;
      }
    }

    //2번
/*    for (int i = 0; i < N; i++) {
      int end = i + 1;
      while (end < N) {
        if (A[i] + A[end++] == M) {
          count++;
          break;
        }
      }
    }*/

    System.out.println(count);
    br.close();
  }

}
