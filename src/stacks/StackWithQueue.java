package stacks;

import queues.*;

public class StackWithQueue<T> implements StackInterface<T>{

    private LinkedQueue<T> stackQueue;
    private int size;
    public StackWithQueue(){
        stackQueue = new LinkedQueue<>();
        size = 0;
    }

    public void push(T item){
        stackQueue.enqueue(item);
        for(int i = 0; i < size; i++){
            stackQueue.enqueue(stackQueue.dequeue());
        }
        size++;
    }
   
    
    public T pop(){
        if(size == 0){
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        return stackQueue.dequeue();
    }
    
    public T peek(){
        return stackQueue.peek();
    }
    

    public boolean isEmpty(){
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    public void clear(){
        for(int i = 0; i < size; i++){
            stackQueue.dequeue();
        }
        size = 0;
    }
    
    

}
