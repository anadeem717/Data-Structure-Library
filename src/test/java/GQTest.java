
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: Test cases for GenericQueue

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GQTest {

    // test for empty constructor
    @Test
    public void ConstructorTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assertEquals(0, queue.getLength());
        assertNull(queue.getHead());
        assertNull(queue.getTail());
    }

    // test for empty node constructor
    @Test
    public void NodeConstructorTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();

        GenericList<Integer>.Node<Integer> head = queue.getHead();
        assertEquals(0, queue.getLength());
        assertNull(queue.getHead());
        assertNull(queue.getTail());
    }

    // test for parameterized node constructor
    @Test
    public void NodeParamConstructorTest() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);

        GenericList<Integer>.Node<Integer> head = queue.getHead();
        assertEquals(1, queue.getLength());
        assertEquals(1, queue.getHead().data);
        assertEquals(1, queue.getTail().data);
    }

    // test for adding an element
    @Test
    public void AddTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        assertEquals(1, queue.get(0));
        assertEquals(1, queue.getLength());
    }

    // test for enqueue method
    @Test
    public void EnqueueTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(1);
        assertEquals(1, queue.get(0));
        assertEquals(1, queue.getLength());
    }

    // test for adding an element with a code
    @Test
    public void AddWithCodeTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1,1);

        assertEquals(1, queue.get(0));
        assertEquals(1, queue.getHead().code);
        assertEquals(1, queue.getLength());
    }

    // test for deleting an element
    @Test
    public void DeleteTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);

        int removed = queue.delete();

        assertEquals(1, removed);
        assertEquals(1, queue.getLength());
        assertEquals(2, queue.getHead().data);
    }

    // test for dequeuing an element
    @Test
    public void DequeueTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);

        int removed = queue.dequeue();

        assertEquals(1, removed);
        assertEquals(1, queue.getLength());
        assertEquals(2, queue.getHead().data);
    }

    // test for getting an element at an index
    @Test
    public void GetTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        assertEquals(1, queue.get(0));
        assertEquals(2, queue.get(1));
    }

    // test for getting the tail of the queue
    @Test
    public void GetTailTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        assertEquals(2, queue.getTail().data);
    }

    // test for dumping the queue list into an array
    @Test
    public void DumpListTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        ArrayList<Integer> dumpedList = queue.dumpList();
        assertEquals(2, dumpedList.size());
        assertEquals(2, queue.getLength());

        assertEquals(1, queue.get(0));
        assertEquals(2, queue.get(1));

        assertEquals(1, dumpedList.get(0));
        assertEquals(2, dumpedList.get(1));
    }

    // test for using for-each iterator
    @Test
    public void Queue_ForEachIteratorTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : queue) {
            result.add(i);
        }

        assertEquals(3, result.size());
        assertEquals(1, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
        assertEquals(3, result.get(2).intValue());
    }

    // test for using descending iterator
    @Test
    public void DescendingIteratorTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Iterator<Integer> iterator = queue.descendingIterator();

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    // test for checking if GLLIterator has next element
    @Test
    public void GLLIterator_HasNextTest() {
        GenericList<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        GLLIterator<Integer> iterator = new GLLIterator<>(queue.getHead());

        assertTrue(iterator.hasNext());
    }

    // test for checking GLLIterator next element
    @Test
    public void GLLIterator_NextTest() {
        GenericList<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        GLLIterator<Integer> iterator = new GLLIterator<>(queue.getHead());

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());

        assertFalse(iterator.hasNext());
    }

    // test for checking if ReverseGLLIterator has next element on empty list
    @Test
    public void ReverseGLLIterator_HasNextOnEmptyListTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();

        ReverseGLLIterator<Integer> iterator = new ReverseGLLIterator<>(queue);

        assertFalse(iterator.hasNext());
    }

    // test for checking if ReverseGLLIterator has next element on non-empty list
    @Test
    public void ReverseGLLIterator_HasNextOnNonEmptyListTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);

        ReverseGLLIterator<Integer> iterator = new ReverseGLLIterator<>(queue);

        assertTrue(iterator.hasNext());
    }

    // test for getting next element in reverse with ReverseGLLIterator
    @Test
    public void ReverseGLLIterator_NextTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        ReverseGLLIterator<Integer> iterator = new ReverseGLLIterator<>(queue);

        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());

        assertFalse(iterator.hasNext());
    }

    // test for checking next element on empty list in ReverseGLLIterator
    @Test
    public void ReverseGLLIterator_NextOnEmptyListTest() {
        GenericQueue<Integer> queue = new GenericQueue<>();

        ReverseGLLIterator<Integer> iterator = new ReverseGLLIterator<>(queue);

        assertNull(iterator.next());
    }

}



