import java.util.Scanner;
import java.util.Stack;

public class PalindromeTest {
    /*
     * A palindrome is a word that reads the same forwards as backwards.
     * The words tot, madam and racecar are palindromes;
     * the words tote and Racer are not.
     * Complete the PalindromeTestWrapper method so that it reads a string from the user,
     * calls isPalindrome to determine if it is a palindrome and displays an appropriate message.
     * Your program must allow the user to repeatedly enter strings.
     *
     * Complete the isPalindrome method so that it returns true if s is a palindrome and false if it isn�t.
     * You must use a stack in your solution algorithm.
     * You must use the Java API class util.Stack<E> in your coding.
     */

    final static String isMsg = " IS a palindrome";
    final static String isNotMsg = " is NOT a palindrome";

    public static void main(String[] args)
    {
        String choice = "y";
        String testWord;
        Scanner sc = new Scanner (System.in);

        System.out.println("Welcome to the Palidrome tester!");

        System.out.println();

        while(choice.equalsIgnoreCase("y"))
        {
            System.out.println("Please enter the word you wish to test: ");
            testWord = sc.nextLine().toLowerCase();


            isPalindrome(testWord);

            System.out.println();
            System.out.println("Would you like to test another word? (y/n): " );
            choice = sc.nextLine();
        }//end of while loop

        System.out.println("Thank you for using our Palidrome app");
        sc.close();

    }//end of main

    public static Boolean isPalindrome( String s){

        String input = s;
        String palindromeString = "";
        Stack<Character> word = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char letter =input.charAt(i);
            word.push(letter);
        }


        while(!word.isEmpty())
        {
            palindromeString = palindromeString + word.pop();
        }


        if(input.equals(palindromeString))
        {
            System.out.println(input + isMsg);
            return true;
        }
        else
        {
            System.out.println(input + isNotMsg);
            return false;
        }

    }//end of isPalindrome

}//end of class
