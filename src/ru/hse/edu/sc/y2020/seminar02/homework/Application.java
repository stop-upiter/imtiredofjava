package ru.hse.edu.sc.y2020.seminar02.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Домашняя работа № 2.
 * Ризоева Амина, БПИ199.
 */
public class Application {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Зацикливание программы.
        do {
            Object o = new Object();
            int methodNumber = ReadMethodNumber(0, 3);
            double number = ReadNotNegativeDouble();

            System.out.print("Получили: ");
            switch (methodNumber) {

                case 0:
                    System.out.println(Mile2Km(number) + " км");
                    break;
                case 1:
                    System.out.println(Km2Mile(number) + " миль");
                    break;
                case 2:
                    System.out.println(Celsium2Farenheit(number) + " °F");
                    break;
                case 3:
                    System.out.println(Farenheit2Celsium(number) + " °C");
                    break;
                default:
                    System.out.println("ничего");
                    break;
            }

            System.out.println("Для продолжения работы с методами перевода введите 1.");
            sc.nextLine();
        }
        while(sc.next().trim().equals("1"));

        System.out.println("Программа завершена. Хорошего вам дня!");
    }

    /**
     * Перевод миль в километры.
     * @param mile мили
     * @return километры
     */
    public static double Mile2Km(double mile){
        return mile*1.60934;
    }

    /**
     * Перевод километров в мили
     * @param km километры
     * @return мили
     */
    public static double Km2Mile(double km){
        return km/1.60934;
    }

    /**
     * Перевод градусов в фаренгейты
     * @param celsium градусы цельсия
     * @return фаренгейты
     */
    public static double Celsium2Farenheit(double celsium){
        return celsium*1.8 + 32;
    }

    /**
     * Перевод фаренгейтов в градусы
     * @param farenheit фаренгейты
     * @return градусы цельсия
     */
    public static double Farenheit2Celsium(double farenheit){
        return (farenheit - 32)/1.8;
    }

    /**
     * Зацикленный ввод пользователя номера метода с пояснениями для ввода.
     * @param from первый номер из ряда последовательной нумерации методов
     * @param to последний номер из ряда
     * @return номер метода для осуществления.
     */
    public static int ReadMethodNumber(int from, int to){
        int methodNumber = -1;
        do {
            System.out.println("Выберите, что вы хотите сделать.");
            System.out.println("0 - перевести мили в километры");
            System.out.println("1 - перевести километры в мили");
            System.out.println("2 - перевести градусы в фаренгейты");
            System.out.println("3 - перевести фаренгейты в градусы");

            try {
                methodNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("А метода с таким номером нет!");
                sc.nextLine();
            }
        } while (methodNumber < from || methodNumber > to);

        return methodNumber;
    }

    /**
     * Зацикленный ввод неотрицательного числа.
     * @return неотрицательное число
     */
    public static double ReadNotNegativeDouble(){
        double number = Double.NaN;
        do {
            System.out.println("Введите неотрицательное число:");

            try {
                number = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Упс, введено что-то не то!");
                sc.nextLine();
            }
        }
        while (!Double.isFinite(number) || number < 0);

        return number;
    }
}
