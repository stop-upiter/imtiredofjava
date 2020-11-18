package ru.hse.edu.sc.y2020.seminar03.homework.plusesBse199App;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 * Класс группы бпи199.
 */
public class Bse199 {
    /**
     * Список студентов.
     */
    private final ArrayList<Student> myGroup = new ArrayList<>();;

    /**
     * Рандомайзер.
     */
    private static final Random random = new Random();;

    /**
     * Сейчас спрашиваемый студент.
     */
    private int currentStudent = -1;


    /**
     * Конструктор группы без параметров.
     */
    public Bse199(){}

    /**
     * Конструктор с одним параметром.
     * @param students список студентов группы.
     */
    public Bse199(ArrayList<Student> students){
        addRange(students);
    }
    /**
     * Выбрать рандомного студента.
     * @return рандомного студента.
     */
    public Student ChooseRandomStudent(){
        currentStudent = random.nextInt(myGroup.size());
        return myGroup.get(currentStudent);
    }


    /**
     * Вывести рандомного студента.
     * Нас просили именно такой метод. Я сделала.
     */
    public void soutRandomStudent(){
        System.out.println(ChooseRandomStudent());
    }

    /**
     * Оценить текущего студента.
     * @param isMarkGood плюсик ставим?
     */
    public void rateCurrentStudent(boolean isMarkGood){
        if (isMarkGood) {myGroup.get(currentStudent).plus();}
        else {myGroup.get(currentStudent).minus();}
    }

    /**
     * Оценить текущего студента плюсиком.
     */
    public void rateCurrentStudent(){
        rateCurrentStudent(true);
    }

    /**
     * Выбрать студента по фамилии.
     * @param surname фамилия.
     * @return нашелся ли студент.
     */
    public boolean choseCertainStudent(String surname){
        if (isInGroup(surname)){
            for (Student s:
                 myGroup) {
                if (s.getSurname().equals(surname)){
                    currentStudent = myGroup.indexOf(s);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Выбрать студента по фамилии и имени.
     * @param surname фамилия.
     * @param name имя
     * @return нашелся ли студент.
     */
    public boolean choseCertainStudent(String surname, String name){
        if (isInGroup(surname, name)){
            for (Student s:
                    myGroup) {
                if (s.getSurname().equals(surname) && s.getName().equals(name)){
                    currentStudent = myGroup.indexOf(s);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Выбрать студента по фио.
     * @param surname фамилия.
     * @param name имя
     * @param fathersname отчество.
     * @return нашелся ли студент.
     */
    public Optional<Student> choseCertainStudent(String surname, String name, String fathersname){
        if (isInGroup(surname, name, fathersname)){
            for (Student s:
                    myGroup) {
                if (s.getSurname().equals(surname) &&
                        s.getName().equals(name) &&
                        s.getFathersName().equals(fathersname)){
                    currentStudent = myGroup.indexOf(s);
                    return Optional.of(s);
                }
            }
        }

        return Optional.empty();
    }

    /**
     * Определить есть ли студент с такой фамилией в группе.
     * @param surname фамилия.
     * @return есть ли студент с такой фамилией.
     */
    public boolean isInGroup(String surname){
        for (Student s: myGroup) {
            if (s.getSurname().equals(surname)) { return true;}
        }

        return false;
    }


    /**
     * Определить есть ли студент с такой фи в группе.
     * @param surname фамилия.
     * @param name имя.
     * @return есть ли студент.
     */
    public boolean isInGroup(String surname, String name){
        for (Student s: myGroup) {
            if (s.getSurname().equals(surname) && s.getName().equals(name)) {return true;}
        }

        return false;
    }

    /**
     * Определить есть ли студент с такой фио в группе.
     * @param surname фамилия.
     * @param name имя.
     * @param fathersname отчество.
     * @return есть ли студент.
     */
    public boolean isInGroup(String surname, String name, String fathersname){
        for (Student s: myGroup) {
            if (s.getSurname().equals(surname) &&
                    s.getName().equals(name) &&
                    s.getFathersName().equals(fathersname)) {return true;}
        }

        return false;
    }

    public boolean isInGroup(Student student) {return isInGroup(student.getSurname(), student.getName(), student.getFathersName());}

    /**
     * Добавить студента.
     * @param student студент.
     * @return добавился ли.
     */
    public boolean add(Student student){
        if (student != null){
            myGroup.add(student);
            ChooseRandomStudent();
            return true;
        }

        return false;
    }

    /**
     * Добавить список студентов.
     * @param students список студентов.
     */
    public void addRange(ArrayList<Student> students){
        students.removeIf(Objects::isNull);
        myGroup.addAll(students);
    }

    /**
     * Удалить студента.
     * @param student студент на отчисление.
     */
    public boolean Remove(Student student){
        if (student== null || !isInGroup(student)) {return false;}
            myGroup.remove(student);
            if (currentStudent >= myGroup.size()) {ChooseRandomStudent();}
            return true;
    }

    /**
     * Удачить по фамилии.
     * @param surname фамилия для отчисления.
     */
    public boolean Remove(String surname){
        if (!isInGroup(surname)) {return false;}
        myGroup.removeIf(s -> s.getSurname().equals(surname));
        if (currentStudent >= myGroup.size()) {ChooseRandomStudent();}
        return true;
    }

    /**
     * Отчислисть по ФИ.
     * @param surname фамилия.
     * @param name имя.
     */
    public boolean Remove(String surname, String name){
        if (!isInGroup(surname, name)) {return false;}
        myGroup.removeIf(s -> s.getSurname().equals(surname) && s.getName().equals(name));
        if (currentStudent >= myGroup.size()) {ChooseRandomStudent();}
        return true;
    }

    /**
     * Отчислить по ФИО
     * @param surname фамилия.
     * @param name имя.
     * @param fathersname отчестов.
     */
    public boolean Remove(String surname, String name, String fathersname){
        if (!isInGroup(surname,name,fathersname)) {return false;}
        myGroup.removeIf(s -> s.getSurname().equals(surname)
                && s.getName().equals(name)
                && s.getFathersName().equals(fathersname));
        if (currentStudent >= myGroup.size()) {ChooseRandomStudent();}
        return true;
    }

    /**
     * Вывести всех студентов.
     */
    public void showAllStudents(){
        for (Student s:
             myGroup) {
            System.out.println(s);
        }
    }

    /**
     * Показать все оценки за пару.
     */
    public void showMarks(){
        for (Student s:
                myGroup) {
            System.out.println(s + ": " + s.getPluses());
        }
    }

    /**
     * Показать текущего отвечающего студжента.
     */
    public void showCurrentStudent(){
        System.out.println(myGroup.get(currentStudent));
    }



}
