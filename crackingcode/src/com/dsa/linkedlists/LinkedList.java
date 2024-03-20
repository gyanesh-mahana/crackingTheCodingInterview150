package com.dsa.linkedlists;

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void append(int data) {
        Node end = new Node(data);
        Node temp = head;
        if (head == null) {
            head = end;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = end;
    }

    public Node delete(int data) {

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


    public void print() {
        Node temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");

    }
}
