public class Sorts_Compare {

    // arguments are passed using the text field below this editor
    public static void main(String[] args)
    {
    /*
    //generate an array of 100,000 integers
	int[] numbers = new int[100000];
	for (int i = 0; i < numbers.length; i++) {
		numbers[i] = getRandomInt();
	}//end of for loop


    //test for correct number in array
    int count = 1;
    for(int rand : numbers){

     System.out.println(count + ": " + rand);
      count++;
    }
    */


        System.out.println(shellSort());
        System.out.println(insertionSort());
        System.out.println(selectionSort());

    }//end of main

    public static int getRandomInt() {
        return 1 + (int)(Math.random() * 100000);
    }//end of getRandomInt()



    /* function to sort arr using shellSort */
    public static String shellSort()
    {
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = getRandomInt();
        }//end of for loop

        //start timer
        long startTime = System.currentTimeMillis();
        int n = numbers.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = numbers[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap)
                    numbers[j] = numbers[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                numbers[j] = temp;
            }
        }
        //end timer and calculate
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        String message = "Execution time inside the Shell Sort in milliseconds: "
                + executionTime;
        return message;
    }//end of shellSort

    /*Function to sort array using insertion sort*/
    public static String insertionSort()
    {
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = getRandomInt();
        }//end of for loop

        //start timer
        long startTime = System.currentTimeMillis();
        int n = numbers.length;

        for (int i=1; i<n; ++i)
        {
            int key = numbers[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && numbers[j] > key)
            {
                numbers[j+1] = numbers[j];
                j = j-1;
            }
            numbers[j+1] = key;
        }//end of for

        //end timer and calculate
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        String message = "Execution time inside the Insertion Sort in milliseconds: "
                + executionTime;
        return message;
    }//end of insertionSort

    public static String selectionSort()
    {
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = getRandomInt();
        }//end of for loop

        //start timer
        long startTime = System.currentTimeMillis();
        int n = numbers.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (numbers[j] < numbers[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = numbers[min_idx];
            numbers[min_idx] = numbers[i];
            numbers[i] = temp;
        }

        //end timer and calculate
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        String message = "Execution time inside the Selection Sort in milliseconds: "
                + executionTime;
        return message;
    }//end of selectionSort

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}//end of class
