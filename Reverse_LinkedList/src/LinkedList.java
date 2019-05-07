public class LinkedList {

    public static ListNode head;

    public LinkedList()
    {
        head = null;
    }//end LinkedList

    public String toString()
    {
        if(head == null)
        {
            return "[]";
        }
        else
        {
            String result = "[" + head.data;
            ListNode current = head.next;

            while(current != null)
            {
                result += " -> " + current.data;
                current = current.next;
            }//end of while

            result += "]";
            return result;
        }//end of else
    }//end of toString

    public void add(int data)
    {
        if(head == null)
        {
            head = new ListNode(data);
        }
        else
        {
            ListNode current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = new ListNode(data);
        }
    }//end of add

    public void reverseList(LinkedList list)
    {

        ListNode currNode = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;

    } //end of reverse node

}//end of LinkedList class
