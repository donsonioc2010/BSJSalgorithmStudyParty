package week1;

import java.util.Arrays;

public class munje1 {
     /*
        21. 09. 10
        1번 :
        두 사람 A 와 B는 1부터 10까지의 숫자가 하나씩 적힌 열 장의 카드로 '게임'을 한다.
        게임은 총 열 번의 '라운드'로 구성되고, 각 라운드 마다 자신이 가지고 있는 카드 중 하나를 제시하고,
        한번 제시한 카드는 버린다. 게임 승패는 다음과 같이 결정된다.
            1. 각 라운드는 더 높은 숫자를 제시한 사람이 승리하고, 제시한 숫자가 같은 경우는 비긴다.
            2. 열 번의 라운드에서 더 많은 라운드를 승리한 사람이 게임을 승리하고, 승리한 라운드 횟수가 동일한 경우 비긴다.

        다음은 게임의 한 예로 각 라운드마다 A와 B가 제시한 카드의 숫자아 각 라운드의 승자를 보여준다.(비긴 라운드는 D로 표기함)(아래 예제입출력확인)
        총 승자가 많은편으로

        입력 :
        다음 정보가 표준 입력으로 주어진다. 첫 번째 줄 에는 A가 제시한 카드의 숫자 10개가 라운드 순서대로 주어지며,
        두 번째 줄에는 B가 제시한 카드의 숫자 10 개가 라운드 순서대로 주어진다

        출력 :
        다음 정보를 표준 출력으로 출력한다. 게임의 승 패가 결정되는 경우 승리한 사람을 출력하고, 비기는 경우에는 D를 출력한다.

        예제 입력
        A: 6 7 5 1 4 10 2 3 8 9
        B: 1 10 2 9 4 8 3 7 5 6

        예제 출력
        A

        예제 입력 2
        A: 1 2 3 4 5 6  7 8 9 10
        B: 5 4 3 2 1 10 9 8 7 6

        예제 출력 2
        D
        */
    /*
        2가지 방법이 존재할듯
            1. 플레이어 A와 B의 승리횟수를 카운트 한 이후 대조
            2. DRAW를 와 a,b둘중 하나를 카운트 한 이후 10판에서 DRAW와 A를 뺸후 B를 구한 대조.
        => 1번이 더 편해보이네
    */
    private int winCountA;      //A의 승리 카운트
    private int winCountB;      //B의 승리 카운트
    private int drawCount;      //일단 무승부도 카운트
    private int[] cardListA;    //A의 카드 입력배열
    private int[] cardListB;    //B의 카드 입력 배열

    // S : 영역 시작, E : 영역 끝! , 카드는 매번 새로 만듬
    public munje1() {
        // S : 유희왕 드로우!
        this.setCardArr("A");
        this.setCardArr("B");
        // E : 유희왕 드로우!

        //승수 초기화 선언
        winCountA = winCountB = drawCount = 0;


        this.solution();
    }

    private void solution(){
        //같은 길이의 리스트인 경우에만 시작함.
        if(cardListB.length == cardListA.length){
            int cardLength = cardListA.length;
            for (int i = 0; i<cardLength; i++){
                if(cardListA[i]>cardListB[i]) //A가 B보다 큰 경우
                    winCountA++;
                else if(cardListA[i]==cardListB[i]) //동점인 경우
                    drawCount++;
                else
                    winCountB++;
            }
            if(winCountA > winCountB)
                System.out.println("A");
            else if(winCountA < winCountB)
                System.out.println("B");
            else
                System.out.println("D");
        }else{
            System.out.println("length 불일치");
        }
    }

    //cardList배열의 셋팅메소드
    private void setCardArr(String whoSet){
        boolean setAryFlag  = true; //입력된 카드의 셋팅, 내가 입력하기 귀찮음. 다 뽑으면 false로 바뀜.
        int aryNum          = 0;    //cardList방을 찾아줄 Idx Number

        //중복을 막기위한 배열, false 는 안뽑음 true 값은 뽑은상태
        //배열 사이즈는 10으로 리턴받음
        boolean[] cardConfirm = initConfirmAry();

        //cardList 배열 사이즈 정립
        if(whoSet.equals("A")){ cardListA = new int[cardConfirm.length]; }
        else{                   cardListB = new int[cardConfirm.length]; }

        while(setAryFlag) {
            int rndNum = (int) (Math.random() * 10);   //0~9
            if (!cardConfirm[rndNum]) {       //안뽑은 숫자인 경우
                //0~9기떄문에 +1 해줘야함 ++는 다음에 배열에 true선언해주기에 쓰지말공 ㅎㅎ;;;
                if (whoSet.equals("A")) {
                    cardListA[aryNum] = rndNum + 1;
                } else {
                    cardListB[aryNum] = rndNum + 1;
                }

                cardConfirm[rndNum] = true;
                aryNum++;

                boolean confirmAllTrue = getAllTrue(cardConfirm);

                if (aryNum >= 10 && confirmAllTrue) { //10보다크고 모든 배열이 다 true라면 반복문 탈출
                    setAryFlag = false;
                }
            }
        }
        /*
        //Test 확인
        if(whoSet.equals("A")){
            System.out.println("A의 카드 리스트 : "+Arrays.toString(cardListA));
            return;
        }
        System.out.println("B의 카드 리스트 : "+Arrays.toString(cardListB));
        */
    }

    //카드리스트를 선언할 boolean 배열 초기화
    private boolean[] initConfirmAry(){
        boolean[] ary = new boolean[10];
        Arrays.fill(ary, false);
        return ary;
    }

    //boolean 배열이 모두 true(다뽑힌것인지) 확인 false가 나오는 즉시 return
    private boolean getAllTrue(boolean[] confirmAry){
        for (boolean value : confirmAry){
            if(!value) return false;
        }
        return true;
    }

    //============Getter, Setter 영역============
    private int getWinCountA() {
        return winCountA;
    }

    private void setWinCountA(int winCountA) {
        this.winCountA = winCountA;
    }

    private int getWinCountB() {
        return winCountB;
    }

    private void setWinCountB(int winCountB) {
        this.winCountB = winCountB;
    }
}
