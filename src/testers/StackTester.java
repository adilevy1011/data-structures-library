package testers;

import stacks.*;
public class StackTester {
    
    public static void main(String[] args){
        System.out.println("ArrayStack Test:");
        StackInterface<Integer> arrayStack = new ArrayStack<>();
        // Test push and peek
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println("Peek: " + arrayStack.peek()); // Should print 3
        
        // Test pop
        System.out.println("Pop: " + arrayStack.pop()); // Should print 3
        System.out.println("Peek after pop: " + arrayStack.peek()); // Should print 2
        
        // Test isEmpty
        System.out.println("Is empty? " + arrayStack.isEmpty()); // Should print false
        
        // Test clear
        arrayStack.clear();
        System.out.println("Is empty after clear? " + arrayStack.isEmpty()); // Should print true
        
        // Test pop on empty stack (should throw exception)
        try {
            arrayStack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        
        System.out.println("LinkedStack Test:");
        StackInterface<Integer> linkedStack = new LinkedStack<>();
        // Test push and peek
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        System.out.println("Peek: " + linkedStack.peek()); // Should print 3
        
        // Test pop
        System.out.println("Pop: " + linkedStack.pop()); // Should print 3
        System.out.println("Peek after pop: " + linkedStack.peek()); // Should print 2
        
        // Test isEmpty
        System.out.println("Is empty? " + linkedStack.isEmpty()); // Should print false
        
        // Test clear
        linkedStack.clear();
        System.out.println("Is empty after clear? " + linkedStack.isEmpty()); // Should print true
        
        // Test pop on empty stack (should throw exception)
        try {
            linkedStack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
