package com.dsa.linkedlists;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 */
public class FindNthToLastElement {

    /**
     * 2 pointers approach for singly linked-list
     *
     * @param head header node
     * @return Nth Node from the last
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public Node getNthToLastElementInLinkedList(Node head, int n) {
        Node pointer1;
        Node pointer2;

        pointer1 = head;
        pointer2 = head;
        int count = n;
        if (count == 0) {
            return head;
        }
        while (count > 0 && pointer1 != null) {
            pointer1 = pointer1.next;
            count--;
        }
        while (pointer1 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        Node head = node;

        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        head.appendToTail(7);
        head.appendToTail(8);
        head.appendToTail(9);

        FindNthToLastElement f = new FindNthToLastElement();
        Node n = f.getNthToLastElementInLinkedList(head, 2);
        System.out.println(n.data);
    }
}
