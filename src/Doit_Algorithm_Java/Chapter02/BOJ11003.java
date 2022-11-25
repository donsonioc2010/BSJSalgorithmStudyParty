package Doit_Algorithm_Java.Chapter02;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
12 3
1 5 2 3 6 2 3 7 3 5 2 6
 */
public class BOJ11003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    Deque<Node> windowList = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());

      //Deque마지막 Node Value와 새로운 값의 최솟값 비교 및 이전 노드Value가 큰 경우 삭제
      while (!windowList.isEmpty() && windowList.getLast().value > now) {
        windowList.removeLast();
      }
      //Deque에 Node추가
      windowList.addLast(new Node(now, i));

      //Deque의 첫번째 노드가 i - L + 1 을 벗어났는지 확인 및 인덱스를 벗어난 경우 삭제
      if (windowList.getFirst().index <= i - L) {
        windowList.removeFirst();
      }
      bw.write(windowList.getFirst().value + " ");
    }
    bw.flush();
    bw.close();
  }

  static class Node {

    public int value;
    public int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
