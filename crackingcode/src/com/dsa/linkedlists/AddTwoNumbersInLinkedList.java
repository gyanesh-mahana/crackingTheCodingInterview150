package com.dsa.linkedlists;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of
 * <p>
 * the list. Write a function that adds the two numbers and returns the sum as a linked
 * list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 */
public class AddTwoNumbersInLinkedList {


    /**
     * add two numbers in the form of singly linked list
     *
     * @param head1 head of first number linked list
     * @param head2 head of second number linked list
     * @return result linked list
     */
    public LinkedList addTwoNumbers(LinkedList head1, LinkedList head2) {
        LinkedList result = new LinkedList();
        Node num1 = head1.head;
        Node num2 = head2.head;
        int data = 0;
        while (num1 != null && num2 != null) {
            data = data + num1.data + num2.data;
            result.append(data % 10);
            data = data / 10;
            num1 = num1.next;
            num2 = num2.next;
        }

        //condition if any of the numbers is of different size
        while (num1 != null) {
            data = data + num1.data;
            result.append(data % 10);
            data = data / 10;
            num1 = num1.next;
        }
        while (num2 != null) {
            data = data + num2.data;
            result.append(data % 10);
            data = data / 10;
            num2 = num2.next;
        }
        //add an extra node for the data remainder after addition
        if (data > 0) {
            result.append(data);
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbersInLinkedList an = new AddTwoNumbersInLinkedList();
        LinkedList num1 = new LinkedList();
        num1.append(9);
        num1.append(2);
        num1.append(2);
        num1.append(9);

        LinkedList num2 = new LinkedList();
        num2.append(1);
        num2.append(7);
        num2.append(7);
        num2.append(7);

        LinkedList res = an.addTwoNumbers(num1, num2);
        res.print();
    }
}
