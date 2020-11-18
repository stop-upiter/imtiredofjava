package ru.hse.edu.sc.y2020.seminar03.homework.plusesBse199App;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bse199 bse199 = new Bse199();
        for (String s:
             strlistOfBse199Students) {
            String[] names = s.split("/");
            bse199.add(new Student(names[0], names[1], names[2]));
        }

        System.out.println("Здравствуйте! Мы начинаем урок!");
        do {
            int numberToDo = -1;
            boolean shouldShowWrongNumbWarning = true;
            do {
                if (shouldShowWrongNumbWarning)
                {
                    shouldShowWrongNumbWarning = false;
                }
                else {
                    System.out.println("Команды с таким числом нет =( Попробуйте ещё раз!");
                }
                System.out.println("Чтобы показать всех студентов, нажмите 1");
                System.out.println("Чтобы рандомно выбрать отвечающего, нажмите 2");
                System.out.println("Чтобы выбрать студента по фамилии, нажмите 3");
                System.out.println("Чтобы закончить урок, нажмите 4");
                try{
                    numberToDo = sc.nextInt();
                }
                catch (InputMismatchException ex)
                {
                    numberToDo = -1;
                    System.out.println("Но ведь... нужно было ввести целое число... Попробуйте ещё раз!");
                    shouldShowWrongNumbWarning = true;
                    sc.nextLine();
                }
            } while(numberToDo<1 || numberToDo > 4);

            if (numberToDo == 1){
                bse199.showAllStudents();
            }
            else if (numberToDo<4){
                if (numberToDo == 3) {

                    String surname;
                  do {
                       System.out.println("Введите фамилию студента:");
                       surname = sc.nextLine();
                       if(!bse199.isInGroup(surname)) sc.nextLine();
                       else break;
                   } while (true);

                    surname = surname.trim();

                    bse199.choseCertainStudent(surname);
                    System.out.println("Студент выбран. Отвечает:");
                    bse199.showCurrentStudent();
                }
                else{
                    System.out.println("Отвечает:");
                    bse199.soutRandomStudent();
                }
                System.out.println("1 - \"плюсик\", 0 - \"ничего\", -1 - \"минус\"");
                int mark = -2;
                do {
                    System.out.println("Как ответил? " +
                            "1 - \"плюсик\", 0 - \"ничего\", -1 - \"минус\"");
                    try{
                        mark = sc.nextInt();
                    }
                    catch (InputMismatchException ex){
                        System.out.println("Вы ввели что-то совсем не то! " +
                                "Используйте только целые числа и знак минуса, пожалуйста");
                        mark = -2;
                        sc.nextLine();
                    }
                } while (mark<-1 || mark>1);

                if (mark!=0){
                    bse199.rateCurrentStudent(mark==1);
                }
            } else{
                System.out.println("Урок окончен!");
                bse199.showMarks();
                break;
            }

        } while(true);

    }

    private static final String[] strlistOfBse199Students = {
            "Агроскин/Александр/Викторович",
            "Асатиани/Тимур/Ренадиевич",
            "Борисов/Константин/Николаевич",
            "Вахитова/Диана/Рафиковна",
            "Волохов/Никита/Алексеевич",
            "Галанов/Александр/Сергеевич",
            "Голикова/Екатерина/Вадимовна",
            "Джураев/Рашид/Мансурович",
            "Ермилов/Артемий/Васильевич",
            "Кочарян/Тигран/Самвелович",
            "Кочик/Дмитрий/Алексеевич",
            "Крылов/Павел/ Юрьевич",
            "Кузнецов/ Михаил/Александрович",
            "Куприхин/ Дмитрий/ Алексеевич",
            "Мостачев/ Андрей/ Олегович",
            "Поволоцкий /Виктор /Александрович",
            "Поляков/ Лев /Алексеевич",
            "Ризоева /Амина /Фазлиддиновна",
            "Сальникова /Алиса/ Дмитриевна",
            "Сатыбалды/ Касымжомарт/ ",
            "Скрыпников/ Егор /Андреевич",
            "Темирханов /Михаил /Борисович",
            "Терехова/ София Мария /Всеволодовна",
            "Ткаченко/ Никита/ Сергеевич",
            "Точилина/ Полина/ Витальевна",
            "Федченко/ Всеволод /Александрович",
            "Шарипов /Сардор /Уткирович",
            "Щербаков/ Дмитрий /Александрович"};


}
