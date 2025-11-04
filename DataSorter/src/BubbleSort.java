import java.util.*;

public class BubbleSort {

    public static void runBubbleSort(List<Integer> data) {
        if (data.isEmpty()) { // check if list is empty
            System.out.println("No data available."); // show message if no data
            return; // stop running if empty
        }

        List<Integer> copy = new ArrayList<>(data);
        long start = System.nanoTime(); // start timer
        int steps = bubbleSort(copy); // run bubble sort and count steps
        long end = System.nanoTime(); // end timer

        System.out.println("Bubble Sort Result: " + copy); // show sorted result
        System.out.printf("Steps: %d, Time: %.6f seconds%n", steps, (end - start) / 1e9); // show steps and time
    }

    public static int bubbleSort(List<Integer> arr) {
        int steps = 0; // count comparisons
        int n = arr.size(); // get number of elements

        for (int i = 0; i < n - 1; i++) { // outer loop for each pass
            for (int j = 0; j < n - i - 1; j++) { // inner loop to compare neighbors
                steps++; // increase step count
                if (arr.get(j) > arr.get(j + 1)) { // check if elements are out of order
                    Collections.swap(arr, j, j + 1); // swap them if needed
                }
            }
        }
        return steps; // return how many steps were made
    }
}
