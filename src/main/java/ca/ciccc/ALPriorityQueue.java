package ca.ciccc;

import java.util.ArrayList;

public class ALPriorityQueue <K extends Comparable, V> implements VCPriorityQueue {

    private ArrayList < Entry > elementData;
    private int size;

    public ALPriorityQueue() {
        elementData = new ArrayList < > ();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Entry<K,V> enqueue(Comparable key, Object value) throws IllegalArgumentException {
        Entry newEntry = new Entry(key, value);
        elementData.add(newEntry);
        size++;
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        if (size == 0) return null;

        Entry<K, V> entry = elementData.get(0);
        for(int i = 0; i < size; i++){
            //Compare a current key with the previous key.
            //If the returned value is smaller than 0, it means a current key is smaller than the previous key.
            //You can get Entry with the smallest key. (smallest key is the highest value)
            if(elementData.get(i).key.compareTo(entry.key) < 0){
                entry = elementData.get(i);
            }
        }
        return entry;
    }

    @Override
    public Entry dequeueMin() {
        if (size == 0) {
            return null;
        } else {
            Entry smallestKeyEntry = peek();

            elementData.remove(smallestKeyEntry);
            size--;
            return smallestKeyEntry;
        }
    }

    @Override
    public VCPriorityQueue<K, V>  merge(VCPriorityQueue other) {
        elementData.addAll(((ALPriorityQueue)other).elementData);
        size += other.size();
        return this;
    }

    @Override
    public String toString() {
        return "ALPriorityQueue{" +
                "elementData=" + elementData +
                ", size=" + size +
                '}';
    }
}