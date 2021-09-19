package week2;

import java.util.Scanner;

public class munje1 {
    /*
        문제 컨펌끝남 ㅎㅎㅎㅎㅎㅎㅎㅎ

    링크 :
        https://www.acmicpc.net/problem/2609

    문제 :
        두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
    입력 :
        첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
    출력 :
        첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

    예제 :
        입력 1:
            24 18
        출력 1:
            6
            72

        (가정)
        최대 공약수 : G
        최소 공배수 : L = G * a * b
                    => L * G = a * b

        a = num1 / G, b = num2 / G
     */

    public munje1() {
        this.solution();
    }

    public void solution(){
        Scanner sc = new Scanner(System.in);

        //숫자 1, 2
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        // num 10000이하
        if(num1 > 10000 && num2 > 10000){
            return;
        }

        int ans1 = gcd(num1, num2);

        num1 = num1 / ans1;
        num2 = num2 / ans1;

        //최소 공배수
        int ans2 = num1 * num2 * ans1;

        System.out.println(ans1);
        System.out.println(ans2);
    }

    //유클리드호제법
    private int gcd(int num1, int num2){
        int mod = num1 % num2;

        if(mod == 0)
            return num2;
        else
            return gcd(num2, mod);
    }
}
