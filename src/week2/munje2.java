package week2;

import java.util.Arrays;
import java.util.Scanner;

public class munje2 {
    /*
    끝! 이게되네 ㅋㅋㅋㅋ
    색종이
        링크 :
            https://www.acmicpc.net/problem/2563
        문제 :
            가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
            이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
            이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.

                (이미지) (백준참고)
            예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.
        입력 :
            첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
            색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다.
            색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
        출력 :
            첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.

        예제 :
            입력 1:
                3
                3 7
                15 7
                5 2
            출력 1:
                260
    */
    private static int squareWidth = 10;    // 사각형 한변길이
    private static int squreArea = 100;     // 사각형 넓이

    public munje2() {
        solution();
    }

    public void solution(){
        Scanner sc = new Scanner(System.in);

        int count = 0;

        boolean[][] area = new boolean[squreArea][squreArea]; //앞x 뒤y

        for(int i = 0; i <squareWidth; i++){
            Arrays.fill(area[i],false);
        }

        int colorPaperNum = sc.nextInt();

        if(colorPaperNum <= 100){       //100개 이하 validation
            for(int i = 0; i < colorPaperNum; i++){
                int num1 = sc.nextInt(); // 종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
                int num2 = sc.nextInt(); // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리

                for(int x = num1; x < num1 + squareWidth; x++){
                    for(int y = num2; y < num2+squareWidth; y++){
                        if(!area[x][y]){
                            area[x][y] = true;
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }
}