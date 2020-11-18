package ru.hse.edu.sc.y2020.modul2;

public class ArrayList<T>  implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array = createArr(DEFAULT_CAPACITY);
    private int size;

    private T[] createArr(int capacity){
        return (T[])(new Object[capacity]);
    }

    /**
     * Добавить элемент в список.
     *
     * @param element данные для добавления.
     */
    @Override
    public void add(T element) {
        if (size == array.length){
            T[] tmp = createArr(size*2);
            System.arraycopy(array, 0, tmp, 0, size);
            tmp[size] = element;
            array = tmp;
        }
        else {
            array[size] = element;
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
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException();
        }

        int capacity = array.length;
        if (capacity/2 > size - 1){
            capacity/=2;
        }
        T[] tmp = createArr(capacity);

        boolean after = false;

        for (int i = 0; i<size; i++){
            if (i == index){
                after = true;
                size--;
                continue;
            }

            if (after){
                tmp[i] = array[i+1];
            }
            else{
                tmp[i] = array[i];
            }

        }
        array = tmp;
    }

    /**
     * Удалить первый элемент из списка с таким значением.
     *
     * @param element значение элемента для удаления.
     * @return был ли удалён такой элемент.
     */
    @Override
    public boolean remove(T element) {
        T[] tmp = createArr(array.length);

        boolean after = false;

        for (int i = 0; i<size; i++){
            if (!after && array[i].equals(element)){
                after = true;
                size--;
                continue;
            }

            if (after){
                tmp[i] = array[i+1];
            }
            else{
                tmp[i] = array[i];
            }
        }
        array = tmp;
        return after;
    }

    /**
     * Получить элемент из списка по индексу.
     *
     * @param index индекс элемента.
     * @return элемент по данным индексом в списке.
     */
    @Override
    public T get(int index) {
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * Показать размер списка.
     *
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
        for (int i = 0; i<size; i++){
            if (array[i].equals(element)){
                return true;
            }
        }
        return false;
    }
}
