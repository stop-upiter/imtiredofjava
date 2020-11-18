package ru.hse.edu.sc.y2020.seminar03.homework.librari;

/**
 * Класс книги.
 */
public class Book {
    /**
     * Название книги.
     */
    public String tittle;

    /**
     * Текст книги.
     */
    public String text;

    /**
     * Автор книги.
     */
    public String author;

    /**
     * Публичный конструктор книги с одним параметром.
     * @param tittle название книги.
     */
    public Book(String tittle){
       this(tittle, "");
    }

    /**
     * Публичный конструктор книги с двумя параметрами.
     * @param tittle название книги.
     * @param text текст книги.
     */
    public Book(String tittle, String text){
        this(tittle, text, "");
    }

    /**
     * Публичный конструктор книги с тремя параметрами.
     * @param tittle название книги.
     * @param text текст книги.
     * @param author автор книги.
     */
    public Book(String tittle, String text, String author){
        if (tittle.trim().isBlank()) throw new IllegalArgumentException();
        this.tittle = tittle;
        this.text = text;
        this.author = author;
    }

    /**
     * Метод для определения равенства книг.
     * @param obj объект для сравнения.
     * @return одинаковы ли названия книг.
     */
    @Override
    public boolean equals(Object obj) {
        return (obj != null) &&
                (getClass() == obj.getClass()) && (tittle.equals(((Book) obj).tittle));
    }

    /**
     * Геттер низвания книги.
     * @return название книги.
     */
    public String getTittle() {return tittle;}

    /**
     * Геттер текста книги.
     * @return текст книги.
     */
    public String getText() {return text;}

    /**
     * Геттер автора книги.
     * @return автор книги.
     */
    public String getAuthor(){return  author;}
}
