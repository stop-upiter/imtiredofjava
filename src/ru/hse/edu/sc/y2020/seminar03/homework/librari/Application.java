package ru.hse.edu.sc.y2020.seminar03.homework.librari;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        library.put(new Book("if im tired", "if you tired go and sleep"));
        library.put(new Book("Harry Potter is ok", "Harry had good lovely family and lived happily"));
        library.put(new Book("1"));
        library.put(new Book("2"));

        System.out.println(library.isInLibrary("1"));
        System.out.println(library.isInLibrary("if im tired"));
        System.out.println(library.isInLibrary("3"));
        System.out.println();

        var tmp = library.take("if im tired");
        if (tmp.isPresent()){
            Book book = tmp.get();
            System.out.println(book.getTittle());
            System.out.println(book.getText());
            System.out.println(library.isInLibrary(book));
            System.out.println();

            library.put(book);
            System.out.println(library.isInLibrary(book));    }
        else{
            System.out.println("Книга не взялась");
        }



    }
}
