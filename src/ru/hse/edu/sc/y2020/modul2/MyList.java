package ru.hse.edu.sc.y2020.modul2;

public interface MyList<T> {
    /**
     * Добавить элемент в список.
     * @param element данные для добавления.
     */
    void add(T element);

    /**
     * Удалить элемент из списка по индексу.
     * @param index индекс элемента для удаления.
     */
    void removeAt(int index);

    /**
     * Удалить первый элемент из списка с таким значением.
     * @param element значение элемента для удаления.
     * @return был ли удалён такой элемент.
     */
    boolean remove(T element);

    /**
     * Получить элемент из списка по индексу.
     * @param index индекс элемента.
     * @return элемент по данным индексом в списке.
     */
    T get(int index);

    /**
     * Показать размер списка.
     * @return размер списка.
     */
    int size();

    /**
     * Проверка на содержание в списке.
     * @param element значение элемента для проверки.
     * @return содержится ли этот элемент в списке.
     */
    boolean contains(T element);
}

    /*Список ваш должен уметь простые вещи типа добавления, удаления, получения элемента по индексу, показать размер
        Вынесите это в интерфейс MyList, а связный список реализует этот интерфейс*/