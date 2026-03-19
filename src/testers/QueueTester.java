package testers;

import queues.*;
public class QueueTester {
    
    public static void main(String[] args){
        QueueInterface<Integer> queue = new ArrayQueue<>();
        System.out.println("ArrayQueue Test:");
        // Test enqueue and peek
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Peek: " + queue.peek()); // Should print 1
        
        // Test dequeue
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 1
        System.out.println("Peek after dequeue: " + queue.peek()); // Should print 2
        
        // Test isEmpty
        System.out.println("Is empty? " + queue.isEmpty()); // Should print false
        
        // Test clear
        queue.clear();
        System.out.println("Is empty after clear? " + queue.isEmpty()); // Should print true
        
        // Test dequeue on empty queue (should throw exception)
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        System.out.println("LinkedQueue Test:");
        QueueInterface<Integer> linkedQueue = new LinkedQueue<>();
        // Test enqueue and peek
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        System.out.println("Peek: " + linkedQueue.peek()); // Should print 1
        // Test dequeue
        System.out.println("Dequeue: " + linkedQueue.dequeue()); // Should print 1
        System.out.println("Peek after dequeue: " + linkedQueue.peek()); // Should print 2
        // Test isEmpty
        System.out.println("Is empty? " + linkedQueue.isEmpty()); // Should print false
        // Test clear
        linkedQueue.clear();
        System.out.println("Is empty after clear? " + linkedQueue.isEmpty()); // Should print true
        // Test dequeue on empty queue (should throw exception)
        try {
            linkedQueue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("QueueWithStack test:");
        QueueInterface<Integer> stackQueue = new QueueWithStack<>();
        // Test enqueue and peek
        stackQueue.enqueue(1);
        stackQueue.enqueue(2);
        stackQueue.enqueue(3);
        System.out.println("Peek: " + stackQueue.peek()); // Should print 1
        // Test dequeue
        System.out.println("Dequeue: " + stackQueue.dequeue()); // Should print 1
        System.out.println("Peek after dequeue: " + stackQueue.peek()); // Should print 2
        // Test isEmpty
        System.out.println("Is empty? " + stackQueue.isEmpty()); // Should print false
        // Test clear
        stackQueue.clear();
        System.out.println("Is empty after clear? " + stackQueue.isEmpty()); // Should print true
        // Test dequeue on empty queue (should throw exception)
        try {
            stackQueue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
