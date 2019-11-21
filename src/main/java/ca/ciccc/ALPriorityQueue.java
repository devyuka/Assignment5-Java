package ca.ciccc;

import java.util.ArrayList;

public class ALPriorityQueue < E > implements VCPriorityQueue {
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
    public Entry enqueue(Comparable key, Object value) throws IllegalArgumentException {
        Entry newEntry = new Entry(key, value);
        elementData.add(newEntry);
        size++;
        return new Entry(key, value);
    }

    @Override
    public Entry peek() {
        return (size == 0) ? null : elementData.get(0);
    }

    @Override
    public Entry dequeueMin() {
        if (size == 0) {
            return null;
        } else {
            int smallestKey = (int) elementData.get(0).getKey();
            Entry smallestKeyEntry = elementData.get(0);

            for (int i = 0; i < size(); i++) {
                if (smallestKey > (int) elementData.get(i).getKey()) {
                    smallestKey = (int) elementData.get(i).getKey();
                    smallestKeyEntry = elementData.get(i);
                }
            }

            elementData.remove(smallestKeyEntry);
            size--;
            return smallestKeyEntry;
        }
    }

    public Entry poll() {
        if (size == 0) {
            return null;
        }

        Entry firstElement = elementData.get(0);
        elementData.remove(firstElement);
        size--;

        return firstElement;
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue other) {
        elementData.addAll(((ALPriorityQueue) other).elementData);
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