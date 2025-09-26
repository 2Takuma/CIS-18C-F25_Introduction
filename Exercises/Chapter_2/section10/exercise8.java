package School.CIS_18C.Exercises.Chapter_2.section10;
// Devise an experiment that compares the performance of the remove method on ArrayLists and HashMaps.
import java.util.ArrayList;
import java.util.HashMap;

public class exercise8 {
    public static void main(String[] args) {
        int n = 1_000_000;
        int t = 1_000_000_000;


        ArrayList<Integer> intAL = new ArrayList<>();
        for (int i = 0; i < n; i++) { // Fill int ArrayList
            intAL.add(i);
        }

        HashMap<String, Integer> intHM = new HashMap<>();
        for (int i = 0; i < n; i++) { // Fill int Hashmap
            intHM.put("Key " + i, i);
        }

        System.out.println("Taking out first element: "); // Beginning
        double startTime = System.nanoTime();
        intAL.remove(0);
        double endTime = System.nanoTime();
        double time = (endTime - startTime) / t;
        System.out.println("Time for Arraylist removal: " + time);

        startTime = System.nanoTime();
        intHM.remove(0);
        endTime = System.nanoTime();
        time = (endTime - startTime) / t;
        System.out.println("Time for Hashmap removal: " + time);
        System.out.println(" ");

        System.out.println("Taking out middle element: "); // Middle
        startTime = System.nanoTime();
        intAL.remove(n/2);
        endTime = System.nanoTime();
        time = (endTime - startTime) / t;
        System.out.println("Time for Arraylist removal: " + time);

        startTime = System.nanoTime();
        intHM.remove(n/2);
        endTime = System.nanoTime();
        time = (endTime - startTime) / t;
        System.out.println("Time for Hashmap removal: " + time);
        System.out.println(" ");

        System.out.println("Taking out last element: "); // End
        startTime = System.nanoTime();
        intAL.remove(n-3);
        endTime = System.nanoTime();
        time = (endTime - startTime) / t;
        System.out.println("Time for Arraylist removal: " + time);

        startTime = System.nanoTime();
        intHM.remove(n-3);
        endTime = System.nanoTime();
        time = (endTime - startTime) / t;
        System.out.println("Time for Hashmap removal: " + time);
    }
}
