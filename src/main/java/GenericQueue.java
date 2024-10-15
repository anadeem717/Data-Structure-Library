
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: implementation for a generic queue

import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> {

    private Node<T> tail;

    // default constructor
    public GenericQueue() {
        tail = null;
        setHead(null);
    }

    // param constructor
    public GenericQueue(T data) {
        setHead(new Node<T>(data));
        tail = getHead();
        setLength(getLength() + 1);
    }

    // adds a Node to back of list
    @Override
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);

        // edge case, list empty
        if (getHead() == null) {
            setHead(newNode);
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;

        setLength(getLength() + 1);
    }

    // overloaded add()
    // adds a node to back of list, with code
    public void add(T data, int code) {
        Node<T> newNode = new Node<T>(data, code);

        // edge case, list empty
        if (getHead() == null) {
            setHead(newNode);
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;

        setLength(getLength() + 1);
    }

    // deletes node from front of queue
    @Override
    public T delete() {

        // Check if the queue is empty
        if (getHead() == null) {
            return null;
        }

        // Get the data of the head (front) node
        T val = getHead().data;

        // Move the head to the next node
        setHead(getHead().next);

        // Decrease the length of the queue
        setLength(getLength() - 1);

        return val;
    }


    // returns an iterator that goes through list
    @Override
    public Iterator<T> iterator() {
        return new GLLIterator<>(this.getHead());
    }

    // adds node to back
    public void enqueue(T data) {
        add(data);
    }

    // deletes node from front
    public T dequeue() {
        return delete();
    }

    // returns tail node
    public Node<T> getTail() {
        return tail;
    }

}
