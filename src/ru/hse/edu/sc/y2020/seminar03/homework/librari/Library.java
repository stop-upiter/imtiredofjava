package ru.hse.edu.sc.y2020.seminar03.homework.librari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 * Класс библиотеки для работы с книгами.
 */
public class Library {
    /**
     * Все книги библиотеки.
     */
    private final ArrayList<Book> books = new ArrayList<Book>();;


    /**
     * Рандомайзер для выбора книги вслепую.
     */
    private final Random random = new Random();

    /**
     * Конструктор библиотеки.
     * Выбран именно объектый метод взаимодействия,
     * так как библиотек может быть несколько.
     */
    public Library(){}

    /**
     * Публичный конструктор библиотеки с параметром массивом.
     * @param arr массив книг для добавления на полки.
     */
    public Library(Book[] arr){
        books.addAll(Arrays.asList(arr));
    }

    /**
     * Публичный конструктор библиотеки с параметром списком.
     * @param arrList список книг для добавления на полки.
     */
    public Library(ArrayList<Book> arrList){
        books.addAll(arrList);
    }


    /**
     * Выбор книги вслепую.
     * @return рандомную книгу.
     */
    public Optional<Book> take(){
        if (books.size() == 0) {return Optional.empty();}

        int index = random.nextInt(books.size());
        Book book = books.get(index);
        books.remove(index);
        return Optional.of(book);
    }

    /**
     * Выбор конкретной книги.
     * @param title название книги.
     * @return конкретную книгу.
     */
    public Optional<Book> take(String title){
        if (isInLibrary(title)){
            for (Book book: books)
            {
                if (book.getTittle().equals(title))
                {
                    books.remove(book);
                    return Optional.of(book);
                }
            }
        }

        return Optional.empty();
    }

    /**
     * Определить есть ли книга в библиотеке.
     * @param title название книги.
     * @return есть ли книга в библиотеке.
     */
    public boolean isInLibrary(String title){
        for (Book b:
             books) {
            if (b.getTittle().equals(title)) { return true;}
        }
        return false;
    }
    /**
     * Определить есть ли книга в библиотеке.
     * @param b книга.
     * @return есть ли книга в библиотеке.
     */
    public boolean isInLibrary(Book b){
        return books.contains(b);
    }

    /**
     * Сдать книгу в библиотеку.
     * @param book книга для сдачи.
     */
    public boolean put(Book book){
        if (book != null) {
            books.add(book);
            return true;
        }
        return false;
    }
}
