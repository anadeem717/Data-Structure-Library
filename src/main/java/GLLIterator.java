
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: implementation for an iterator that traverses a linked list

import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> {

    private GenericList<T>.Node<T> currNode;

    // initialize iterator starting with head node
    public GLLIterator(GenericList<T>.Node<T> head) {
        this.currNode = head;
    }

    // Check if there is another element in the list
    @Override
    public boolean hasNext() {
        return currNode != null;
    }

    // move to next node and return curr data
    @Override
    public T next() {
        T data = currNode.data;
        currNode = currNode.next;
        return data;
    }
}
