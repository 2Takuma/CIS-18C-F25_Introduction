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

class DequeAsLinkedList<T> {
    private Node<T> head;

    public DequeAsLinkedList() {
        this.head = null;
    }

    public void pushFront(T item) { // add to front
        Node<T> temp = new Node<T>(item);
        temp.setNext(this.head);
        this.head = temp;
    }
    
    public void pushBack(T item) { // add to back
        Node<T> temp = new Node<T>(item);
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
    }

    public T popFront() { // remove from front
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Node<T> temp = this.head;
        this.head = this.head.getNext();
        return temp.getData();
    }

    public T popBack() { // remove from back
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Node<T> current = this.head;
        Node<T> previous = null;
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(null);

        return current.getData();
    }

    public T peekFront() {
        return this.head.getData();
    }

    public T peekBack() {
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean isEmpty() { /* Return true if list is empty, false otherwise */
        return this.head == null;
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
        DequeAsLinkedList<Integer> myDeque = new DequeAsLinkedList<>();
        System.out.println("Is empty: " + myDeque.isEmpty());
        myDeque.pushFront(10);
        myDeque.pushFront(5);
        myDeque.pushBack(15);
        myDeque.pushBack(20);

        System.out.println(myDeque.toString());
        System.out.println("Item at head: " + myDeque.peekFront());
        System.out.println("Item at tail: " + myDeque.peekBack());
        System.out.println("Is empty: " + myDeque.isEmpty());
        System.out.println("Size: " + myDeque.size());

        myDeque.popFront();
        myDeque.popBack();

        System.out.println("Item at head: " + myDeque.peekFront());
        System.out.println("Item at tail: " + myDeque.peekBack());
        System.out.println(myDeque.toString());
        System.out.println("Size: " + myDeque.size());
    }
}

