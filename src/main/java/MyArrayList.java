import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elementData;
    private int size;

    public MyArrayList() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void resize() {
        if (size == elementData.length - 1) {
            elementData = Arrays.copyOf(elementData, (elementData.length / 2) + elementData.length);
        }
    }

    public void add(E element) {
        resize();

        elementData[size++] = element;
    }

    public void add(E element, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        resize();

        size++;

        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        elementData[index] = element;
    }

    public void delete(E element) {
        for (int i = 0; i < elementData.length; i++) {
            E obj = elementData[i];

            if (obj.equals(element)) {
                int lengthOfCopyElements = size - i - 1;
                if (lengthOfCopyElements > 0) {
                    System.arraycopy(elementData, i + 1, elementData, i, lengthOfCopyElements);
                }
                elementData[size--] = null;
                break;
            }
        }
    }

    public void sort(Comparator<E> comparator) {
        recursionMergeSort(elementData, 0, size - 1, comparator);
    }

    private void recursionMergeSort(E[] array, int start, int finish, Comparator<E> comparator) {

        if (array.length == 0)
            return;

        if (start == finish) // выход из рекурсии - массив из 1 элемента отсортирован по определению
            return;

        int mid = (start + finish) / 2; // середина массива

        recursionMergeSort(array, start  , mid, comparator);    // сортировка 1-й половины массива
        recursionMergeSort(array,mid + 1, finish, comparator); // сортировка 2-й половины массива
        merge(array, start, finish, comparator);
    }

    private void merge(E[] array, int begin, int end, Comparator<E> comparator) {
        int mid = (begin + end) / 2;

        E[] tmp = (E[]) new Object[end - begin + 1];

        int leftMarker = begin;

        int rightMarker = mid + 1;

        int cursor = 0;

        while ((leftMarker <= mid) || (rightMarker <= end)) {
            if (leftMarker > mid) {                     //если левый массив полностью записан
                tmp[cursor++] = array[rightMarker++];   //записываем остаток правого массива
                continue;                               //возвращаемся в цикл
            }
            if (rightMarker > end) {                    //если правый массив полностью записан
                tmp[cursor++] = array[leftMarker++];    //записываем остаток левого массива
                continue;                               //возвращаемся в цикл
            }
            if (comparator.compare(array[leftMarker], array[rightMarker]) < 0) {   //сравниваем элементы левого и правого массива
                tmp[cursor++] = array[leftMarker++];        //и записываем наименьший во временный массив
            } else {
                tmp[cursor++] = array[rightMarker++];
            }
        }
        System.arraycopy(tmp, 0, array, begin, end - begin + 1);
//        System.out.println(Arrays.toString(tmp));
    }

    public E get(int index) {
        return elementData[index];
    }

}
