package week5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class munje3 {
/*
https://www.acmicpc.net/problem/1707

문제 :
    그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프라 부른다.
    그래프가 입력으로 주여졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

입력 :
    입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다.
    각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다.
    각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호
    u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다.

출력 :
    K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.

    2 ≤ K ≤ 5
    1 ≤ V ≤ 20,000
    1 ≤ E ≤ 200,000

예제 입력 1 :
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2

예제 출력 1 :
YES
NO

*/
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> node;
    static int[] nodeColor;
    static final int RED = 1, GREEN = -1;
    static final String YES = "YES", NO = "NO";

    public static void main(String[] args) {
        int K = sc.nextInt();           // TestCase 횟수

        for(int i = 0; i < K; i++) {
            int V = sc.nextInt();       // 정점의 갯수       (방을 만들어야 하는 갯수)
            int E = sc.nextInt();       // Node(간선)의 갯수 (반복문 돌아야 하는 횟수)
            boolean ans = true;

            initArrayList(V);
            for(int j = 0; j < E; j++) {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                addNode(from, to);
            }
            nodeColor = new int[V];
            for(int j = 0; j< V; j++) {
                if(nodeColor[j] == 0) {
                    if(!bfs(j)) {
                        ans = false;
                        break;
                    }
                }
            }
            if(ans) {
                System.out.println(YES);
                continue;
            }
            System.out.println(NO);
        }

    }

    private static boolean bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        nodeColor[n] = RED;

        while(!q.isEmpty()) {
            int nodeNum = q.poll();

            for(Integer i : node.get(nodeNum)) {
                if(nodeColor[i] == nodeColor[nodeNum]) {
                    //인접한 곳의 색상이 같은경우
                    return false;
                }
                //서로 다른 색상을 줌
                if(nodeColor[i] == 0) {
                    // 방문을 하지 않은 경우 이건신박하다..
                    if(nodeColor[nodeNum] == RED) {
                        nodeColor[i] = GREEN;
                    } else {
                        nodeColor[i] = RED;
                    }
                    q.add(i);
                }
            }

        }
        return true;
    }

    private static void initArrayList(int V) {
        node = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++) {
            node.add(new ArrayList<>());
        }
    }

    private static void addNode(int from, int to) {
        node.get(from).add(to);
        node.get(to).add(from);
    }
}