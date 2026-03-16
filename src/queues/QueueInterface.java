package queues;

public interface QueueInterface<T> {
    /**
     * Adds an item to the back of the queue.
     * @param item the item to be added to the back of the queue
     */
    public void enqueue(T item);
    /**
     * Removes and returns the item at the front of the queue.
     * @return the item at the front of the queue
     */
    public T dequeue();
    /**
     * Returns the item at the front of the queue without removing it.
     * @return the item at the front of the queue
     */
    public T peek();
    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();
    /**
     * Removes all items from the queue.
     */ 
    public void clear();
        /**
        * Returns the number of items in the queue.
        * @return the number of items in the queue
        */
    public int size();
}
