import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {

    /*
     * Zak Brinlee 10/9/2017 Assignment Program 1 for AD 300, NSC This program
     * 1) input values from a file called words.txt (see here: words.txtPreview
     * the documentView in a new windowPreview the documentView in a new window)
     * The file consists of multiple records of multiple words. 2) read all of
     * the words into one ArrayList 3) interrogate the ArrayList and remove all
     * duplicate words. 4) display the ArrayList with all duplicate words
     * removed.
     */

    public static void main(String[] args) {
        String fileName = "words.txt";


        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> allWords = new ArrayList<String>();
            ArrayList<String> remWords = new ArrayList<String>();

            Scanner sc = new Scanner(bufferedReader);

            // Add each word to arrayList
            while (sc.hasNext())
            {
                String word = sc.next();
                allWords.add(word);
            } // end of while

            // casting toArray() for cleaner look
            allWords.toArray();

            // must be object to compare word to word
            Object[] second = allWords.toArray();
            for (Object s : second)
            {
                if (allWords.indexOf(s) != allWords.lastIndexOf(s))
                {
                    remWords.add((String) s);
                    allWords.remove(allWords.lastIndexOf(s));
                }
            }

            System.out.println("List of all words: " + "\n" + allWords + "\n");

            allWords.removeAll(remWords);

            System.out.println("New list of unique words: " + "\n" + allWords);
            sc.close();
        } // end of try

        catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } // end of catch

    }// end of main
}//end of class
