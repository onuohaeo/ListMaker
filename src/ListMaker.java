import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Please choose an option: [A|D|I|P|Q]", "[AaDdIiPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = SafeInput.getYNConfirm(scanner, "Are you sure that you want to quit? (Y/N): ");
                    break;
                default:
                    System.out.println("Invalid option, please try this again.");
                    break;
            }
        }
        System.out.println("Thank you for using the ListMaker!");
    }
    private static void displayMenu() {
        System.out.println("\nListMaker Menu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
        System.out.println("Current List:");
        printList();
    }
    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Please enter an item to add: ");
        list.add(item);
        System.out.println("Item added to the list.");
    }
    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. No items to delete.");
            return;
        }
        printList();
        int itemNumber = SafeInput.getRangedInt(scanner, "Please enter the item number to delete: ", 1, list.size()) - 1;
        list.remove(itemNumber);
        System.out.println("Item deleted from the list.");
    }
    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding item to the beginning.");
            addItem();
            return;
        }
        int position = SafeInput.getRangedInt(scanner, "Please enter the position to insert the new item (1 to " + (list.size() + 1) + "): ", 1, list.size() + 1) - 1;
        String item = SafeInput.getNonZeroLenString(scanner, "Please enter an item to insert: ");
        list.add(position, item);
        System.out.println("Item inserted into the list.");
    }
    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}