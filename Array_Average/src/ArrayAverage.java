import java.util.Scanner;

public class ArrayAverage {

    /*	Zak Brinlee 10/3/2017
     * Assignment Program 1 for AD 300, NSC
     * This program will ask the user to enter 10 integers and populate an array with the integers
     * Program will then display the average and ask the user if they would like to restart the
     * program. Also will not accept non integers.
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] numbers;
        int sum = 0;
        numbers = new int[10];
        String choice = "y";

        while(choice.equalsIgnoreCase("y"))
        {
            //request input
            System.out.println("Please enter 10 integers for processing: ");

            try{
                //loop through input and populate array
                for(int i = 0; i < numbers.length; i++)
                {
                    numbers[i] = sc.nextInt();
                    sum += numbers[i];

                }//end of for loop

                //declare the average then must cast as a double
                double avg = (double)sum / numbers.length;

                //print output of average
                System.out.println("Average of the numbers you entered: " + avg);

                //line for cleaner look
                System.out.println();

                System.out.print("Try again? (Y/N): ");
                choice = sc.next();

                //line for cleaner look
                System.out.println();
            }//end of try

            catch(Exception e)
            {
                System.out.println("Please enter a valid integer");
                sc.next();
                continue;
            }//end of catch

        }//end of while loop

        System.out.println("Bye!");
        System.exit(0);
        sc.close();
    }//end of main
}//end of class
