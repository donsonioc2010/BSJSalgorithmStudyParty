package Doit_Algorithm_Java.Chapter02;
/*
두잇 알고리즘 구간합 구하기

1초
입력
5 3
5 4 3 2 1
1 3
2 4
5 5

출력
12
9
1

제한
1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    long[] sumAry = new long[N + 1];

    stringTokenizer = new StringTokenizer(bufferReader.readLine());
    //구간합 배열 생성
    for (int i = 1; i <= N; i++) {
      sumAry[i] = sumAry[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
    }

    for (int i = 0; i < M; i++) {
      // 구간합 범위
      stringTokenizer = new StringTokenizer(bufferReader.readLine());
      int A = Integer.parseInt(stringTokenizer.nextToken());
      int B = Integer.parseInt(stringTokenizer.nextToken());
      System.out.println(sumAry[B] - sumAry[A - 1]);
    }
  }
}
