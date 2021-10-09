package week4;

import java.util.Arrays;
import java.util.Scanner;

public class munje2 {
    /*
     https://www.acmicpc.net/problem/2606

    입력 :
        첫째 줄에는 컴퓨터의 수가 주어진다.
        컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
        둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

     출력 :
        1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

     예제 :
        입력 :
            7
            6
            1 2
            2 3
            1 5
            5 2
            5 6
            4 7

        출력 :
            4
     */
    final static int START_PC = 1;
    static int pcNum;
    static int pcLine;
    static boolean[] visited;
    static boolean[][] mapAry;
    static int virusPc = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        pcNum = sc.nextInt();  // 100 이하
        pcLine = sc.nextInt(); // Node 갯수 인풋

        /* Validation */
        if(pcNum > 100 || pcNum < 1) {
            return;
        }

        /* 배열 선언 */
        initAry();

        /* 맵 제작 */
        for(int i = 0 ; i < pcLine; i++) {
            int to      = sc.nextInt();
            int from    = sc.nextInt();
            setLine(to, from);
        }

        dfs(START_PC);
        System.out.println(virusPc-1);
    }

    /* 배열 선언 및 초기화 */
    private static void initAry() {
        visited = new boolean[pcNum + 1];
        mapAry = new boolean[pcNum+1][pcNum+1];

        for(int i = 0; i <= pcNum; i++) {
            Arrays.fill(mapAry[i], false);
        }
    }

    /* 맵 제작 */
    private static void setLine(int to, int from) {
        mapAry[to][from] = mapAry[from][to] = true;
    }

    private static void dfs(int num) {
        visited[num] = true;
        virusPc++;
        for(int i = 0; i <= pcNum; i++) {
            if(!visited[i] && mapAry[num][i]) { //mapAry[num][i] == true : 길이 있슴
                dfs(i);
            }
        }
    }
}
