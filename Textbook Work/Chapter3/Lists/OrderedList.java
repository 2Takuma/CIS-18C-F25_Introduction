package School.CIS_18C.Exercises.Chapter_3.Lists;

class OrderedList<T extends Comparable<T>> extends UnorderedList<T> {

    // No extra properties in this class; they are inherited from UnorderedList

    public OrderedList() { // Call superclass constructor to set the head property to null.
        super();
    }

    public void add(T item) { // Add given item at its correct position in the list. Presume that the item is not already in the list.
        Node<T> current = this.getHead();
        Node<T> previous = null;

        while (current != null && (current.getData()).compareTo(item) < 0) {
            previous = current;
            current = current.getNext();
        }
        Node<T> itemNode = new Node<T>(item);

        if (previous == null)
        {
            itemNode.setNext(this.getHead());
            this.setHead(itemNode);
        } else {
            itemNode.setNext(current);
            previous.setNext(itemNode);
        }
    }
    
    public boolean search(T item) { // Check to see if the given item is in the list. Return true if it is, false if not.
        Node<T> current = this.getHead();
        while (current != null) {
            if (current.getData().equals(item)) {
                return true;
            }
            if (current.getData().compareTo(item) > 0) {
                return false;
            }
            current = current.getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        OrderedList<Integer> myList = new OrderedList<>();

        System.out.println("Is list empty? " + myList.isEmpty());
        myList.add(505);
        myList.add(217);
        myList.add(1066);
        System.out.println("After adding 505, 217, and 1066: " + myList);
        System.out.println("Is 505 in the list? " + myList.search(505));
        System.out.println("Is 300 in the list? " + myList.search(300));
    }
    
}