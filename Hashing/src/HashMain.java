
public class HashMain {

    /*
     * Program 10.1
       Write a program that takes in a number of integers and hashes them for storage into a 10 element array.
       Use a modulus hashing technique.  Upon a collision, probe right (higher indices) until an appropriate space is found.
       Print out the contents of the array for submission.  Use the following numbers: 64, 12, 84, 1, 31, 63, 99, 14, 38.

       Program 10.2
        Write Program 10.1 as described above. Add the following numbers as input into the program.
        If the array has no room, expand it by 50%, rehash the previous content and load the array.
        Use the following additional numbers: 77, 23, 61, 4.  Print out the contents of the array for submission.

       Program 10.3
       Write Program 10.2 as described above but modify it to expand and rehash multiple times.
       Use the following numbers to test the program (you do not need to do the testing of the other two versions as described).
       There is only one set of numbers to be run for submission.  After the numbers are loaded, print the contents of the array and submit it.
       The numbers are: 1, 4, 12, 14, 64, 84, 77, 23, 61, 99, 14, 63, 38, 88, 58, 28, 11.
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashIntSet h = new HashIntSet();

        h.add(1);
        h.add(4);
        h.add(12);
        h.add(14);
        h.add(64);
        h.add(84);
        h.add(77);
        h.add(23);
        h.add(61);
        h.add(99);
        h.add(14);
        h.add(63);
        h.add(38);
        h.add(88);
        h.add(58);
        h.add(28);
        h.add(11);

        h.printSet();

    }//end of main

}//end of class


