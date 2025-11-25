import java.util.Scanner;

public class homework20_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList llist = new LinkedList();

        System.out.println("Enter 5 numbers in sorted order:");
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            insertSorted(llist, num);  // insert in order
        }

        System.out.println("Original list: " + llist);
        deleteDuplicates(llist);
        System.out.println("After removing duplicates: " + llist);
    }

    // Function to insert a node in a sorted linked list
    public static void insertSorted(LinkedList llist, int value) {
        ListNode newNode = new ListNode(value);
        if (llist.head == null || value <= llist.head.value) {
            newNode.next = llist.head;
            llist.head = newNode;
            return;
        }
        ListNode current = llist.head;
        while (current.next != null && current.next.value < value) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Function to delete consecutive duplicates
    public static void deleteDuplicates(LinkedList llist) {
        ListNode current = llist.head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next; // skip duplicate
            } else {
                current = current.next;
            }
        }
    }
}

class ListNode {
    int value;
    ListNode next;
    ListNode(int v) { value = v; }
}

class LinkedList {
    ListNode head;

    public String toString() {
        String nodeData = "";
        ListNode ref = head;
        while (ref != null) {
            nodeData += ref.value + "-->";
            ref = ref.next;
        }
        return "head-->" + nodeData + "null";
    }
}
