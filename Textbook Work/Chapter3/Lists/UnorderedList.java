package School.CIS_18C.Exercises.Chapter_3.Lists;

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

class UnorderedList<T> { // Unordered List Class

    private Node<T> head;
    //private Node<T> tail; // solution to making append O(1)

    public UnorderedList() { /* Construct an empty list */
        this.head = null;
        //this.tail = null;
    }
    
    public Node<T> getHead() { /* Returns the head of the list */
        return this.head;
    }
   
    public void setHead(Node<T> newHead) { /* Sets the head of the list to the given Node */
        this.head = newHead;
    }
   
    public boolean isEmpty() { /* Return true if list is empty, false otherwise */
        return this.head == null;
    }
    
    public void add(T item) { /* Add given item at the head of the list. Presume that the item is not already in the list.*/
        Node<T> temp = new Node<T>(item);
        //Node<T> current = this.head;
        temp.setNext(this.head);
        this.head = temp;
        /*while (current != null) {  // this is for seeing how to modify add to make append O(1)
            current = current.getNext();
        }
        this.tail = current;*/
    }

    public void append(T item){ // sec 21 self check 1 -> O(n)
        Node<T> current = this.head;
        Node<T> newNode = new Node<T>(item);
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    /*public void append(T item){ // sec 21 self check 2 -> O(1)
        Node<T> newNode = new Node<T>(item);
        if (this.head == null) { // if current head is null (list is empty) -> set both this head and this tail to the new Node
            this.head = newNode;
            this.tail = newNode;
        }
        else { // If the list already has existing values and a tail, set the the next node from the tail to the new node and then set the tail to the last node
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }*/

    public int size() { /* Return the number of items in the list */
        Node<T> current = this.head;
        int count = 0;
        while (current != null) {
            count = count + 1;
            current = current.getNext();
        }
        return count;
    }

    
    public boolean search(T item) { /* Check to see if the given item is in the list. Return true if it is, false if not. */
        Node<T> current = this.head;
        while (current != null) {
            if (current.getData().equals(item)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void remove(T item) { /* Remove the given item from the list. Throws a NoSuchElementException if the item is not in the list */
        Node<T> current = this.head;
        Node<T> previous = null;

        while (current != null && (!current.getData().equals(item))) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            if (previous == null) {
                this.head = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
        }
    }

    public String toString() { /* Convert the list to a comma-separated series of values in brackets, starting with the head of the list. */
        String result = "[";
        Node<T> current = this.head;
        while (current != null) {
            result = result + current.getData().toString();
            current = current.getNext();
            if (current != null) {
                result = result + ", ";
            }
        }
        result = result + "]";
        return result;
    }
    

    public static void main(String[] args) { // Testing
        UnorderedList<Integer> myList = new UnorderedList<>();
        System.out.println(myList + " size: " + myList.size());
        myList.add(31);
        myList.add(77);
        myList.add(17);
        myList.add(93);
        myList.add(26);
        myList.add(54);
        System.out.println(myList + " size: " + myList.size());

        System.out.println("search for 17 returns " +
            myList.search(17));
        System.out.println("search for 1066 returns " +
            myList.search(1066));

        myList.remove(93);
        System.out.println("after removing 93: " + myList);

        myList.remove(54); // test removal of last item
        System.out.println("after removing 54: " + myList);

        myList.remove(1066); // remove non-existent item
        System.out.println("after removing 1066: " + myList);
    }

}
