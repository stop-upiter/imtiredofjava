package ru.hse.edu.sc.y2020.seminar01.homework;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibbonachi {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        do {

            int number;
            do {
                System.out.println(
                        "Введите неотрицательное число");
                number = in.nextInt();
            } while(number<0);

            fibonacci(number);

            System.out.println("Press 0 to restart:");
        } while(in.nextInt() == 0);
    }
    static void fibonacci(int num) {
        BigInteger last1 = BigInteger.valueOf(0);
        BigInteger last2 = BigInteger.valueOf(1);
        for (int i = 0; i<=num;i++){
            if (i==0 || i==1) {
                System.out.println(i);
            }
            else {
                BigInteger tmp = last1.add(last2);
                last1 = last2;
                last2 = tmp;
                // В типе BigInteger не должно использоваться.
                if ((BigInteger.valueOf(0).compareTo(last2)==1)) {
                    System.out.print(
                            "Переполнение памяти. " +
                                    "Дальнейший подсчёт остановлен. " +
                                    "Текущий номер ");
                    System.out.println(i);
                    break;
                }
                else System.out.println(last2);
            }

        }
    }
}
