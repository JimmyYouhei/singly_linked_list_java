package com.jimmyyouhei.singly_linked_list;

public class Main {

    public static void main(String[] args) {
        // a simple test below please write your own test
        SinglyLinkedList test = new SinglyLinkedList();
        test.insertToLast(1);
        test.insertToLast(2);
        test.insertToLast(3);
        test.insertToLast(4);
        test.insertToFirst(0);

        test.printNode();
    }
}
