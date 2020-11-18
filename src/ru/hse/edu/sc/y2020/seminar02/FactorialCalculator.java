package ru.hse.edu.sc.y2020.seminar02;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Scanner;

public class FactorialCalculator
{
    public static void main(String[] args) {
        Optional<BigInteger> bigInteger = Factorial(-4);
        System.out.println(bigInteger.isPresent()?bigInteger.get():"oops");



    }
    public static Optional<BigInteger> Factorial(int value)
    {
        if (value<0) return Optional.empty();

        BigInteger base = BigInteger.ONE;
        for (int i = 2; i<=value;
            i++)
        {
            base = base.multiply(BigInteger.valueOf(i));
            System.out.println(base);
        }


        return Optional.of(base);
    }
}
