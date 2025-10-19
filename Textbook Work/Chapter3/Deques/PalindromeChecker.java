package School.CIS_18C.Exercises.Chapter_3.Deques;

import java.util.NoSuchElementException;
import java.util.ArrayList;

class Deque<T> {

    ArrayList<T> items;

    public Deque() {
        this.items = new ArrayList<T>();
    }


    public boolean isEmpty() {
        return (this.items.isEmpty());
    }

    public void addHead(T item) {
        this.items.add(item);
    }


    public void addTail(T item) {
        this.items.add(0, item);
    }

    public T removeHead() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.remove(this.size() - 1);
    }

    public T removeTail() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.remove(0);
    }

    public T peekHead() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.get(this.size() - 1);
    }

    public T peekTail() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.get(0);
    }

    public int size() {
        return this.items.size();
    }

    public String toString() {

        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            return "tail " + arrString + " head";
        } else {
            return "<<empty deque>>";
        }
    }
}

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        Deque<String> charDeque = new Deque<String>();
        
        String[] noSpaces = str.split("");

        for (int i = 0; i < str.length(); i++) {
            charDeque.addHead(noSpaces[i]);
        }

        while (charDeque.size() > 1) {
            String first = charDeque.removeHead();
            String last = charDeque.removeTail();
            if (!first.equals(last)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is \"regular\" a palindrome? " +
            isPalindrome("regular"));
        System.out.println("Is \"rotator\" a palindrome? " +
            isPalindrome("rotator"));
        System.out.println("Is \"i prefer pi\" a palindrome? " +
            isPalindrome("deed"));
    }
}
