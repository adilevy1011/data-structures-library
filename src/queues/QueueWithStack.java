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
        rev.push(item);
        size++;
    }
    
    public T dequeue(){
        if(size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        for(int i = 0; i < size-1; i++){
            nor.push(rev.pop());
        }
        T item = rev.pop();
        size--;
        for(int i = 0; i < size; i++){
            rev.push(nor.pop());
        }
        return item;
    }
    
    public T peek(){
        for(int i = 0; i < size-1; i++){
            nor.push(rev.pop());
        }
        T item = rev.peek();
        for(int i = 0; i < size-1; i++){
            rev.push(nor.pop());
        }
        return item;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
     
    public void clear(){
        for(int i = 0; i < size; i++){
            rev.pop();
        }
        size = 0;
    }
      
    public int size(){
        return size;
    }

}
