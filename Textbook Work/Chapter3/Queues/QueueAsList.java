package School.CIS_18C.Exercises.Chapter_3.Queues;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class QueueAsList<T> {
    ArrayList<T> qList;
    
    public QueueAsList() {
        this.qList = new ArrayList<T>();
    }

    public void enqueue(T item) { // Add an item to the tail of the queue
        this.qList.add(0, item);
    }

    public T dequeue() { // Remove the item at the head of the queue and return it. If the queue is empty, throws an exception.
        if (this.qList.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T item = this.qList.get(this.qList.size() - 1);
        this.qList.remove(this.qList.size() - 1);
        return item;
    }

    public T peek() { // Return the item at the head of the queue, but do not remove it. If the queue is empty, throws an exception.
        if (this.qList.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.qList.get(0);
    }

    public int size() { // Returns the number of items in the queue.
        if (this.qList.isEmpty()) {
            return 0;
        }
        return this.qList.size();
    }

    public boolean isEmpty() { /* Return true if list is empty, false otherwise */
        return this.qList.isEmpty();
    }

    public String toString() { // Convert to string as an array from tail to head
        if (this.isEmpty()) {
            return "Queue is empty.";
        }
        String twoStr = "tail --> [ ";
        for (int i = 0; i < this.qList.size(); i++){
            twoStr = twoStr + this.qList.get(i);
            if (i != this.qList.size() - 1){
                twoStr = twoStr + ", ";
            }
        }
        twoStr = twoStr + " ] <-- head";
        return twoStr;
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

