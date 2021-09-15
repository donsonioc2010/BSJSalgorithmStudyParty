package week1;

import java.util.Arrays;

public class munje2 {
     /*
        https://www.acmicpc.net/problem/2476
        21. 09. 10
        2번 문제 :
            1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.

                1. 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
                2. 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
                3. 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.

            예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다.
            또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다.
            3개의 눈이 6, 2, 5로 주어지면 그 중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.

            N(2 ≤ N ≤ 1,000)명이 주사위 게임에 참여하였을 때, 가장 많은 상금을 받은 사람의 상금을 출력하는 프로그램을 작성하시오.


        입력 :
            첫째 줄에는 참여하는 사람 수 N이 주어지고 그 다음 줄부터 N개의 줄에 사람들이 주사위를 던진 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.

        출력 :
            첫째 줄에 가장 많은 상금을 받은 사람의 상금을 출력한다.

        입력 예제 1 :
            3
            3 3 6
            2 2 2
            6 2 5

        출력 예제 1 :
            12000
     */

    private int playerNum = 0;
    private int diceTotalNum = 3; //주사위는 3번
    private int bestValuePrice = 16000;
    private int[][] playerDiceAry;

    public munje2() {
        setPlayerNum(this.getPlayerRandomNum());                                            //플레이어 인원수 확보

        this.playerDiceAry = new int[this.getPlayerNum()][this.getDiceTotalNum()];          //주사위 배열 선언
        this.setPlayerDice();                                                               //주사위 init

        this.solution(playerNum, playerDiceAry);
    }

    public void solution(int playerNum, int[][] diceAry){
        int bestPrice = 0;
        if(playerNum == diceAry.length){        //validation
            for(int i = 0; i<playerNum; i++){
                int thisPlayerPrice;          //이 플레이어의 상금
                int sameNum;

                int num1 = diceAry[i][0];   //i 플레이어의 1번 주사위
                int num2 = diceAry[i][1];   //i 플레이어의 2번 주사위
                int num3 = diceAry[i][2];   //i 플레이어의 3번 주사위
                if((num1 == num2) && (num1 == num3)){
                    thisPlayerPrice = 10000 + (num1 * 1000);
                    sameNum = 2;
                }else if((num1 == num2) || (num1 == num3)){
                    thisPlayerPrice = 1000 + (num1 * 100);
                    sameNum = 1;
                }else if(num2 == num3){
                    thisPlayerPrice = 1000 + (num2 * 100);
                    sameNum = 1;
                }else{
                    int maxValue = Math.max(num1, num2);
                    maxValue = Math.max(maxValue, num3); //1,2,3 전부대조함
                    thisPlayerPrice = maxValue * 100;
                    sameNum= 0;
                }

                bestPrice = Math.max(bestPrice, thisPlayerPrice);

                System.out.println((i+1)+"번째 플레이어 : "+Arrays.toString(diceAry[i])+", 같은 눈 갯수 : "+sameNum + ", 상금 : "+thisPlayerPrice);
                if(bestValuePrice == bestPrice){
                    System.out.println("최고값 "+bestPrice+"의 등장으로 게임은 종료되었습니다");
                    System.out.println("End Player Num : " + i+", 총 플레이어 수 : "+playerNum);
                    return;
                }
            }
            System.out.println("최고값 : " + bestPrice+", 총 플레이어 수 : "+playerNum);
        }
    }

    //Get Player Num 2~1000
    private int getPlayerRandomNum(){
        return (int)(Math.random()*999)+2;
    }

    //플레이어의 다이스 배열 설정
    private void setPlayerDice(){
        if((playerNum >= 2 && playerNum <= 1000)&& playerDiceAry!=null)     //만약을 위한 validation
            for(int i = 0; i < playerDiceAry.length; i++)                   //playerNum반복문
                for(int j = 0; j< playerDiceAry[i].length; j++)             //주사위 반복문
                    setDiceAryValue(i, j, getDiceRandomNum());              //배열에 주사위값들 세팅
    }

    //주사위 값 세팅해주는 메소드
    private void setDiceAryValue(int playerNum, int diceIdx, int diceValue){
        this.playerDiceAry[playerNum][diceIdx] = diceValue;
    }

    private int getDiceRandomNum(){
        return (int)(Math.random()*6)+1; //1~6
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public int getDiceTotalNum() {
        return diceTotalNum;
    }

    public void setDiceTotalNum(int diceTotalNum) {
        this.diceTotalNum = diceTotalNum;
    }
}
