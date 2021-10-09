package week4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class munje1 {
/*
    고마워요 스피드웨건!
    DFS : https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html
    BFS : https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html

    백준 1260

    문제 :
        그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
        단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

    입력 :
        첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
        다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

    출력 :
        첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

    예제 :
        입력1 :
            4 5 1
            1 2
            1 3
            1 4
            2 4
            3 4

        출력1 :
            1 2 4 3
            1 2 3 4

        입력 2 :
            5 5 3
            5 4
            5 2
            1 2
            3 4
            3 1

        출력 2 :
            3 1 2 5 4
            3 1 4 2 5

        입력 3:
            1000 1 1000
            999 1000
        출력 3:
            1000 999
            1000 999
     */

    public static void main(String[] args) {
        /* [선언부] */
        int nodeNum;        // N
        int m;              // M
        int v;              // V
        LinkedList<Integer> nodeLine[];
        Scanner sc = new Scanner(System.in);

        /* N, M, V INPUT*/
        nodeNum = sc.nextInt();
        m       = sc.nextInt();
        v       = sc.nextInt();


        /* Validation */
        if((nodeNum < 1 && nodeNum > 1000) && (m < 1 && m > 10000)) {
            return;
        }

        /* DFS Class, BFS Class 둘다 사용하기 위한 LinkedList 생성 */
        nodeLine = new LinkedList[nodeNum + 1]; // 증가를 시키는 이유는 해당숫자 그대로 넣기 위함.
        for(int i=1; i<=nodeNum; i++){          // 인접리스트를 초기화 하기 위함
            nodeLine[i] = new LinkedList();
        }


        /* DFS, BFS 에 사용될 노드 제작 to~from 노드를 연결 간선의 갯수만큼 for문을 받으면 됨 */
        for(int i  = 0; i < m; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            nodeLine[to].add(from);
        }

        // DFS실행
        new dfs(nodeNum, v, nodeLine);

        // BFS실행
        new bfs(nodeNum, v, nodeLine);
    }

}

/* 깊이 완전 탐색 */
class dfs {
    private int[] visited;              // 방문시에 해당방에 값을 늘리는방식
    private LinkedList<Integer> nodeLine[];
    private StringBuilder sb = new StringBuilder();

    /* DFS실행 */
    public dfs(int nodeNum, int stNum, LinkedList<Integer> nodeList[]) {  // 배열크기, 시작번호, main에서 제작된 리스트
        visited = new int[nodeNum + 1]; // 해당 노드를 방문했었는지 안했었는지를 판별하기 위함.
        this.nodeLine = nodeList;

        dfsDoRun(stNum);
        System.out.println(sb.toString());
    }

    /* 탐색 실행 */
    private void dfsDoRun(int num) {
        visited[num] += 1; // 값을 증가해서 방문구분
        dfsPrintStack(num);

        Iterator<Integer> node = nodeLine[num].listIterator();
        //들어온방에서 Node 시작
        while(node.hasNext()) {
            int next = node.next();

            //node에서 다음 노드가 방문이 안된 노드면 재귀로 방문후 리턴받음.
            if(visited[next] == 0) {
                dfsDoRun(next);
            }
        }
    }

    /* 출력을 진행할 스택을 쌓음 */
    private void dfsPrintStack(int printNum) {
        sb.append(printNum+" ");
    }
}

/* 너비 우선 탐색 */
class bfs {
    private int[] visited;
    private LinkedList<Integer> nodeLine[];
    private StringBuilder sb = new StringBuilder();


    public bfs(int nodeNum, int stNum, LinkedList<Integer> nodeLine[]) {
        visited = new int[nodeNum+1];
        this.nodeLine = nodeLine;

        bfsDoRun(stNum);
        System.out.println(sb.toString());
    }

    /* bfs실행 */
    private void bfsDoRun(int num) {
        // bfs 리스트제작할 방
        LinkedList<Integer> list = new LinkedList<Integer>();

        visited[num] += 1;
        list.add(num);

        while(list.size() > 0) {
            //list에 방문이 안되면 계속 list가 추가되면서 추가된 리스트를 바로 당겨오고 프린트스택에 넣음.
            num = list.poll();
            bfsPrintStack(num);

            Iterator<Integer> node = nodeLine[num].listIterator();
            while(node.hasNext()) {
                int next = node.next();

                if(visited[next] == 0) {
                    visited[next] += 1;
                    list.add(next);
                }
            }
        }


    }

    /* 출력을 진행할 스택을 쌓음 */
    private void bfsPrintStack(int printNum) {
        sb.append(printNum+" ");
    }
}