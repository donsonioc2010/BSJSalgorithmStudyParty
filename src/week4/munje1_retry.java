package week4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class munje1_retry {
/*
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
        int[][] mapAry;     // LinkedList대신 사용할 배열
        Scanner sc = new Scanner(System.in);

        /* N, M, V INPUT*/
        nodeNum = sc.nextInt();
        m       = sc.nextInt();
        v       = sc.nextInt();


        /* Validation */
        if(nodeNum < 1 || nodeNum > 1000 || m < 1 || m > 10000) {
            return;
        }

        /* DFS Class, BFS Class 둘다 사용하기 위한 LinkedList 생성 */
        mapAry = new int[nodeNum + 1][nodeNum + 1]; // 증가시키는건 딱 그숫자에 맞춰서 사용을 하기 위함

        /* 배열 초기화 */
        for(int i = 0; i <= nodeNum; i++) {
            Arrays.fill(mapAry[i], 0);
        }

        /* DFS, BFS 에 사용될 맵제작 */
        for(int i=1; i <= m; i++){
            int to      = sc.nextInt();
            int from    = sc.nextInt();
            mapAry[to][from] = mapAry[from][to] = 1;
        }


        // DFS실행
        new dfs_retry(nodeNum, v, mapAry);

        // BFS실행
        new bfs_retry(nodeNum, v, mapAry);
    }

}

/* 깊이 완전 탐색 */
class dfs_retry {
    private int[] visited;              // 방문시에 해당방에 값을 늘리는방식
    private int nodeNum;
    private StringBuilder sb = new StringBuilder();


    /* DFS실행 */
    public dfs_retry(int nodeNum, int stNum, int[][] mapAry) {  // 배열크기, 시작번호, main에서 제작된 리스트
        visited = new int[nodeNum + 1]; // 해당 노드를 방문했었는지 안했었는지를 판별하기 위함.
        Arrays.fill(visited, 0);

        this.nodeNum = nodeNum;

        dfsDoRun(stNum, mapAry);
        System.out.println(sb.toString());
    }

    /* 탐색 실행 */
    private void dfsDoRun(int num, int[][] mapAry) {
        visited[num] += 1; // 값을 증가해서 방문구분
        dfsPrintStack(num);

        // 시작번호 => 맵이 존재하고 방문안했다면 해당번호로 재귀
        for(int i = 0 ; i <= nodeNum; i++) {
            if(mapAry[num][i] == 1 && visited[i] == 0) {
                dfsDoRun(i, mapAry);
            }
        }
    }

    /* 출력을 진행할 스택을 쌓음 */
    private void dfsPrintStack(int printNum) {
        sb.append(printNum+" ");
        //System.out.println(printNum + " ");
    }
}

/* 너비 우선 탐색 */
class bfs_retry {
    private int[] visited;
    private int nodeNum;

    private StringBuilder sb = new StringBuilder();


    public bfs_retry(int nodeNum, int stNum, int[][] mapAry) {
        visited = new int[nodeNum+1];

        this.nodeNum = nodeNum;

        bfsDoRun(stNum, mapAry);
        System.out.println(sb.toString());
    }

    /* bfs실행 */
    private void bfsDoRun(int num, int[][] mapAry) {
        // bfs 리스트제작할 방
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(num);

        while(list.size() > 0) {
            //list에 방문이 안되면 계속 list가 추가되면서 추가된 리스트를 바로 당겨오고 프린트스택에 넣음.
            num = list.poll();
            visited[num] += 1;      //방문 체크
            bfsPrintStack(num);

            for(int i = 0; i <= nodeNum; i++) {
                if(mapAry[num][i] == 1 && visited[i] == 0 ) {
                    visited[i] += 1;
                    list.add(i);
                }
            }
        }
    }

    /* 출력을 진행할 스택을 쌓음 */
    private void bfsPrintStack(int printNum) {
        sb.append(printNum+" ");
        //System.out.println(printNum + " ");
    }
}