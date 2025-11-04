import java.util.*;

public class MergeSort {

    public static void runMergeSort(List<Integer> data) {
        if (data.isEmpty()) { // check if list is empty
            System.out.println("No data available."); // show message if no numbers
            return; // stop if no data to sort
        }
        List<Integer> copy = new ArrayList<>(data); // make a copy of the list
        StepCounter counter = new StepCounter(); // track how many steps the sort takes
        long start = System.nanoTime(); // start timing
        List<Integer> sorted = mergeSort(copy, counter); // perform merge sort
        long end = System.nanoTime(); // end timing

        System.out.println("Merge Sort Result: " + sorted); // show sorted result
        System.out.printf("Steps: %d, Time: %.6f seconds%n", counter.steps, (end - start) / 1e9); // show steps and time
    }

    public static List<Integer> mergeSort(List<Integer> arr, StepCounter counter) {
        if (arr.size() <= 1) return arr; // base case: one element is already sorted
        int mid = arr.size() / 2; // find the middle of the list
        List<Integer> left = new ArrayList<>(arr.subList(0, mid)); // left half
        List<Integer> right = new ArrayList<>(arr.subList(mid, arr.size())); // right half
        return merge(mergeSort(left, counter), mergeSort(right, counter), counter); // sort and merge halves
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right, StepCounter counter) {
        List<Integer> result = new ArrayList<>(); // list to hold sorted elements
        int i = 0, j = 0; // indexes for left and right lists

        while (i < left.size() && j < right.size()) { // loop until one list is empty
            counter.steps++; // count this comparison
            if (left.get(i) <= right.get(j)) { // take smaller value from left
                result.add(left.get(i++)); // add it and move to next left element
            } else { // otherwise, take from right
                result.add(right.get(j++)); // add it and move to next right element
            }
        }
        result.addAll(left.subList(i, left.size())); // add remaining left elements
        result.addAll(right.subList(j, right.size())); // add remaining right elements
        return result; // return merged sorted list
    }

    // helper class to count steps made during sorting
    public static class StepCounter {
        public int steps = 0; // stores total steps
    }
}
