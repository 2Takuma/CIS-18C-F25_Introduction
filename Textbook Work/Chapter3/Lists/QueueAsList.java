package School.CIS_18C.Exercises.Chapter_3.Lists;

import java.util.NoSuchElementException;

// could add just add java util arraylist and list
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

class QueueAsList<T> {
    private Node<T> tail;

    public QueueAsList() {
        this.tail = null;
    }

    public void enqueue(T item) { // Add an item to the tail of the queue
        Node<T> temp = new Node<T>(item);
        temp.setNext(this.tail);
        this.tail = temp;
    }

    public T dequeue() { // Remove the item at the head of the queue and return it. If the queue is empty, throws an exception.
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Node<T> current = this.tail;
        Node<T> previous = null;
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(null);

        return current.getData();
    }

    public T peek() { // Return the item at the head of the queue, but do not remove it. If the queue is empty, throws an exception.
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Node<T> current = this.tail;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }

    public int size() { // Returns the number of items in the queue.
        if (this.isEmpty()) {
            return 0;
        }
        int count = 1;
        Node<T> current = this.tail;
        while (current.getNext() != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }
   
    public boolean isEmpty() { /* Return true if list is empty, false otherwise */
        return this.tail == null;
    }

    public String toString() { // Convert to string as an array from tail to head
        if (this.isEmpty()) {
            return "Queue is empty.";
        }
        String qString = "tail ->[ ";
        Node<T> current = this.tail;
        while (current != null) {
            qString = qString + current.getData();
            if (current.getNext() != null) {
                qString = qString + ", ";
            }
            current = current.getNext();
        }
        qString = qString + " ] <- head";
        return qString;
    }

    public static void main(String[] args) {
        QueueAsList<Integer> myQList = new QueueAsList<>();
        System.out.println("Is empty: " + myQList.isEmpty());
        myQList.enqueue(17);
        myQList.enqueue(55);
        myQList.enqueue(39);
        myQList.enqueue(2);
        myQList.enqueue(93);

        System.out.println("Item at head: " + myQList.peek());
        System.out.println(myQList.toString());
        System.out.println("Is empty: " + myQList.isEmpty());
        System.out.println("Size: " + myQList.size());

        myQList.dequeue();
        myQList.dequeue();

        System.out.println("Item at head: " + myQList.peek());
        System.out.println(myQList.toString());
        System.out.println("Size: " + myQList.size());
    }
}
