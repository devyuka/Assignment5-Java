package ca.ciccc;

public class Driver {
    public static void main(String[] args) {
        ALPriorityQueue<Integer, String> test = new ALPriorityQueue<>();
        test.enqueue(40, "Tom");
        test.enqueue(10, "Gary");
        test.enqueue(20, "Jill");
        test.enqueue(5, "Richard");
        test.enqueue(100, "Rebeca");

        ALPriorityQueue<Integer, String> test2 = new ALPriorityQueue<>();
        test2.enqueue(200, "Aaron");
        test2.enqueue(3, "Walter");

        System.out.println("merge: " + test.merge(test2));
        System.out.println("dequeueMin: " + test.dequeueMin());
        System.out.println("peek: " + test.peek());

        DLPriorityQueue<Integer, String> test3 = new DLPriorityQueue<>();

        test3.enqueue(40, "Tom");
        test3.enqueue(5, "Rich");
        test3.enqueue(150, "Gary");
        test3.enqueue(100, "Rebeca");
        test3.enqueue(1, "Peter");
        test3.enqueue(500, "Mary");

        System.out.println("test3: " + test3);
        System.out.println("peek: " + test3.peek());
        System.out.println("dequeue: " + test3.dequeueMin());
        System.out.println("test3: " + test3);
        System.out.println("dequeue: " + test3.dequeueMin());
        System.out.println("test3: " + test3);
        System.out.println("dequeue: " + test3.dequeueMin());
        System.out.println("test3: " + test3);
        System.out.println("dequeue: " + test3.dequeueMin());
        System.out.println("test3: " + test3);
        System.out.println("dequeue: " + test3.dequeueMin());
        System.out.println("test3: " + test3);
        System.out.println("dequeue: " + test3.dequeueMin());
        System.out.println("test3: " + test3);

        DLPriorityQueue<Integer, String> test4 = new DLPriorityQueue<>();

        test4.enqueue(20, "Henry");
        test4.enqueue(4, "Will");
        test4.enqueue(30, "Katy");
        test4.enqueue(0, "Nancy");

        System.out.println("merge: " + test3.merge(test4));
    }
}
