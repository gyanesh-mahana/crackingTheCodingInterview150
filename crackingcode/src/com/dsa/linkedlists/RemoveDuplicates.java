package com.dsa.linkedlists;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicates {

    /**
     * remove Duplicate node by iterating through the nodes
     *
     * @param head header to the Linked List
     * @return Time Complexity O(N^2)
     * Space Complexity O(1)
     */
    public Node removeDuplicatesApproach1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * take start node
         * compares all the nodes from the next ones
         * if data matches delete the node
         * else move forward
         */
        Node start = head;
        while (start != null) {
            Node prevNode = start;
            Node nextNode = start.next;
            while (nextNode != null) {
                if (nextNode.data == start.data) {
                    //remove nextNode
                    prevNode.next = nextNode.next;
                    nextNode = nextNode.next;
                } else {
                    prevNode = nextNode;
                    nextNode = nextNode.next;
                }
                if (nextNode == null) {
                    break;
                }
            }
            start = start.next;
        }
        return head;
    }


    /**
     * Using HashMap for the solution
     *
     * @param head
     * @return
     */
    public Node removeDuplicatesApproach2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashMap<Integer, Integer> nodeMap = new LinkedHashMap<Integer, Integer>();
        Node temp = head;
        while (temp != null) {
            if (nodeMap.containsKey(temp.data)) {
                //this will remove from initial occurrence and keep the last instance of the Node
                head = head.deleteNode(head, temp.data);
            } else {
                nodeMap.put(temp.data, 1);
            }
            temp = temp.next;
        }
        return head;
    }

    /**
     * Using Hashtable for the solution to track the duplicate nodes
     *
     * @param head is header of the Linked List
     * @return head of the Linked List
     * <p>
     * Time Complexity O(N)
     * Space Complexity O(M=unique nodes)
     */
    public Node removeDuplicatesApproach3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Hashtable<Integer, Boolean> nodeMap = new Hashtable<Integer, Boolean>();
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (nodeMap.containsKey(temp.data)) {
                prev.next = temp.next;
            } else {
                nodeMap.put(temp.data, true);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    /**
     * Remove Duplicates without using extra space
     *
     * @param head of the Linked List
     * @return head of the Linked List after duplicates are removed
     */
    public Node removeDuplicatesApproach4(Node head) {

        if (head == null) {
            return head;
        }
        Node prev = head;
        Node current = prev.next;
        while (current != null) {
            Node runner = head;
            while (runner != current) {
                if (runner.data == current.data) {
                    prev.next = current.next;
                    current = current.next;
                    break;
                }
                runner = runner.next;
            }
            if (runner == current) {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);

        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(5);
        head.appendToTail(5);
        head.appendToTail(6);
        head.appendToTail(3);
        head.appendToTail(2);


        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("------------------------");
        RemoveDuplicates rd = new RemoveDuplicates();
        head = rd.removeDuplicatesApproach4(head);
        temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }
}
