package ru.hse.edu.sc.y2020.modul2;

public class ArrayList<T> implements MyList<T> {
    // Костя: почему DEFAULT_CAPACITY это 0b1010, когда у нас каждый раз она увеличивается в двое (маленькая придирка)
    // Костя: но то что она сделана константой это хорошо
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array = createArr(DEFAULT_CAPACITY);
    private int size;

    // Костя: ещё тут идея ругается на то Unchecked cast
    // Костя: чтобы это исправить надо написать @SuppressWarnings("unchecked")
    private T[] createArr(int capacity) {
        // Костя: иногда createArr вызывается с темже capacity, который у нас уже есть
        // Костя: тут похорошему надо наверно возвращять старый масив
        return (T[]) (new Object[capacity]);
    }

    /**
     * Добавить элемент в список.
     *
     * @param element данные для добавления.
     */
    @Override
    public void add(T element) {
        if (size == array.length) {
            T[] tmp = createArr(size * 2);
            System.arraycopy(array, 0, tmp, 0, size);
            tmp[size] = element;
            array = tmp;
        } else {
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int capacity = array.length;
        if (capacity / 2 > size - 1) {
            capacity /= 2;
        }
        // Костя: если этот if несрабатывает, то мы зачамто пересоздаём массив такойже длинны
        T[] tmp = createArr(capacity);

        boolean after = false;

        // Костя: тут i надо сравнивать не с size а с size-1 (...)
        // Костя: ой я незаметил на 61ой строке size--
        for (int i = 0; i < size; i++) {
            if (i == index) {
                after = true;
                size--;
                continue;
            }

            if (after) {
                // Костя: (...) потомучто тут тогда будет IndexOutOfRange
                tmp[i] = array[i + 1];
            } else {
                tmp[i] = array[i];
            }

        }
        array = tmp;

        // Костя: тут нужен size--
        // Костя: ой я незаметил на 61ой строке size--
    }

    /**
     * Удалить первый элемент из списка с таким значением.
     *
     * @param element значение элемента для удаления.
     * @return был ли удалён такой элемент.
     */
    @Override
    public boolean remove(T element) {
        // Костя: почему механизм уменьшение капасити есть только в одном из двух ремувов
        T[] tmp = createArr(array.length);

        boolean after = false;

        for (int i = 0; i < size; i++) {
            if (!after && array[i].equals(element)) {
                after = true;
                size--;
                continue;
            }

            if (after) {
                tmp[i] = array[i + 1];
            } else {
                tmp[i] = array[i];
            }
        }
        array = tmp;

        // Костя: почему тут когда нету елемента просто возвращяется false, а не бросается эксепшен
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
        if (index < 0 || index >= size) {
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
        // Костя: кажется тут можно было быстрее, если использовать нативный contains у массива
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
