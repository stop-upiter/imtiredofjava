package ru.hse.edu.sc.y2020.modul2.iterator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Модифицированный итератор по файлу,
 * умеющий работать с символами в кодировке UTF-8.
 * В частности умеет распарсить кириллицу.
 */
public class ModifiedFileIterator extends FileIterator {
    /**
     * Конструктор итератора по фпйлу.
     *
     * @param filePath путь к файлу для итерации.
     * @throws FileNotFoundException если по пути filepath нет файла.
     */
    public ModifiedFileIterator(final String filePath) throws FileNotFoundException {
        super(filePath);
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
        List<Byte> bytes = new ArrayList<Byte>();
        int currentByteValue;
        try {
            currentByteValue= bufferedInputStream.read();
            if (currentByteValue == -1){
                throw new NoSuchElementException();
            }
        } catch (IOException ioException) {
            throw new NoSuchElementException();
        }

        while (currentByteValue != -1 && currentByteValue != (int) '\n') {
            if (currentByteValue !=(int)'\r'){
                bytes.add((byte)currentByteValue);
            }

            try {
                currentByteValue = bufferedInputStream.read();
            } catch (IOException e) {
                currentByteValue = -1;
            }
        }

        byte[] byteArr = new byte[bytes.size()];
        for (int i = 0; i < bytes.size();i++){
            byteArr[i] = bytes.get(i);
        }
        return new String(byteArr, StandardCharsets.UTF_8);
    }

}
