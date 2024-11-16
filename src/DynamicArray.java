import java.util.Arrays;

public class DynamicArray<T> {
    private T[] array;
    private int size;

    // Constructor
    public DynamicArray() {
        array = (T[]) new Object[2]; // Initial capacity
        size = 0;
    }

    // Add element at the end
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    // Add element at a specific index
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    // Remove element at a specific index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        shrinkCapacity();
        return removedElement;
    }

    // Get element at a specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    // Return the current size of the array
    public int size() {
        return size;
    }

    // Display all elements
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private void shrinkCapacity() {
        if (size > 0 && size <= array.length / 4) {
            array = Arrays.copyOf(array, array.length / 2);
        }
    }
}