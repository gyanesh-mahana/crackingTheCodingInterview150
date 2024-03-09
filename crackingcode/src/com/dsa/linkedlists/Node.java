package com.dsa.linkedlists;

/**
 * Node class to implement the Linked List
 */
public class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void appendToTail(int data) {
        Node end = new Node(data);
        Node temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = end;
    }

    public Node deleteNode(Node head, int data) {

        Node temp = head;
        if (temp.data == data) {
            return head.next;
        }
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
}
