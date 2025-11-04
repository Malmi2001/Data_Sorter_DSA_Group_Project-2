import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);  // Scanner object to read user input
    static List<Integer> data = new ArrayList<>();    // List to store the data to be sorted

    public static void main(String[] args) {
        // Infinite loop to keep showing the menu until the user decides to exit
        while (true) {
            // Display the menu options to the user
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");  // Prompt user for input

            // Get the user's choice as a string
            String choice = scanner.nextLine();

            // Switch statement to handle different menu options
            switch (choice) {
                case "1" -> DataHandler.enterNumbersManually(scanner, data);  // Option 1: Enter numbers manually
                case "2" -> DataHandler.generateRandomNumbers(scanner, data);  // Option 2: Generate random numbers
                case "3" -> BubbleSort.runBubbleSort(data);  // Option 3: Perform Bubble Sort
                case "4" -> MergeSort.runMergeSort(data);  // Option 4: Perform Merge Sort
                case "5" -> QuickSort.runQuickSort(data);  // Option 5: Perform Quick Sort
                case "6" -> DataHandler.compareAll(data);  // Option 6: Compare all algorithms and display performance
                case "7" -> {  // Option 7: Exit the program
                    System.out.println("Exiting program. Goodbye!");  // Display exit message
                    return;  // Exit the program
                }
                default -> System.out.println("Invalid choice. Please try again.");  // Handle invalid input
            }
        }
    }
}
