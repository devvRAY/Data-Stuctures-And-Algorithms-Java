public class QueueUsingArrays {
    /*
        Queue Data Members:
            1.int[] data
            2.int front
            3. int rear
            4.static final int DEFAULT_CAPACITY
     */

    int[] data;
    int front;
    int rear;

    private static final int DEFAULT_CAPACITY = 10;

    //Default Constructor
    QueueUsingArrays() {
        this(DEFAULT_CAPACITY);
    } 

    //Method 1: QueueUsingArrays(int capacity) -> Parameterized constructor that takes array size as parameter
    QueueUsingArrays(int capacity) {
        if(capacity < 0) {
            throw new Exception("Invalid capacity provided");
        }
        this.data = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }
    
    //Method 2: int size() -> Returns the size of the Queue
    private int size() {
        return this.rear - this.front;
    }

    //Method 3: boolean isFull() -> Checks if the queue is full
    private boolean isFull() {
        return this.rear ++ == this.data.length;
    }

    //Method 4: boolean isEmpty() -> Checks if the queue is empty
    private boolean isEmpty() {
        return this.rear  == -1;
    }

    //Method 5: int getFront() -> return the element that is at the front of the queue
    private int getFront() {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return this.data[this.front];
    }

    //Method 6: int getRear() -> return the element that is at the end of the queue
    private int getRear() {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return this.data[this.rear];
    }

    //Method 7: void enqueue(int value) -> Add an element to the end of the queue
    private void enqueue(int value) {
        if(isFull()) {
            throw new Exception("Queue is full");
        }
        this.rear++;
        this.data[this.rear] = value;
    }

    //Method 7: int dequeue() -> Remove the element that is at the front of the queue
    private void dequeue() {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int rv = this.data[this.front];
        this.data[this.front] = 0;
        this.front++;
        return rv;
    }

    //Method 8: void print() -> Print the queue
    private void print() {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        for(int i=this.front; i<=this.rear; i++) {
            System.out.println(this.data[i]);
        } 
    }
}