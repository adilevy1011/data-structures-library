package queues;

public class ArrayQueue<T> implements QueueInterface<T> {
    
    private T[] queue;
    private int front;
    private int back;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == queue.length) {
            resize();
        }
        queue[back] = item;
        back = (back + 1) % queue.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = queue[front];
        queue[front] = null; 
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null; 
        }
        front = 0;
        back = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newQueue = (T[]) new Object[queue.length * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        back = size;
    }
}
