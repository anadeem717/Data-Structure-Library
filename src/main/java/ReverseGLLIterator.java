
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: implementation for an iterator that traverses a linkedList backwards

import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {

    private GenericList<T>.Node<T> currNode;
    private final GenericList<T> list;

    // initialize iterator with the list
    public ReverseGLLIterator(GenericList<T> list) {
        this.list = list;

        // Set currNode to the tail node
        this.currNode = list.getHead();
        if (currNode != null) {
            while (currNode.next != null) {
                currNode = currNode.next;
            }
        }
    }

    // check if there is another element in the list
    @Override
    public boolean hasNext() {
        return currNode != null;
    }

    // return the current data and move to the previous node
    @Override
    public T next() {
        if (currNode == null) {
            return null;
        }

        T data = currNode.data;
        currNode = findPrev(currNode); // move to the previous node
        return data;
    }

    // finds the node before the given node
    private GenericList<T>.Node<T> findPrev(GenericList<T>.Node<T> node) {
        GenericList<T>.Node<T> temp = list.getHead();
        GenericList<T>.Node<T> prevNode = null;

        // if the current node is the head, return null (no prev node)
        if (temp == node) {
            return null;
        }

        // iterate through list to find the previous node
        while (temp != null && temp.next != node) {
            prevNode = temp;
            temp = temp.next;
        }
        prevNode = temp; // the temp is the node preceding given node

        return prevNode;
    }
}
