package queues;

public class ArrayQueue<T> implements QueueInterface<T> {
    
    private T[] queue;
    private int front;
    private int back;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
        queue = (T[]) new Object[capacity];
        front = 0;
        size = 0;
        back = capacity-1;
    }
    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }
    public void enqueue(T item){
        if(size == queue.length){
            resize();
        }
        back = (back + 1) % queue.length;
        queue[back] = item;
        size++;
    }
    
    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        
        T item = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return item;
    }
    
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }
   
    public boolean isEmpty(){
        return size == 0;
    }
     
    public void clear(){
        for(int i = 0; i < size; i++){
            queue[(front + i) % queue.length] = null;
        }
        front = 0;
        back = 0;
        size = 0;
    }
      
    public int size(){
        return size;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        T[] newQueue = (T[]) new Object[queue.length * 2];
        for(int i = 0; i < queue.length; i++){
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
    }
}
