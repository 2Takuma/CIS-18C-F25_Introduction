package School.CIS_18C.Exercises.Chapter_3.Lists;

import java.util.ArrayList;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> myAL = new ArrayList<>();
        UnorderedList myUL = new UnorderedList<>();

        double startTime = System.nanoTime();
        myAL.add(100_000_000);
        myAL.add(200_000_000);
        myAL.add(300_000_000);
        double endTime = System.nanoTime();
        double time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time for Add to ArrayList: " + time);

        startTime = System.nanoTime();
        myUL.add(100_000_000);
        myUL.add(200_000_000);
        myUL.add(300_000_000);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time for Add to Unordered List: " + time);

    }   // Can add more benchmark stuff
}
