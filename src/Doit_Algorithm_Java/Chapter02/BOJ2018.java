package Doit_Algorithm_Java.Chapter02;

import java.util.Scanner;

/*
어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.

예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.

N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

입력
15
출력
4

시간 2초

약 2억번의 연산안에 끝내야 O(N)을 활용해야 한다.

투포인터 문제...!
 */
public class BOJ2018 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int startIndex = 1, endIndex = 1, sum = 1, answer = 1;

    while (endIndex != N) {
      if (sum == N) {
        answer++;
        endIndex++;
        sum += endIndex;
      } else if (sum > N) {
        sum -= startIndex;
        startIndex++;
      } else {
        endIndex++;
        sum += endIndex;
      }
    }

    System.out.println(answer);
  }
}
