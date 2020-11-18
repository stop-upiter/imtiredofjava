package ru.hse.edu.sc.y2020.seminar03.homework.plusesBse199App;

import java.util.ArrayList;

/**
 * Класс студента.
 */
public class Student {
    /**
     * Имя студента.
     */
    private final String name;

    /**
     * Фамилия студента.
     */
    private final String surname;

    /**
     * Отчество студента.
     */
    private final String fathersName;

    /**
     * Подсчёт плюсиков.
     */
    private int pluses;

    public Student(String surname, String name){
        this(surname, name, "");
    }

    public Student(String surname, String name, String fathersName){
        if (surname.isBlank() ||
                name.isBlank() ||
                (surname.length()<2) ||
                (name.length()<2))
        {throw new IllegalArgumentException();}
        this.surname = surname.trim();
        this.name = name.trim();
        this.fathersName = fathersName.trim();
        pluses = 0;
    }

    /**
     * Поставить плюсик.
     */
    public void plus(){
        pluses++;
    }

    /**
     * Поставить минус.
     */
    public void minus(){
        if (pluses>-5) {
            pluses--;
        }
    }

    /**
     * Геттер для имени.
     * @return имя студента.
     */
    public String getName(){
        return name;
    }

    /**
     * Геттер для фамилии.
     * @return фамилию студента.
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Геттер для отчества.
     * @return отчество.
     */
    public String getFathersName(){
        return fathersName;
    }

    /**
     * Геттер плюсиков.
     * @return
     */
    public int getPluses(){
        return pluses;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + fathersName;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj!= null)&&
                (getClass() == obj.getClass())&&
                (name.equals(((Student) obj).name)&&
                        (surname.equals(((Student)obj).surname))&&
                        (fathersName.equals(((Student)obj).fathersName)));
    }
}
