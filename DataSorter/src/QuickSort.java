import java.util.*;

public class QuickSort {

    public static void runQuickSort(List<Integer> data) {
        if (data.isEmpty()) { // check if list has no elements
            System.out.println("No data available."); // show message if empty
            return; // stop if no data
        }
        List<Integer> copy = new ArrayList<>(data); // make a copy of the list to keep original safe
        StepCounter counter = new StepCounter(); // track number of steps (comparisons)
        long start = System.nanoTime(); // start timer
        quickSort(copy, 0, copy.size() - 1, counter); // perform quick sort
        long end = System.nanoTime(); // end timer

        System.out.println("Quick Sort Result: " + copy); // show sorted list
        System.out.printf("Steps: %d, Time: %.6f seconds%n", counter.steps, (end - start) / 1e9); // show steps and time
    }

    public static void quickSort(List<Integer> arr, int low, int high, StepCounter counter) {
        if (low < high) { // check if there are at least two elements to sort
            int pi = partition(arr, low, high, counter); // get the pivot index after partitioning
            quickSort(arr, low, pi - 1, counter); // sort elements before pivot
            quickSort(arr, pi + 1, high, counter); // sort elements after pivot
        }
    }

    public static int partition(List<Integer> arr, int low, int high, StepCounter counter) {
        int pivot = arr.get(high); // choose last element as pivot
        int i = low - 1; // pointer for smaller elements

        for (int j = low; j < high; j++) { // loop through elements
            counter.steps++; // count this comparison
            if (arr.get(j) <= pivot) { // if current element is smaller or equal to pivot
                i++; // move pointer forward
                Collections.swap(arr, i, j); // swap elements
            }
        }
        Collections.swap(arr, i + 1, high); // place pivot in correct position
        return i + 1; // return pivot index
    }

    // helper class to count total steps
    public static class StepCounter {
        public int steps = 0; // keeps track of how many comparisons are made
    }
}
