package Doit_Algorithm_Java.Chapter02;

import java.util.Scanner;

/*
https://justicehui.github.io/ps/2019/04/04/BOJ10986/

모듈러 연산이라는데... 이해 잘 안되긴 하다...ㅎ;;;;
구간합
Input
5 3
1 2 3 1 2

OutPut
7
첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)

둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)

 */
public class BOJ10986 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    long[] S = new long[N];
    long[] C = new long[M];
    long answer = 0;

    //합 배열 제작
    S[0] = sc.nextInt();
    for (int i = 1; i < N; i++) {
      S[i] = S[i - 1] + sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      int remainder = (int) (S[i] % M);
      if (remainder == 0) {
        answer++;
      }
      C[remainder]++;
    }

    for (int i = 0; i < M; i++) {
      if (C[i] > 1) {
        answer = answer + (C[i] * (C[i] - 1) / 2);
      }
    }
    System.out.println(answer);
  }
}
