package School.CIS_18C.Exercises.Chapter_3.Lists;

import java.util.NoSuchElementException;

class Node<T> { // Node Class

    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public String toString() {
        return this.data.toString();
    }
}

class StackAsLinkedList<T> {
    private Node<T> head;

    public StackAsLinkedList(){
        this.head = null;
    }

    public void push(T item) {
        Node<T> temp = new Node<T>(item);
        temp.setNext(this.head);
        this.head = temp;
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Node<T> temp = this.head;
        this.head = this.head.getNext();
        return temp.getData();
    }

    public int size() { // Returns the number of items in the queue.
        if (this.isEmpty()) {
            return 0;
        }
        int count = 1;
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.head.getData();
    }

    public boolean isEmpty() { /* Return true if list is empty, false otherwise */
        return this.head == null;
    }

    public String toString() { // Convert to string as an array from tail to head
        if (this.isEmpty()) {
            return "Queue is empty.";
        }
        String qString = "head ->[ ";
        Node<T> current = this.head;
        while (current != null) {
            qString = qString + current.getData();
            if (current.getNext() != null) {
                qString = qString + ", ";
            }
            current = current.getNext();
        }
        qString = qString + " ] <- tail";
        return qString;
    }

    public static void main(String[] args) {
        StackAsLinkedList<Integer> myStack = new StackAsLinkedList<>();
        System.out.println("Is empty: " + myStack.isEmpty());
        myStack.push(15);
        myStack.push(93);
        myStack.push(67);
        myStack.push(88);

        System.out.println("Item at head: " + myStack.peek());
        System.out.println(myStack.toString());
        System.out.println("Is empty: " + myStack.isEmpty());
        System.out.println("Size: " + myStack.size());

        myStack.pop();
        myStack.pop();

        System.out.println("Item at head: " + myStack.peek());
        System.out.println(myStack.toString());
        System.out.println("Size: " + myStack.size());
    }
}
