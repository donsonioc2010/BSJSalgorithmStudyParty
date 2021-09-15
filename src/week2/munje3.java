package week2;

public class munje3 {


    /*
    체스
        링크 :
            없슴 (알고리즘랩스....)
        문제 :
            체스에서 룩이라는 기물은 막혀있지만 않으면 룩의 위치에서 같은 행, 같은 열에 해당하는 칸 중 하나로 한 번 이동할 수 있다.
            단, 특정 칸이 막혀있다면 그 칸에서 더 나아갈 수는 없다.
            만약 룩이 아래 그림과 같이 5행 4열에 존재하고 같은 행열에 기물이 없다면 5행이나 4열에 존재하는 칸 중 어디로든 갈 수 있다.
            예를 들어, 5행 2열 혹은 1행 4열로 움직일 수 있다.
            차례에 주어진 이동 횟수는 한 번 이므로 이동이 완료되었다면 상대방의 차례로 넘어간다
                                    (이미지)
            체스는 킹만 잡히면 지게 되는 게임이다. 그 중에서도 알랩이는 룩으로 인해 게임을 지는 것을 극도로 싫어한다!
            주어진 체스판의 상태에서 현재 차례가 상대의 차례일 때, 이번 차례에 알랩이의 킹이 상대방의 룩에게 잡힐 가능성이 있는지 알아보자.
        입력 :
            8줄에 걸쳐 8x8 체스판의 상태가 주어진다.
            이때 0은 기물이 없는 상태이고, 1은 알랩이의 킹을 의미하고, 2는 상대의 룩을 의미하며 3은 그 외 다른 기물들을 의미한다.
            (킹은 하나만 존재하며, 상대의 룩은 최대 2개까지 있을 수 있다. 그 외 기물들은 최대 29개까지 있을 수 있다.)
        출력 :
            킹이 룩에게 잡힐 가능성이 있으면 1, 아니면 0을 출력한다.

        예제 :
            입력 1 :
                0 3 0 0 0 0 0 0
                3 1 0 0 0 0 2 0
                0 3 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
            출력 1:
                1

            입력 2 :
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 3 3 0 0 0 0 0
                3 0 1 0 3 0 2 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
            출력 2 :
                0
    */
    private static int chessWidth = 8;
    int [][] chessPan; //앞 x 뒤 y

    public munje3() {
        solution();
    }

    private void solution() {
        init(true);  //1번 문제
        //init(false);   //2번 문제
        //2가 1을 잡으면됨 중간에 3이있으면 아웃 재귀사용하기
        for(int i = 0; i < chessWidth; i++){
            for(int j = 0; j < chessWidth; j++){
                //체스판만큼 리롤 시작
                if(chessPan[i][j] == 2){
                    boolean case1 = sero(i, j, "+");    //세로 증가
                    boolean case2 = sero(i, j, "-");    //세로 가로
                    boolean case3 = garo(i, j, "+");    //가로 증가
                    boolean case4 = garo(i, j, "-");    //가로감소

                    if(case1 || case2 || case3 || case4){
                        System.out.println("1"); //따먹힘
                        return;
                    }
                }
            }
        }
        System.out.println("0"); //안따먹힘
    }
    private boolean sero(int num1, int num2, String mark){
        //x값 증가
        if(num1 >= 8 || num1 < 0 ) {
            return false;
        }else if(chessPan[num1][num2] == 1) {
            return true;
        }else {
            if ("+".equals(mark)) {
                return sero(++num1, num2, mark);
            }else {
                return sero(--num1, num2, mark);
            }
        }
    }
    private boolean garo(int num1, int num2, String mark){
        //x값 증가
        if(num2 >= 8 || num2 < 0 || chessPan[num1][num2]==3) { //여기서 outOfMemory뜰수도 ㅎㅎ;;
            return false;
        }else if(chessPan[num1][num2] == 1) {
            return true;
        }else {
            if ("+".equals(mark)) {
                return garo(num1, ++num2, mark);
            }else {
                return garo(num1, --num2, mark);
            }
        }
    }

    private void init(boolean sel){
        System.out.println("sel : " + sel);
        if(sel){// 1번 문제
            chessPan = new int[][]{
                    {0, 3, 0, 0, 0, 0, 0, 0},
                    {3, 1, 0, 0, 0, 0, 2, 0},
                    {0, 3, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
        }else{ //2번문제
            chessPan = new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 3, 3, 0, 0, 0, 0, 0},
                    {3, 0, 1, 0, 3, 0, 2, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
        }
    }
}
