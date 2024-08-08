public class StackUsingArrays {
    /*
        Stack Data Members:
            1.int[] data
            2.int top
            3.static final int DEFAULT_CAPACITY
     */

    int[] data;
    int top;

    private Static final int DEFAULT_CAPACITY = 10;

    //Default Constructor
    StackUsingArrays() {
        this(DEFAULT_CAPACITY);
    } 

    //Method 1: StackUsingArrays(int capacity) -> Parameterized constructor that takes array size as parameter
    StackUsingArrays(int capacity) {
        if(capacity < 0) {
            throw new Exception("Invalid capacity provided");
        }
        this.data = new int[capacity];
        this.top = -1;
    }

    //Method 2: size() -> returns the size of the stack
    private int size() {
        return this.top++;
    }

    //Method 3: isEmpty() -> return true if stack is empty else false
    private boolean isEmpty() {
        return this.top == -1;
    }

    //Method 4: isFull() -> return true if stack is full else false
    private boolean isFull() {
        return this.top++ == this.data.length;
    }

    //Method 5: top() -> return the top element of the Stack
    private int top() {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return this.data[this.top];
    }

    //Method 6: push(int value) -> adds the value to top of the stack
    private void push(int value) {
        if(isFull()) {
            throw new Exception("Stack is full");
        }
        this.top++;
        this.data[this.top] = value;
    }

    //Method 7: pop() -> removes the top element of the stack
    private int pop() {
        if(isEmpty()) {
            throw new Exception("Stack is Empty");
        }
        int rv = this.daa[this.top];
        this.data[this.top] = 0;
        this.top--;
        return rv;
    }

    //Method 8: display() -> prints the stack
    private void display() {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        for(int i=this.top; i>=0;i--) {
            System.out.println(this.data[i]);
        }
    }

    //Method 9: reverseStack(StackUsingArrays stack, StackUsingArrays helper, int index) -> recursively reverses a stack

}