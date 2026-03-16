package stacks;
public interface StackInterface<T>{


    public void push(T item);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public int size();
    public void clear();
}