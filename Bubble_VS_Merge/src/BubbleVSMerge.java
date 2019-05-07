import java.util.Arrays;

public class BubbleVSMerge {
    /*
     * Program 5 is actually two programs. The first, Program 5.1 is a bubble sort
     * (33 points). The second, 5.2 is a merge sort (67 points). You are also going
     * to insert timing logic in to see how the two program compare.
     *
     * Sort time is calculated the same for both methods. Start time -> call method -> end time
     */
    public static void main(String[] args) {

        //Initialize lists and get size
        int bubbleList[] = { 24, 87, 3, 99, 12, 55, 18, 73, 42, 8 };
        int mergeList[] = { 24, 87, 3, 99, 12, 55, 18, 73, 42, 8 };
        int size = bubbleList.length;

        System.out.println("Unsorted lists: \n" + Arrays.toString(bubbleList) + "\n" + Arrays.toString(mergeList) + "\n");

        //get start time, call function, get end time, calculated total time
        long startTimeB = System.nanoTime();
        bubbleSort(bubbleList, size);
        long endTimeB = System.nanoTime();

        long totalTimeB = endTimeB - startTimeB;

        //Print out information same for both methods
        System.out.println("List sorted by Bubble Sort function " + Arrays.toString(bubbleList));
        System.out.println("This Bubble Sort took " + totalTimeB + " Nanoseconds to complete");

        // space between methods for cleaner look
        System.out.println();

        //get start time, call function, get end time, calculated total time
        long startTimeM = System.nanoTime();
        mergeSort(mergeList, 0, size);
        long endTimeM = System.nanoTime();

        long totalTimeM = endTimeM - startTimeM;

        //Print out information same for both methods
        System.out.println("List sorted by Merge Sort function " + Arrays.toString(mergeList));
        System.out.println("This Merge Sort took " + totalTimeM + " Nanoseconds to complete");
    }// end of main

    public static void bubbleSort(int[] list, int size) {

        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

    }// end of bubbleSort

    public static void mergeSort(int[] list, int low, int high) {

        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N / 2;

        // recursively sort
        mergeSort(list, low, mid);
        mergeSort(list, mid, high);

        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) {
            if (i == mid)
                temp[k] = list[j++];
            else if (j == high)
                temp[k] = list[i++];
            else if (list[j] < list[i])
                temp[k] = list[j++];
            else
                temp[k] = list[i++];
        } // end of for
        for (int k = 0; k < N; k++)
            list[low + k] = temp[k];

    }// end of mergeSort

}// end of class
