package lists;

public class AList<T> implements ListInterface<T>{
   private T[] list; // Array of list entries; ignore list[0]
   private int numberOfEntries;
   private static final int DEFAULT_CAPACITY = 25;
   private static final int MAX_CAPACITY = 10000;
   
   public AList()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
   @SuppressWarnings("unchecked")
   public AList(int initialCapacity)
   {
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else
         checkCapacity(initialCapacity);
      //
      list = (T[] )new Object[initialCapacity + 1];
      numberOfEntries = 0;
   } // end constructor
   
   public void add(T newEntry)
   {
      add(numberOfEntries + 1, newEntry);
   } // end add
   
   public void add(int newPosition, T newEntry)
   {
      if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
      {
         if (numberOfEntries == list.length - 1) // Is array full?
            doubleArray(); // Increase size of array
         
         // Make room for new entry by shifting all entries at
         // and above newPosition toward the end of the array
         for (int index = numberOfEntries; index >= newPosition; index--)
            list[index + 1] = list[index];
         
         list[newPosition] = newEntry;
         numberOfEntries++;
      }
      else
         throw new IndexOutOfBoundsException(
                   "Given position of add's new entry is out of bounds.");
   } // end add

   public T remove(int givenPosition)
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         T result = (T) list[givenPosition]; // Get entry to be removed
         
         // Move subsequent entries toward the entry to be removed,
         // unless it is last in the list
         if (givenPosition < numberOfEntries)
            removeGap(givenPosition);
         
         list[numberOfEntries] = null;
         numberOfEntries--;
         
         return result;
      }
      else
         throw new IndexOutOfBoundsException(
                   "Illegal position given to remove operation.");
   } // end remove
   public void clear()
   {
      // Clear entries but retain array; no need to create a new array
      for (int index = 0; index < list.length; index++)
         list[index] = null;
      
      numberOfEntries = 0;
   } // end clear

   public T replace(int givenPosition, T newEntry)
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         T originalEntry = (T) list[givenPosition];
         list[givenPosition] = newEntry;
         return originalEntry;
      }
      else
         throw new IndexOutOfBoundsException(
                   "Illegal position given to replace operation.");
   } // end replace

   public T getEntry(int givenPosition)
   {
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
         return (T) list[givenPosition];
      else
         throw new IndexOutOfBoundsException(
                   "Illegal position given to getEntry operation.");
   } // end getEntry

   public T get(int index) {
      if ((index >= 1) && (index <= numberOfEntries))
         return (T) list[index];
      else
         throw new IndexOutOfBoundsException(
                   "Illegal position given to get operation.");
   }
   public T[] toArray()
   {
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[]) new Object[numberOfEntries];
      
      for (int index = 0; index < numberOfEntries; index++)
         result[index] = (T) list[index + 1];
      
      return result;
   } // end toArray

   public boolean contains(T anEntry)
   {
      boolean found = false;
      int index = 1;
      
      while (!found && (index <= numberOfEntries))
      {
         if (anEntry.equals(list[index]))
            found = true;
         index++;
      }
      
      return found;
   } // end contains

    public int getLength()
    {
        return numberOfEntries;
    } // end getLength
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty

    public boolean isFull()
    {
        return numberOfEntries == list.length - 1;
    } // end isFull
   // ==============================Private Helpers=====================================
   private void doubleArray()
   {
      int newLength = 2 * list.length;
      checkCapacity(newLength);
      @SuppressWarnings("unchecked")
      T[] newList = (T[]) new Object[newLength];
      for (int index = 0; index < list.length; index++)
         newList[index] = list[index];
      list = newList;
   } // end doubleArray

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list " +
                                          "whose capacity exceeds " +
                                          "allowed maximum of " +
                                          MAX_CAPACITY);
    } // end checkCapacity
   private void removeGap(int givenPosition)
   {
      for (int index = givenPosition; index < numberOfEntries; index++)
         list[index] = list[index + 1];
   } // end removeGap
   
   
}
