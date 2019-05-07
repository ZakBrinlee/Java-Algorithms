public class ReverseLinked {

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(list.toString());
        System.out.println();

        LinkedList list2 = list;

        list2.reverseList(list);

        System.out.println(list2);

    }//end of main

}//end of class
