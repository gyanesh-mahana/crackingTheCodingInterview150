package com.dsa.linkedlists;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
 * only access to that node.
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class DeleteNodeInMiddle {

    /**
     * Reach to the middle of the list using double pointer
     * where second pointer moves 2 nodes and first pointer moves 1 node ata time
     *
     * @param head head node to the singly linked list
     *             <p>
     *             <p>
     *             Time Complexity: O(N)
     *             Space Complexity: O(1)
     */
    public void deleteMiddleNodeApproach1(Node head) {
        Node pointer1;
        Node pointer2;
        Node prev;
        pointer1 = head;
        pointer2 = head;
        prev = head;

        if (head == null || head.next == null) {
            return;
        }

        while (pointer2 != null && pointer2.next != null) {
            prev = pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }

        prev.next = pointer1.next;

    }


    public void deleteMiddleNodeApproach2(Node head) {
        Node pointer1;
        Node pointer2;
        pointer1 = head;
        pointer2 = head;

        if (head == null || head.next == null) {
            return;
        }

        while (pointer2 != null && pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        pointer1.data = pointer1.next.data;
        pointer1.next = pointer1.next.next;

    }

    public static void main(String[] args) {

        DeleteNodeInMiddle dn = new DeleteNodeInMiddle();

        Node head = new Node(1);

        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        head.appendToTail(7);
        head.appendToTail(8);
        head.appendToTail(9);
        dn.deleteMiddleNodeApproach1(head);
        head.printLinkedList();
        dn.deleteMiddleNodeApproach2(head);
        head.printLinkedList();
    }
}
