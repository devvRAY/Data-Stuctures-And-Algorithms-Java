public class StackUsingArrays {
    /*
        Stack Data Members:
            1.int[] data
            2.int top
            3.int capacity
            4.static final int DEFAULT_CAPACITY
     */
    int[] data;
    int top;
    int maxCapacity;
    private static final int DEFAULT_CAPACITY = 10;

    //Method 1: StackUsingArrays() -> Default constructor
    StackUsingArrays() throws Exception {
        this(DEFAULT_CAPACITY);
    }

    //Method 2: StackUsingArrays(int capacity) -> Parameterized constructor that takes array size as parameter
    StackUsingArrays(int capacity) throws Exception {
        if(capacity < 0) {
            throw new Exception("Invalid capacity");
        }
        data = new int[capacity];
        top = -1;
        this.maxCapacity = capacity;
    }

    //Method 3: size() -> returns the size of the stack
    private int size() {
        return this.top + 1;
    }

    //Method 4: isEmpty() -> return true if stack is empty else false
    private boolean isEmpty() {
        return (this.top == -1);
    }

    //Method 5: isFull() -> return true if stack is full else false
    private boolean isFull() {
        return (this.top + 1 == maxCapacity);
    }

    //Method 6: peek() -> return the top element of the Stack
    private int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return this.data[this.top];
    }

    //Method 7: push(int value) -> adds the value to top of the stack
    private void push(int value) throws Exception {
        if(isFull()) {
            throw new Exception("The stack is full");
        }
        this.data[++this.top] = value;
    }

    //Method 8: pop() -> removes the top element of the stack
    private int pop() throws Exception{
        if(isEmpty()) {
            throw new Exception("The stack is empty");
        }
        return this.data[this.top--];
    }

    //Method 9: display() -> prints the stack
    private void display() throws Exception{
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        for (int i = 0; i <= this.top; i++) {
            System.out.print(this.data[i] + " -> ");
        }
        System.out.println();
    }

    //Method 10: reverseStack(StackUsingArrays stack, StackUsingArrays helper, int index) -> recursively reverses a stack

}