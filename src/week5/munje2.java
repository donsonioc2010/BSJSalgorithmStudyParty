package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class munje2 {
    /*
    https://www.acmicpc.net/problem/2206
6 4
0100
1110
1000
0000
0111
0000

    */

    static int N; // 세로
    static int M; // 가로
    static int[][] map;
    static boolean[][][] visited; //  벽을 부셨을때와 안부셨을 때의 비교

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static class gps {
        int y;
        int x;
        int rootCnt;
        int drillCnt;

        public gps(int y, int x, int rootCnt, int drillCnt) {
            this.x = x;
            this.y = y;
            this.rootCnt = rootCnt;
            this.drillCnt = drillCnt;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        visited = new boolean[2][N][M];
        map     = new int[N][M];

        for(int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        int rootResult = bfs(0, 0);
        System.out.println(rootResult);
    }

    public static int bfs(int y, int x) {
        Queue<gps> que = new LinkedList<>();
        que.add(new gps(y, x, 1, 0));
        visited[0][y][x] = true;
        visited[1][y][x] = true;

        while(!que.isEmpty()) {
            gps g = que.poll();

            if(g.y == N - 1 && g.x == M -1) {
                return g.rootCnt;
            }
            for(int i = 0; i < 4; i++) {
                int ny = g.y + dy[i];
                int nx = g.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                } else {
                    if(map[ny][nx] == 0) {
                        if(!visited[g.drillCnt][ny][nx]) {
                            que.add(new gps(ny, nx, g.rootCnt+1, g.drillCnt));
                            visited[g.drillCnt][ny][nx] = true;
                        }
                    }
                    if(map[ny][nx] == 1) {
                        if(g.drillCnt == 0 && !visited[1][ny][nx]) {
                            que.add(new gps(ny, nx, g.rootCnt+1, g.drillCnt+1));
                            visited[1][ny][nx] = true;
                        }
                    }
                }


            }
        }
        return -1;
    }
}
