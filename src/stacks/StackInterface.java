package stacks;
public interface StackInterface<T>{

    /**
     * Adds an item to the top of the stack.
     * @param item the item to be added to the top of the stack
     */
    public void push(T item);
    /**
     * Removes and returns the item at the top of the stack.
     * @return the item at the top of the stack
     */
    public T pop();
    /**
     * Returns the item at the top of the stack without removing it.
     * @return the item at the top of the stack
     */
    public T peek();
    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();
    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size();
    /**
     * Removes all items from the stack.
     */
    public void clear();
}