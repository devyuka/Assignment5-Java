package ca.ciccc;

public class DLPriorityQueue<K extends Comparable, V> implements VCPriorityQueue {
    private Node head, tail;
    private int size;

    private class Node<E> {
        Entry<K, V>  data;
        Node prev;
        Node next;

        public Node(){};

        public Node(Entry<K, V> data, Node<E> prev, Node<E> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Entry<K, V> getData() {
            return data;
        }

        public void setData(Entry<K, V> data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data
                    + '}';
        }
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
        Node newNode = new Node();
        newNode.data = newEntry;
        newNode.prev = null;
        newNode.next = null;

        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return newEntry;
        }

        Node h = head;

        if(newNode.data.getKey().compareTo(h.data.getKey()) <= 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return newEntry;
        }

        while (newNode.data.getKey().compareTo(h.data.getKey()) > 0) {

            //If newNode has the biggest key, it comes to the end of the queue.
            if(h == tail){
                h.next = newNode;
                newNode.prev = h;
                tail = newNode;
                size++;
                return newEntry;
            }

            h = h.next;
        }

        h.prev.next = newNode;
        newNode.prev = h.prev.prev;
        h.prev = newNode;
        newNode.next = h;

        size++;
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        if(head == null) return null;

        Entry<K, V> entry = head.data;
        return entry;
    }

    @Override
    public Entry dequeueMin() {
        if(head == null) return null;

        Entry<K, V> entry = head.data;

        if(head.next == null){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return entry;
    }

    @Override
    public VCPriorityQueue<K, V>  merge(VCPriorityQueue other) {
        while(other.peek() != null){
            Entry entry  = other.dequeueMin();
            this.enqueue(entry.key, entry.value);
        }
        size += other.size();
        return this;
    }

    @Override
    public String toString() {
        String result = "";
        Node h = head;

        if(head == null) return "List: " + result;

        do{
            result += h.getData();
            if (h.getNext() != null) {
                result += ", ";
            }

        }while ((h = h.getNext()) != null);

        return "List: " + result + " Size: " + size;
    }
}
