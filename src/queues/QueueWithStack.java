package queues;

import stacks.*;
public class QueueWithStack<T> implements QueueInterface<T>{
    private LinkedStack<T> rev;
    private LinkedStack<T> nor;

    private int size;

    public QueueWithStack(){
        this.rev = new LinkedStack<>();
        this.nor = new LinkedStack<>();
        size = 0;

    }

    public void enqueue(T item){
        size++;
    }
    
    public T dequeue(){
        size--;
        return null;
    }
    
    public T peek(){
        return null;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
     
    public void clear(){

    }
      
    public int size(){
        return size;
    }

}
