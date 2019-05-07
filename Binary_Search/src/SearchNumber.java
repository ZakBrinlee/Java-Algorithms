import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SearchNumber {
    /*
     * Read a file (BS.txtPreview the documentView in a new window) of integers into an array list
     * so that it is sorted from lowest to highest.  Using console input allow a user to enter a number
     * to search for within the array list using a binary search using recursion (a must).
     * Your code (.java file) and console screenshot showing the execution need to be provided for
     * full credit.  Your program will determine if the number is found or not found; if found, the
     * index of the element it is in.  The following numbers should be used in testing your program
     * (all of these need to be turned in): 634, 4, 7532, 534, 2888, 45654, 555
     */

    public static void main(String[] args) throws FileNotFoundException
    {
        //take in file and read it
        String fileName = "BS.txt";
        Scanner file = new Scanner(new File(fileName));

        //initiate ArrayList for all numbers
        ArrayList<Integer> allNums = new ArrayList<Integer>();

        //Add all numbers to ArrayList
        while(file.hasNext())
        {
            int number = file.nextInt();
            allNums.add(number);
        }

        //Sort the ArrayList and printout for testing
        Collections.sort(allNums);


        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number you wish to search for: ");

        int search = sc.nextInt();
        int low = 0;
        int high = allNums.size() -1;

        binarySearch(allNums, search, low, high);

		/* Code used for quicker testing of the numbers
		 *
		System.out.println("This is a loop used only for testing");
		System.out.println();
		int testSearch [] = {634, 4, 7532, 534, 2888, 45654, 555};
		int low = 0;
		int high = allNums.size() -1;

		for (int i = 0; i < testSearch.length; i++)
		{
			int j = testSearch[i];
			binarySearch(allNums, j, low, high);
			System.out.println();
		}
		*/

        sc.close();

    }//end of main


    private static int binarySearch(ArrayList<Integer> allNums, int search, int low, int high)
    { //base case

        if (low > high)
        {
            System.out.println(search + " was not found");
            return -1;
        }

        int mid = (low + high) / 2;

        // core logic is same as iterative algorithm
        if (allNums.get(mid).equals(search))
        {
            System.out.println(search + " was found at index " + mid);
            return mid;
        }
        else if (allNums.get(mid) < search)
        {
            return binarySearch(allNums, search, mid + 1, high);
        }
        else
        { // last possibility: a[mid] > x
            return binarySearch(allNums, search, low, mid -1);
        }

    }//end of binarySearch

}//end of class
