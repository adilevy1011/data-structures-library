package stacks;

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        topIndex = -1;
    }
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.capacity = DEFAULT_CAPACITY;
        stack = (T[]) new Object[capacity];
        topIndex = -1;
    }

    @Override
    public void push(T item) {
        if (topIndex == capacity - 1) {
            throw new RuntimeException("Stack is full");
        }
        stack[++topIndex] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[topIndex--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public int size() {
        return topIndex + 1;
    }

    @Override
    public void clear() {
        topIndex = -1;
    }
    
    public void resize() {
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[capacity * 2];
        for (int i = 0; i <= topIndex; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity *= 2;
    }   
}
