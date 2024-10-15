
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: implementation of a hash map

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<T> implements Iterable<T> {

    ArrayList<GenericQueue<T>> map; // array of queues
    private int mapSize;            // # of elements in map

    // def constructor (map empty)
    public MyHashMap() {
        map = new ArrayList<>();

        // default size 10, with null vals
        for (int i = 0; i < 10; i++) {
            map.add(null);
        }
    }

    // param constructor
    public MyHashMap(String key, T value) {
        map = new ArrayList<>();

        // default size 10, with null vals
        for (int i = 0; i < 10; i++) {
            map.add(null);
        }

        // add the key value pair to map
        this.put(key, value);
    }


    // adds a key value pair to the map
    public void put(String key, T value) {

        int code = key.hashCode();
        int hashVal = code & (map.size() - 1);

        // queue does not exist
        if (map.get(hashVal) == null) {
            GenericQueue<T> queue = new GenericQueue<>(value);
            queue.getHead().code = code;
            map.set(hashVal, queue);
        }

        // queue already exists, enqueue
        else {
            GenericQueue<T> queue = map.get(hashVal);
            queue.add(value,code);
        }
        mapSize++;

    }

    // checks to see if a value exists at key
    public boolean contains(String key) {
        int code = key.hashCode();
        int hashVal = code & (map.size() - 1);

        // key doesnt exist
        if (map.get(hashVal) == null) { return false; }

        // check to see if a node with the right code exists
        else {
            GenericList<T>.Node<T> node = findNode(code, hashVal);

            if (node == null) { return false; }
            else { return true; }
        }
    }

    // returns the value at the given key or returns null if it does not exist.
    public T get(String key) {
        int code = key.hashCode();
        int hashVal = code & (map.size() - 1);

        // key doesnt exists
        if (map.get(hashVal) == null) { return null; }

        // find node within queue
        else {
            GenericList<T>.Node<T> node = findNode(code, hashVal);

            if (node == null) { return null; } // no node found
            return node.data;
        }
    }

    // returns the number of key-value mappings in the map.
    public int size() {
        return mapSize;
    }

    // checks if the map contains NO key-value mappings.
    public boolean isEmpty() {
        return mapSize == 0;
    }

    // replaces the entry for the specified key only if it is currently mapped to some value.
    public T replace(String key, T value) {
        int code = key.hashCode();
        int hashVal = code & (map.size() - 1);

        // key not mapped to a value
        if (map.get(hashVal) == null) { return null; }

        // find in the queue
        else {
            GenericList<T>.Node<T> node = findNode(code, hashVal);

            if (node == null) { return null; } // not in the queue

            // store previous and change the data
            T prevVal = node.data;
            node.data = value;

            return prevVal;

        }
    }

    // finds a node with corresponding code and hashVal in the map
    private GenericList<T>.Node<T> findNode(int code, int hashVal) {
        GenericList<T>.Node<T> node = map.get(hashVal).getHead();

        // iterate through queue until we find a match
        while (node != null && node.code != code) {
            node = node.next;
        }

        if (node == null) { return null; } // no match
        else { return node; }
    }

    // returns an iterator for the hash map
    @Override
    public Iterator<T> iterator() {
        return new HMIterator<>(map);
    }
}
