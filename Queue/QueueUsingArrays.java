public class QueueUsingArrays {
    /*
        Queue Data Members:
            1.int[] data
            2.int front
            3.int rear
            4.static final int DEFAULT_CAPACITY
     */

    int[] data;
    int front;
    int rear;

    private Static final int DEFAULT_CAPACITY = 10;

    //Default Constructor
    QueueUsingArrays() {
        this(DEFAULT_CAPACITY);
    }

    //Method 1: QueueUsingArrays(int capacity) -> Parameterized constructor that takes array size as parameter
    QueueUsingArrays(int capacity) {
        if(capacity < 0) {
            throw new Exception("Invalid Capacity");
        }
        this.data = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    //Method 2: size() -> returns the size of the Queue
    private int size() {
        return this.rear - this.front;
    }

    //Method 3: isEmpty() -> return true if Queue is empty else false
    private boolean isEmpty() {
        return this.size() == 0;
    }

    //Method 4: isFull() -> return true if Queue is Full else false
    private boolean isFull() {
        return this.rear++ == this.data.length;
    }

    //Method 5: getFront() -> return the front element of the Queue
    private int getFront() {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return this.data[this.front];
    }

    //Method 6: getRear() -> return the Rear element of the Queue
    private int getRear() {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return this.data[this.rear];
    }

    //Method 7: enqueue() -> Add an element to the rear of the queue
    private int enqueue(int value) {
        if(isFull()) {
            throw new Exception("Queue is full");
        }
        if(this.size() == 0 && this.front == -1 && this.rear == -1) {
            this.rear++;
            this.front++;
            this.data[rear] = value;
        } else {
            this.data[++rear] = value; 
        }
    }


}