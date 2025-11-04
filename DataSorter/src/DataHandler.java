import java.util.*;

public class DataHandler {

    // --- Input and Random Generation ---

    // Method to enter numbers manually from the user
    public static void enterNumbersManually(Scanner scanner, List<Integer> data) {
        System.out.print("Enter numbers separated by spaces: ");
        try {
            // Read input as a single string, then split it into individual numbers
            String[] tokens = scanner.nextLine().trim().split("\\s+");

            // Clear any previous data before adding the new input
            data.clear();

            // Convert each string token into an integer and add it to the data list
            for (String token : tokens) {
                data.add(Integer.parseInt(token));
            }

            // Print the loaded data to confirm it was successfully entered
            System.out.println("Data loaded successfully: " + data);
        } catch (NumberFormatException e) {
            // If the user enters something that isn't an integer, show an error
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    // Method to generate random numbers based on user input
    public static void generateRandomNumbers(Scanner scanner, List<Integer> data) {
        System.out.print("Enter number of elements: ");
        try {
            // Read the desired size for the random number list
            int size = Integer.parseInt(scanner.nextLine());

            // If the size is non-positive, show an error and exit
            if (size <= 0) {
                System.out.println("Please enter a positive number.");
                return;
            }

            // Initialize random number generator
            Random rand = new Random();

            // Clear any existing data before generating new random numbers
            data.clear();

            // Add random numbers (between 0 and 99) to the data list
            for (int i = 0; i < size; i++) {
                data.add(rand.nextInt(100));  // Random number between 0 and 99
            }

            // Show the generated data
            System.out.println("Generated data: " + data);
        } catch (NumberFormatException e) {
            // If the user enters something that isn't an integer, show an error
            System.out.println("Invalid size. Please enter a valid integer.");
        }
    }

    // --- Comparison Table ---

    // Method to compare the performance of all sorting algorithms
    public static void compareAll(List<Integer> data) {
        if (data.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        // Create a map to store the results of each sorting algorithm
        Map<String, Performance> results = new LinkedHashMap<>();

        // --- Bubble Sort ---
        List<Integer> copy1 = new ArrayList<>(data);  // Copy data to prevent modifying the original
        long start1 = System.nanoTime();  // Start the timer
        int steps1 = BubbleSort.bubbleSort(copy1);  // Perform the bubble sort and count steps
        long end1 = System.nanoTime();  // Stop the timer
        results.put("Bubble Sort", new Performance(steps1, (end1 - start1) / 1e9));  // Store result

        // --- Merge Sort ---
        List<Integer> copy2 = new ArrayList<>(data);  // Copy data to prevent modifying the original
        MergeSort.StepCounter counter2 = new MergeSort.StepCounter();  // Step counter for merge sort
        long start2 = System.nanoTime();  // Start the timer
        MergeSort.mergeSort(copy2, counter2);  // Perform the merge sort
        long end2 = System.nanoTime();  // Stop the timer
        results.put("Merge Sort", new Performance(counter2.steps, (end2 - start2) / 1e9));  // Store result

        // --- Quick Sort ---
        List<Integer> copy3 = new ArrayList<>(data);  // Copy data to prevent modifying the original
        QuickSort.StepCounter counter3 = new QuickSort.StepCounter();  // Step counter for quick sort
        long start3 = System.nanoTime();  // Start the timer
        QuickSort.quickSort(copy3, 0, copy3.size() - 1, counter3);  // Perform the quick sort
        long end3 = System.nanoTime();  // Stop the timer
        results.put("Quick Sort", new Performance(counter3.steps, (end3 - start3) / 1e9));  // Store result

        // --- Display Results ---
        System.out.println("\n--- Sorting Performance Comparison ---");
        System.out.printf("%-15s %-12s %-12s%n", "Algorithm", "Steps", "Time (s)");  // Print table headers
        System.out.println("-----------------------------------------------");

        // Iterate over the results map and display each algorithm's performance
        for (Map.Entry<String, Performance> entry : results.entrySet()) {
            System.out.printf("%-15s %-12d %-12.6f%n",
                    entry.getKey(), entry.getValue().steps, entry.getValue().time);
        }
    }

    // Helper class to store performance details (steps and time)
    public static class Performance {
        int steps;  // Number of steps the algorithm took
        double time;  // Time in seconds it took to complete

        // Constructor to initialize the performance data
        Performance(int steps, double time) {
            this.steps = steps;
            this.time = time;
        }
    }
}
