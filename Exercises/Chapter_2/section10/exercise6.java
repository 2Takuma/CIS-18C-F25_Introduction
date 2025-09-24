package School.CIS_18C.Exercises.Chapter_2.section10;

import java.util.ArrayList;

public class exercise6 { // Devise an experiment to verify that the Arraylist indexOf method is O(n)

    public static void main(String[] args) {
        ArrayList<Integer> intAL = new ArrayList<>();
        int numbrs = 50_000_000;

        for (int i = 0; i < numbrs; i++) {
            intAL.add(i);
        }
        
        double startTime = System.nanoTime();
        int index1 = intAL.indexOf(4_999_999);
        System.out.println("Index 1: " + index1);
        double endTime = System.nanoTime();
        double time = (endTime-startTime) / 1_000_000_000;
        System.out.println(time + " seconds");

        startTime = System.nanoTime();
        int index2 = intAL.indexOf(49_999_999);
        System.out.println("Index 2: " + index2);
        endTime = System.nanoTime();
        time = (endTime-startTime) / 1_000_000_000;
        System.out.println(time + " seconds");
    }

}

