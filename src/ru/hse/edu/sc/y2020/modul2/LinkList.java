package ru.hse.edu.sc.y2020.modul2;

/**
 * Связный список.
 * @param <T> Тип данных в списке.
 */
public class LinkList<T> implements MyList<T> {
    /**
     * Класс одного элемента списка.
     */
    private static class Node<T>{
        /**
         * Данные элемента.
         */
        T value;

        /**
         * Ссылка на следующий элемент списка.
         */
        Node<T> next = null;

        /**
         * Конструктор элемента списка.
         * @param element значение данных элемента.
         */
        Node(T element){
            value = element;
        }
    }

    /**
     * Количество элементов в списке.
     */
    private int size = 0;

    /**
     * Корневой (первый) элемент списка.
     */
    private Node<T> root = null;

    /**
     * Добавить элемент в список.
     * @param element данные для добавления.
     */
    @Override
    public void add(T element) {
        if (root == null){
            root = new Node<>(element);
        }
        else {
            Node<T> current = root;
            while (current.next !=null){
                current = current.next;
            }
            current.next = new Node<>(element);
        }
        size++;
    }

    /**
     * Удалить элемент из списка по индексу.
     *
     * @param index индекс элемента для удаления.
     */
    @Override
    public void removeAt(int index) {
        if (index>-1 && index<size){
            int counter = 0;
            Node<T> previous = null;
            Node<T> current = root;
            while(counter<index){
                previous = current;
                current = current.next;
                counter++;
            }
            if (previous==null){
                root = null;
            }
            else{
                previous.next = current.next;
            }
            size--;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Удалить первый элемент из списка с таким значением.
     * @param element значение элемента для удаления.
     * @return был ли удалён такой элемент.
     */
    @Override
    public boolean remove(T element) {
        if (root != null) {
            Node<T> previous = null;
            Node<T> current = root;
            while (current.value.equals(element) && current.next != null) {
                previous = current;
                current = current.next;
            }
            if (current.value.equals(element)) {
                if (previous == null) {
                    root = null;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Получить элемент из списка по индексу.
     * @param index индекс элемента.
     * @return элемент по данным индексом в списке.
     */
    @Override
    public T get(int index) {
        if (index>-1 && index<size){
            int counter = 0;
            Node<T> current = root;
            while (counter<index){
                current = current.next;
                counter++;
            }
            return current.value;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Показать размер списка.
     * @return размер списка.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Проверка на содержание в списке.
     *
     * @param element значение элемента для проверки.
     * @return содержится ли этот элемент в списке.
     */
    @Override
    public boolean contains(T element) {
        Node<T> current = root;
        while (current!=null){
            if (current.value.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

    /*связного списка от вас(от КАЖДОГО)
    Список ваш должен уметь простые вещи типа добавления, удаления, получения элемента по индексу, показать размер
        Вынесите это в интерфейс MyList, а связный список реализует этот интерфейс*/