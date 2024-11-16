
public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        // Adding elements
        dynamicArray.add(30);
        dynamicArray.add(45);
        dynamicArray.add(33);
        dynamicArray.add(55);
        dynamicArray.display();


        dynamicArray.add(3, 50);
        dynamicArray.display();


        dynamicArray.remove(3);
        dynamicArray.display();

        // Getting an element
        System.out.println("Element at index 2: " + dynamicArray.get(2));

        // Display size
        System.out.println("Size: " + dynamicArray.size());
    }
}
