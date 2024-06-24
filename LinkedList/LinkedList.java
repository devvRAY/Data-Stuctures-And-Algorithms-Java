public class LinkedList {
    /*
        Linked List Data Members: 1.Node head 2.Node tail 3.int size
        Node Data Members: 1.int data 2.Node next
     */
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    //Method 1: LinkedList() -> Default Constructor
    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Method 2: getSize() -> returns size of the linked list
    public int getSize() {
        return this.size;
    }

    //Method 3: isEmpty() -> Returns boolean value
    public boolean isEmpty() {
        return this.size == 0;
    }

    //Method 3: getHead() -> returns head element of the linked list
    public Node getHead() {
        return this.head;
    }

    //Method 4: getTail() -> returns last element of the linked list
    public Node getTail() {
        return this.tail;
    }

    //Method 5: getNodeAt(int index) -> returns element at given index
    public Node getNodeAt(int index) throws Exception {
        if(this.isEmpty()) {
            throw new Exception("Linked List is Empty");
        }
        if(index < 0 || index > this.size) {
            throw new Exception("Invalid index provided");
        }
        Node temp = head;
        for(int i = 0; i<= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //Method 6: addFirst(int value) -> adds elements to the start of the linked list
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head = newNode;
        }
        this.size += 1;
    }

    //Method 7: addLast(int value) -> adds the element to the end of the linked list
    public void addLast(int value) {
        Node newNode = new Node(value);
        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size += 1;
    }

    //Method 8: removeFirst() -> removes the first element
    public int removeFirst() throws Exception{
        int rv;
        if(this.isEmpty()) {
            throw new Exception("Linked List is Empty");
        }
        rv = this.head.data;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
        }
        this.size -= 1;
        return rv;
    }

    //Method 9: removeLast() -> removes the last element
    public int removeLast() throws Exception {
        if(this.isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        int rv = this.tail.data;
        Node temp;
        if(this.size == 1) {
            this.head = this.tail = null;
        } else {
            temp =this.head;
            for(int i=0; i<this.size-1;i++) {
                temp = temp.next;
            }
            temp.next = null;
            this.tail = temp;
        }
        this.size -= 1;
        return rv;
    }

    //Method 10: removeAt(int index) -> removes the element at given index
    public int removeAt(int index) throws Exception{
        if(this.isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        if(index < 0 || index > this.size) {
            throw new Exception("Invalid index provied");
        }
        int rv;
        Node temp;
        if(index == 0) {
            return this.removeFirst();
        } else if (index == this.size-1 ) {
            return this.removeLast();
        } else {
            temp = getNodeAt(index-1);
            rv = temp.next.data;
            temp.next = temp.next.next;
            this.size-=1;
        }
        return rv;
    }

    //Method 11: getMiddleNode() -> returns the middle node
    public int getMiddleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    //Method 12: reverseLLByData() -> Reverses the linked list by data
    public void reverseByData() throws Exception {
        int left = 0;
        int right = this.size -1;
        Node leftNode,rightNode;
        int temp;
        while (left < right) {
            leftNode = getNodeAt(left);
            rightNode = getNodeAt(right);
            temp = leftNode.data;
            leftNode.data = rightNode.data;
            rightNode.data = temp;
            left++;
            right--;
        }
    }

    //Method 13: reverseLLByPointers() -> reverses the linked list using pointers

}