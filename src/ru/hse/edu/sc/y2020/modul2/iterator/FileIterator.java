package ru.hse.edu.sc.y2020.modul2.iterator;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Класс итератора по файлу построково.
 */
public class FileIterator implements Iterator<String>, Closeable {

    /**
     * Поток для чтения из файла.
     */
    protected BufferedInputStream bufferedInputStream;

    /**
     * Путь к читаемому файлу.
     */
    private final String path;

    /**
     * Конструктор итератора по фпйлу.
     * @param filePath путь к файлу для итерации.
     * @throws FileNotFoundException если по пути filepath нет файла.
     */
    public FileIterator(final String filePath) throws FileNotFoundException {
        Objects.requireNonNull(filePath);
        path = filePath;
        bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
    }
    //todo русские буквы

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        try {
            return bufferedInputStream.available() > 0;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public String next() {

        StringBuilder stringBuilder = new StringBuilder();
        int currentByteValue /*= '\r'*/;
        try {
           /* while (currentByteValue == (int) '\r') {*/
                currentByteValue = bufferedInputStream.read();
            /*}*/
        } catch (IOException ioException) {
            throw new NoSuchElementException();
        }

        if (currentByteValue == -1) {
            throw new NoSuchElementException();
        }


        while (currentByteValue != -1 && currentByteValue != (int) '\n') {
            if (currentByteValue != (int) '\r') {
                stringBuilder.append((char) currentByteValue);
            }

            try {
                currentByteValue = bufferedInputStream.read();
            } catch (IOException e) {
                currentByteValue = -1;
            }
        }

        return stringBuilder.toString();
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        bufferedInputStream.close();
    }

    /**
     * Перезапустить итератор.
     * @throws IOException если возникает ошибка ввода/вывода.
     */
    public void restart() throws IOException {
        bufferedInputStream.close();
        bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
    }

    // дефолтная реализация метода forEachRemaining хорошая

/*    @Override
    public void forEachRemaining(Consumer<? super String> action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(next());
        }
    }*/
}
