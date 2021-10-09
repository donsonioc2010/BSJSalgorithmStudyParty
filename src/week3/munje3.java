package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class munje3 {
    /*
        https://www.acmicpc.net/problem/2751 [만들어져 있는 클래스 사용x]
        [백준 2751]
        문제 :
            N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

        입력 :
            첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
            둘째 줄부터 N개의 줄에는 수가 주어진다.
            이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

        출력 :
            첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

        예제 입력 1 :
            5
            5
            4
            3
            2
            1

        예제 출력 1 :
            1
            2
            3
            4
            5
    */
    static int[] tmp;
    public munje3() throws Exception{
        this.solution();
    }

    private void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(br.readLine());
        int[] ary = new int[total+10];
        for(int i = 0; i < total; i++)
            ary[i] = Integer.parseInt(br.readLine());
        tmp = new int[total+10];
        merge(ary,0,total-1);
        for(int i =0; i< total; i++)
            bw.write(String.valueOf(ary[i])+"\n");
        bw.close();
    }

    private void merge(int[] org, int stNum , int edNum ){
        if( stNum < edNum){
            int mid = (stNum + edNum) / 2;
            merge(org, stNum, mid);              //앞부분 tmp로
            merge(org, mid + 1, edNum);   //뒷부분 tmp정렬
            mergeSort(org, stNum, mid, edNum);
        }
    }

    private void mergeSort(int[] arr, int stNum, int mid, int edNum){
        int p = stNum;      //mid 이하
        int q = mid + 1;    //q가 edNum 이하일때
        int idx = stNum;

        while( p<=mid || q<=edNum ){
            if(q>edNum||(p<=mid && arr[p]<arr[q]))
                tmp[idx++] = arr[p++];
            else
                tmp[idx++] = arr[q++];
        }
        for(int i =stNum; i<=edNum; i++)
            arr[i] = tmp[i];

        System.out.println(Arrays.toString(tmp));
    }
}

