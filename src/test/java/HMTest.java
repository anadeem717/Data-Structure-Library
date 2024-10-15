
// Areesh Nadeem
// netID: anade2
// anade2@uic.edu
// Description: Test cases for MyHashMap

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HMTest {

    // empty constructor
    @Test
    public void ConstructorTest() {
        MyHashMap<Integer> map = new MyHashMap<>();
        assertTrue(map.isEmpty());
    }

    // parameterized constructor
    @Test
    public void ParamConstructorTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);
        assertEquals(10, map.get("1"));
    }

    // see if adding elements works
    @Test
    public void PutTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);
        map.put("2", 20);
        assertEquals(10, map.get("1"));
        assertEquals(20, map.get("2"));
    }

    // see if getting elements works
    @Test
    public void GetTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);
        assertEquals(10, map.get("1"));
    }

    @Test
    public void ContainsTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);
        assertTrue(map.contains("1"));
        assertFalse(map.contains("2"));
    }

    // see if map correctly replaces data
    @Test
    public void ReplaceTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);
        map.replace("1", 15);
        assertEquals(15, map.get("1"));
    }

    // replace data on map with collisions
    // see if it can replace data within queues
    @Test
    public void ReplaceCollisionTest() {
        MyHashMap<Integer> map = new MyHashMap<>("Cozmo", 10);
        map.put("omzoC", 20);

        map.replace("Cozmo", 15);
        assertEquals(15, map.get("Cozmo"));

        map.replace("omzoC", 5);
        assertEquals(5, map.get("omzoC"));
    }

    @Test
    public void IsEmptyTest() {
        MyHashMap<Integer> map = new MyHashMap<>();
        assertTrue(map.isEmpty());

        map.put("1", 10);
        assertFalse(map.isEmpty());
    }

    @Test
    public void SizeTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);
        map.put("2", 20);
        assertEquals(2, map.size());
    }

    // size with collisions, see if the count is correct with queues
    @Test
    public void SizeGreaterThanTenTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);

        for (int i = 0; i < 10; i++) {
            map.put(Integer.toString(i), i);
        }

        assertEquals(11, map.size());
    }

    // test the for each loop
    @Test
    public void HMIterator_ForEachIteratorTest() {
        MyHashMap<Integer> map = new MyHashMap<>("1", 10);
        map.put("2", 20);
        map.put("3", 30);
        map.put("4", 40);

        int sum = 0;
        for (Integer value : map) {
            sum += value;
        }
        assertEquals(100, sum);
    }


    // unit test hashNext() in iterator
    @Test
    public void HMIterator_HasNextTest() {
        ArrayList<GenericQueue<Integer>> map = new ArrayList<>();
        GenericQueue<Integer> queue1 = new GenericQueue<>();
        queue1.add(1);
        map.add(queue1);

        HMIterator<Integer> iterator = new HMIterator<>(map);

        assertTrue(iterator.hasNext());
    }

    // unit test next() in iterator
    @Test
    public void HMIterator_NextTest() {
        ArrayList<GenericQueue<Integer>> map = new ArrayList<>();
        GenericQueue<Integer> queue1 = new GenericQueue<>();
        queue1.add(1);
        queue1.add(2);
        map.add(queue1);

        HMIterator<Integer> iterator = new HMIterator<>(map);

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());

        assertFalse(iterator.hasNext());
    }

}
