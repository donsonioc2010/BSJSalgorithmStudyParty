package week3;

import java.util.*;

public class munje1 {
/*
    https://www.acmicpc.net/problem/2220
    [백준 2220]
    문제 :
        힙은 자료의 추가, 우선순위가 제일 높은 자료의 삭제가 가능한 자료구조이다.

        이와 같은 힙에는 두 종류가 있는데, 각각 최소-힙, 최대-힙이다. 이 문제에서는 최대-힙을 다루기로 하자.
        이와 같은 최대-힙을 이용하면 O(n log n)정렬인 힙 정렬을 할 수 있다.

        우리가 다루기로 한 최대-힙을 이용하면 오름차순 정렬을 할 수 있다.
        힙 정렬은 크게 두 개의 단계로 나뉘는데, 첫 번째 단계는 주어진 자료들로 힙을 구성하는 단계이고, 두 번째 단계는 이렇게 구성된 힙에서 최댓값을 계속 제거하는 단계이다.

        예를 들어 (5, 4, 2, 1, 3)과 같은 힙을 살펴보자.
        이 힙에서 최댓값을 삭제하면 (3, 4, 2, 1)이 되고, 힙의 조건을 맞추기 위해 Swap을 한 번 하면 (4, 3, 2, 1)의 힙을 얻는다.
        이 힙에서 최댓값을 삭제하면 (1, 3, 2)이 되고, 힙의 조건을 맞추기 위해 Swap을 한 번 하면 (3, 1, 2)가 된다. 다음 단계에서는 (2, 1), (1)이 되고 힙 정렬이 종료된다.
        즉, 힙이 (5, 4, 2, 1, 3)과 같이 구성되어 있었다면, 정렬을 위해 Swap을 두 번 사용하게 된다.
        하지만 (5, 4, 3, 2, 1)과 같은 힙은 총 네 번의 Swap을 해야 한다.

        n이 주어졌을 때, 1부터 n까지의 수를 한 번씩 사용하여 만들 수 있는 힙들 중에서, 위와 같은 Swap 회수가 최대가 되도록 하는 힙을 출력하는 프로그램을 작성하시오.

    입력 :
        첫째 줄에 n이 주어진다. (1 ≤ n ≤ 100,000)

    출력 :
        첫째 줄에 n개의 정수로 힙을 출력한다.


    입력예제 1 :
            6
    출력예제 1 :
            6 5 3 2 4 1



    1부터로 시작해야함.
    상위노드는 /2릃 하면 상위노드의 Idx임
    맨뒤는 1
*/

    public munje1() {
        this.soludtion();
    }

    public void soludtion(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] aryN = new int[num + 1];

        /*
        *  선언 : 0 0 0 0 0 0
        *  i = 1 => 0 2 0 0 0 0
        *  i = 2 => 0 2 2 0 0 0 -> 0 3 2 0 0 0
        *  i = 3 => 0 3 2 3 0 0 -> 0 4 2 3 0 0
        *  i = 4 => 0 4 2 3 2 0 -> 0 4 4 3 2 0 -> 0 5 4 3 2 0
        *  0 5 4 3 2 1
        * */

        for (int i = 1; i < num; i++) {
            for (int j = i; j > 1; j = j / 2) {
                aryN[j] = aryN[j / 2];      //순서대로가아니라 노드 IDX로 계싼해야함. 1 2 4 5 3 6 으로 큰순서임.
            }
            aryN[1] = i + 1;
        }
        aryN[num] = 1;
        for (int i = 1; i <= num; i++)
            System.out.print(aryN[i] + " ");
    }

}