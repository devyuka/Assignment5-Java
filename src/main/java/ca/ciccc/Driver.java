package ca.ciccc;

public class Driver {
    public static void main(String[] args) {
//        ALPriorityQueue<Entry> test = new ALPriorityQueue<>();
//        test.enqueue(40, "Tom");
//        test.enqueue(10, "Gary");
//        test.enqueue(20, "Jill");
//
//        ALPriorityQueue<Entry> test2 = new ALPriorityQueue<>();
//        test2.enqueue(100, "Aaron");
//        test2.enqueue(5, "Walter");
//
//        System.out.println("merge: " + test.merge(test2));
//        System.out.println("dequeueMin: " + test.dequeueMin());
//        System.out.println("peek: " + test.peek());

        DLPriorityQueue<Entry> test3 = new DLPriorityQueue<>();
        test3.enqueue(30, "Sky");
        test3.enqueue(10, "Bob");
        test3.enqueue(50, "Lily");

        System.out.println(test3);
        System.out.println(test3.dequeueMin());
    }
}
