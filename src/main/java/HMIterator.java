
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: implementation for an iterator that traverses a hashMap

import java.util.ArrayList;
import java.util.Iterator;

public class HMIterator<T> implements Iterator<T> {

    private final ArrayList<GenericQueue<T>> map; // array of queues
    private Iterator<T> queueIterator;            // the iterator for the queue
    int index;                                    // index of the curr queue

    // constructor, initialize with the given map
    public HMIterator(ArrayList<GenericQueue<T>> map) {
        this.map = map;
        this.queueIterator = null;
        this.index = 0;

        findNextQueue(); // find the first val for iteration
    }

    // Check if there is another element in the list
    @Override
    public boolean hasNext() {
        // next val maybe in queue
        if (queueIterator != null && queueIterator.hasNext()) {
            return true;
        }

        // maybe next val in a different index
        findNextQueue();
        if (queueIterator != null && queueIterator.hasNext()) {
            return true;
        }
        else {
            return false; // no next value
        }

    }

    // move to next node and return curr data
    @Override
    public T next() {
        T data = null;

        // if the curr queue has another value
        if (queueIterator.hasNext()) {
            data = queueIterator.next();
        }

        // try to find another value in a different index
        else {
            data = queueIterator.next();
            findNextQueue();
        }

        return data;

    }

    // finds the next queue to iterate through
    private void findNextQueue() {

        // go through the array of queues and look for a valid queue
        while (index < map.size()) {
            GenericQueue<T> queue = map.get(index);
            index++;

            // if queue exists, need to iterate through it
            if (queue != null && queue.getLength() > 0)  {
                queueIterator = queue.iterator();
                return;
            }
        }

        // no queue exists in map, hence no elements
        queueIterator = null;
    }
}
