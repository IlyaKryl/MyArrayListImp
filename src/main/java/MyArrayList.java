public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;
    private int index;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
    }
}
