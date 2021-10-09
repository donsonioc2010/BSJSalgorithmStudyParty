package week4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class munje3Dfs {
    /*
    https://www.acmicpc.net/problem/2667'
    입력 :
        첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

    출력 :
        첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

    예제 :
        입력 :
            7
            0110100
            0110101
            1110101
            0000111
            0100000
            0111110
            0111000

        출력 :
            3
            7
            8
            9

7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
    */
    private static int[] searchX = {0, 0, 1, -1};
    private static int[] searchY = {1, -1 , 0, 0};
    private static int[] houseAreaAry = new int[25 * 25];//집 크기들

    final static int MIN_LENGTH = 5;    // 최소치
    final static int MAX_LENGTH = 25;   // 최대치

    static int mapLength;               // 맵 크기
    static int totalHouseCnt = 0;       // 집의 총 갯수

    static int[][] mapAry;             // 지도
    static boolean[][] visited;         // 방문 이력
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        mapLength = sc.nextInt();

        /* Validation */
        if(mapLength < MIN_LENGTH || mapLength > MAX_LENGTH) {
            return;
        }

        /* Map Init And BufferedReader Close*/
        makeMap();
        doRun();
        resultPrint();
    }

    /*
    가로 +1 -1, 세로 + 1 -1,
    */
    private static void doRun() {
        for(int i = 0; i < mapLength; i++) { // == x
            for(int j = 0; j < mapLength; j++) { // == y
                // [i][j]에 집이있고 방문을 안했을 때
                if(mapAry[i][j] != 0 && !visited[i][j]) {
                    areaSearchDfs(i, j);
                    totalHouseCnt++;
                }
            }
        }
    }

    /* 영역 조사 dfs */
    private static void areaSearchDfs(int x, int y) {
        visited[x][y] = true;
        houseAreaAry[totalHouseCnt]++;
       for(int i = 0; i < 4; i++) {
           int sxNum = x + searchX[i];
           int syNum = y + searchY[i];

           if(sxNum >= 0 && syNum >= 0 && sxNum < mapLength && syNum < mapLength) {
               if(mapAry[sxNum][syNum] != 0 && !visited[sxNum][syNum]){
                   areaSearchDfs(sxNum, syNum);
               }
           }
       }

    }

    private static void makeMap() {
        initMap();
        for(int i = 0; i < mapLength; i++) {
            String line = sc.next();
            for (int j = 0; j < mapLength; j++) {
                mapAry[i][j] = line.charAt(j) - '0';
            }
        }
    }

    private static void initMap() {
        mapAry = new int[mapLength][mapLength];
        visited = new boolean[mapLength][mapLength];
        for(int i = 0; i < mapLength; i++) {
            Arrays.fill(mapAry[i], 0);
            Arrays.fill(visited[i], false);
        }
    }

    private static void resultPrint() {
        System.out.println(totalHouseCnt);
        Arrays.sort(houseAreaAry);
        for(int i = 0; i < houseAreaAry.length; i++) {
            if(houseAreaAry[i] != 0)
                System.out.println(houseAreaAry[i]);
        }
    }
}
