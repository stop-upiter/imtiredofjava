package ru.hse.edu.sc.y2020.seminar01.homework;

import java.awt.*;
import java.util.Scanner;

public class FizzBuzz {
    public static  void main(String[] args){

        Scanner in = new Scanner(System.in);
        do {
            for (int i =1; i<101; i++)
            {
                if (i%3==0 && i%5==0)
                {
                    System.out.println("FizzBuzz");
                }
                else if (i%3==0)
                {
                    System.out.println("Fizz");
                }
                else if (i%5==0)
                {
                    System.out.println("Buzz");
                }
                else
                    {
                        System.out.println(i);
                    }
            }

            System.out.println("Press 0 to restart:");
        } while(in.nextInt() == 0);
    }
}
