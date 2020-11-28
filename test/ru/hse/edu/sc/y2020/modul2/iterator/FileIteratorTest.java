package ru.hse.edu.sc.y2020.modul2.iterator;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FileIteratorTest {

    private final String unfoundedTestFilePath = "no.txt";
    private final String oneLineTestFilePath ="./test/ru/hse/edu/sc/y2020/modul2/" +
            "iterator/fileIteratorTests/test1.txt";
    private final String twoLineTestFilePath = "./test/ru/hse/edu/sc/y2020/modul2/" +
            "iterator/fileIteratorTests/test2.txt";
    private final String emptyTestFilePath = "./test/ru/hse/edu/sc/y2020/modul2/" +
            "iterator/fileIteratorTests/test3.txt";
    private final String textTestFilePath = "./test/ru/hse/edu/sc/y2020/modul2/" +
            "iterator/fileIteratorTests/test4.txt";

    @Test
    void createNull(){
        assertThrows(NullPointerException.class, ()->new FileIterator(null));
    }

    @Test
    void createUnfounded(){
        assertThrows(FileNotFoundException.class, ()->new FileIterator(unfoundedTestFilePath));
    }

    @Test
    void createSucceed(){
        assertDoesNotThrow(()-> {
            FileIterator fileIterator = new FileIterator(oneLineTestFilePath);
            fileIterator.close();
        });

    }


    @Test
    void hasNext() throws IOException {
        FileIterator fileIterator = new FileIterator(oneLineTestFilePath);
        assertTrue(fileIterator.hasNext());
        fileIterator.close();
        fileIterator = new FileIterator(emptyTestFilePath);
        assertFalse(fileIterator.hasNext());
        fileIterator.close();
    }

    @Test
    void next() throws IOException {
        FileIterator fileIterator = new FileIterator(twoLineTestFilePath);
        assertEquals("Dont give up!", fileIterator.next());
        assertEquals("Naruto wanted to become Hokage, " +
                "nobody believed in him " +
                "but he achieved it.",
                fileIterator.next());
        assertThrows(NoSuchElementException.class, fileIterator::next);
        fileIterator.close();
    }

    Integer counter = 0;
    @Test
    void forEachRemaining() throws IOException {

        FileIterator fileIterator = new FileIterator(textTestFilePath);
        assertDoesNotThrow(()->fileIterator.forEachRemaining(System.out::println));
        fileIterator.restart();
        fileIterator.forEachRemaining((s -> counter++));
        assertEquals(10, counter);
        fileIterator.close();
    }



}