package collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       AddCollection addCollection = new AddCollection();
       AddRemovable addRemovableCollection = new AddRemoveCollection();
       MyList myList = new MyListImpl();
       String[] input = scanner.nextLine().split(" ");
       int count = Integer.parseInt(scanner.nextLine());
       addElements(input, addCollection);
       addElements(input, addRemovableCollection);
       addElements(input, myList);
        printRemoved(count, addRemovableCollection);
        printRemoved(count, myList);
    }
    private static void addElements(String[] input, Addable collection) {
        for (String s : input) {
            System.out.print(collection.add(s) + " ");
        }
        System.out.println();
    }

    private static void printRemoved(int count, AddRemovable collection) {
        for (int i = 0; i < count ; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
