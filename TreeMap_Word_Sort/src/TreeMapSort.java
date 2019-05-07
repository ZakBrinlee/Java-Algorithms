import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSort {

    /*
     * Using the file agile_manifesto.txt Preview the documentView in a new window, construct a Java program that read the file
     * (please note there are multiple words on multiple lines-consider whitespace as a token delimiter).
     * Use a data structure of your own choosing to store the words and how many times they are used..
     * After reading and storing the file, print out all of the words in alphabetical order and how many times they are used.
     * Then print out all the words in order by the number of times they are used.  Finally, provide a short report on why you
     * used the data structure you used.  I want you to tell me why you picked the data structure you did.
     */

    public static void main(String[] args)
    {

        String fileName = "agile_manifesto.txt";

        //using a try/catch in case of no file
        try {

            //reads text files in the default encoding.
            Scanner sc = new Scanner(new File(fileName));

            Map<String, Integer> textWords = new TreeMap<String, Integer>();
            ValueComparator vc = new ValueComparator(textWords);

            //will use ValueComparator while populating TreeMap
            Map<String, Integer> sortedWord = new TreeMap<String, Integer>(vc);;

            while(sc.hasNext())
            {
                String word = sc.next();
                if (textWords.containsKey(word)) {
                    //increase count by 1 if word is seen
                    Integer count = textWords.get(word);
                    textWords.put(word.trim().toLowerCase().replaceAll("\\p{Punct}+", ""), count + 1);
                }
                else
                {
                    //new word found
                    textWords.put(word.trim().toLowerCase().replaceAll("\\p{Punct}+", ""), 1);
                }
            }//end of while


            System.out.println("Words alphabetically:");

            Set set = textWords.entrySet();
            Iterator iter = set.iterator();
            //prints each word in alphabetical order by key(word)
            while(iter.hasNext())
            {
                Map.Entry me = (Map.Entry)iter.next();
                System.out.println(me.getKey() + ": " + me.getValue());
            }

            //put all for textWords into sortedWords
            sortedWord.putAll(textWords);

            //extra line for cleaner look
            System.out.println();
            System.out.println("Words by occurance:");

            Set set2 = sortedWord.entrySet();
            Iterator j = set2.iterator();
            //loop through and start with the highest occurrence
            while(j.hasNext())
            {
                Map.Entry me2 = (Map.Entry)j.next();
                System.out.println(me2.getValue() + ": " + me2.getKey());
            }

            sc.close();

        }//end of try


        catch(FileNotFoundException ex)
        {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }//end of catch
        catch(IOException ex)
        {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }//end of catch


    }//end of main
}//end of class

class ValueComparator implements Comparator<String>
{
    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base)
    {
        this.base = base;
    }// end of ValueComparator


    public int compare(String a, String b)
    {
        if (base.get(a) >= base.get(b))
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }//end of compare
}//end of valueComparator
