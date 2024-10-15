
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: implementation for a generic list


import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> implements Iterable<T> {

    // generic inner class for generic Node
    public class Node<T> {
        T data;
        int code;
        Node<T> next;

        // constructor only data
        public Node(T data) {
            this.data = data;
            this.code = 0;
            this.next = null;
        }

        // constructor with optional code
        public Node(T data, int code) {
            this.data = data;
            this.code = code;
            this.next = null;
        }
    }

    private Node<T> head; 
    private int length;

    // def constructor
    public GenericList() {
        this.head = null;
        this.length = 0;
    }

    // abstract functions that will need to be implemented
    public abstract void add(T data);
    public abstract T delete();


    // prints the items of the list, one value per line. 
    public void print() {

        // list is empty
        if (head == null) {
            System.out.println("Empty List");
        }

        // iterate through list and print vals
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next; // go to next node
        }
    }


    // Stores and returns all values currently in
    // the list into an ArrayList and returns it.
    public ArrayList<T> dumpList() {
        ArrayList<T> res = new ArrayList<>();

        // iterate through list and add vals to res
        Node<T> curr = head;
        while (curr != null) {
            res.add(curr.data);
            curr = curr.next;
        }

        return res;
    }

    // Method to get the element at a specific index
    public T get(int index) {

        // out of bounds
        if (index < 0 || index >= length) { return null; }

        // iterate though <index> times, until we reach the right node to return
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.data;
    }

    // Replace the element at specified position in the list
    // with the specified element and return the element previously at the specified position.
    // Return null if index is out of bounds
    public T set(int index, T element) {
        if (index < 0 || index >= length) { return null; }

        // iterate though <index> times, until we reach the right node
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        // store old data, and then change the data
        T prevData = curr.data;
        curr.data = element;
        return prevData;
    }

    // getters / setters
    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    public Node<T> getHead() { return head; }
    public void setHead(Node<T> head) { this.head = head; }

    // returns an iterator that can go through the list backwards
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<T>(this);
    }
}
