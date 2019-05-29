package com.jimmyyouhei.singly_linked_list;

// my own class of Singly Linked List which also included its own nested Node class
public class SinglyLinkedList {
    // variable to keep check of how many Nodes
    private int count = 0;
    // the head pointer of the LinkedList
    private Node head;
    // the tail pointer of the LinkedList
    private Node tail;

    
    // method to get head pointer in return
    public Node getHead() {
        return head;
    }

    // method to get tail pointer in return
    public Node getTail() {
        return tail;
    }

    // an empty constructor
    public SinglyLinkedList() {

    }

    // return the number of Nodes in the list
    public int countNode() {
        return count;
    }

    // print out the Node value at the specific position
    public void peekAtPosition(int position){

        // try catch to handle if there is nop such value at the position
        try {
            // if the position <0 will throw exeption
            if (position<0){
                throw new NullPointerException("there is no such position");
            }
            //will loop through the list to find the Node
            Node targetNode = this.head;
            for (int i = 0 ; i< position ; i++){
                targetNode = targetNode.getNextNode();
            }
            // print out the node value if found
            System.out.println(targetNode.toString());
            //handle if no position exist
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    // method to remove first node
    public void removeFirstNode(){
        //assign a temporary node pointer to the current head Node
        Node nodeToRemove = this.head;
        // the head node will point to the second Node
        this.head = this.head.getNextNode();
        // set the pointer of removed node to null to avoid memory leak
        nodeToRemove.setNextNode(null);
        // decrease count
        count--;
    }

    // method to remove last node
    public void removeLastNode(){
        // tempory node pointer to current tail node
        Node nodeToRemove = this.tail;
        // tempory node pointer to the head node
        Node loopNode = this.head;
        // loop from the head untill the second to last node
        while (loopNode!=null){
            // check whether the second to last node is reach
            if (loopNode.getNextNode() == nodeToRemove){
                // make the second to last node pointer to null to avoid memory leak
                loopNode.setNextNode(null);
                // tail pointer to the second to last Node
                this.tail = loopNode;
            }
            //loop the pointer to the next node
            loopNode = loopNode.getNextNode();
        }
        // decrease count
        count--;
    }

    // method to insert a node to the last position
    public void insertToLast(Object anObject){
        // Init the new node to be added;
        Node newLastNode = new Node(anObject);
        // if currently there is no node in the list
        if(head == null){
            // point both head and tail to the new Node
            this.head = newLastNode;
            this.tail = newLastNode;
            // increase count from 0 to 1;
            count = 1;

            // if there is already at least a Node
        } else {
            // the current tail will point the new Node as next Node
            this.tail.setNextNode(newLastNode);
            // the tail will point to the new node
            this.tail = newLastNode;
            // increase count by 1
            count++;
        }
    }

    //method to insert at the front
    public void insertToFirst(Object anObject){
        // if currently there is no node in the list
        Node newFirstNode = new Node(anObject);
        if(head == null) {
            // point both head and tail to the new Node
            this.head = newFirstNode;
            this.tail = newFirstNode;
            // increase count from 0 to 1;
            count = 1;
            // if there is already at least a Node
        } else {
            // the new node will point to the current head node as next node
            newFirstNode.setNextNode(this.head);
            // the head pointer will point to the new nod as head
            this.head = newFirstNode;
            // increase count by 1
            count++;
        }
    }

    // print all values of the Singly Linked List
    public void printNode(){
        // the intro
        System.out.println("here is the elements:");

        // tempory pointer from the head
        Node node = this.head;
        // loop through all element and print out the value
        while (node !=null){
            System.out.println(node.getNodeData());
            node = node.getNextNode();
        }

    }

    // nested Node class
    private class Node {
        // contain 2 elements:its data and pointer to next Node
        private Object nodeData;
        private Node nextNode;

        // constructor
        public Node(Object dataValue){
            nextNode = null;
            this.nodeData = dataValue;
        }

        // quick contructor
        public Node (Object dataValue, Node nextNode){
            this.nodeData = dataValue;
            this.nextNode = nextNode;
        }

        // getter and setter below for the 2 elements
        public Object getNodeData() {
            return nodeData;
        }

        public void setNodeData(Object nodeData) {
            this.nodeData = nodeData;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        // ovveride toString method to easily print the data
        @Override
        public String toString() {
            return this.getNodeData().toString();
        }
    }
}