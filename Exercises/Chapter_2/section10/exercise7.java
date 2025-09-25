package School.CIS_18C.Exercises.Chapter_2.section10;
import java.util.HashMap;

public class exercise7 { // Not the greatest experiment but it technically works (don't want every key to be the same)
    public static void main(String[] args) { // Experiment to test that the get and put functions for hashmaps run at O(1)
        HashMap<String, Integer> products = new HashMap<>();
        
        for (int i = 0; i < 1_000_000; i++) {
            products.put("Key " + i, i);
        }
        
        System.out.println("Put:");
        double startTime = System.nanoTime();
        products.put("Key 1000001", 1_000_001);
        double endTime = System.nanoTime();
        double time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time to put: " + time + " seconds");

        startTime = System.nanoTime();
        products.put("Key 1000002", 1_000_002);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time to put: " + time + " seconds");

        startTime = System.nanoTime();
        products.put("Key 1000003", 1_000_003);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time to put: " + time + " seconds");

        startTime = System.nanoTime();
        products.put("Key 1000004", 1_000_004);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time to put: " + time + " seconds");
        
        System.out.println("Get:");

        startTime = System.nanoTime();
        products.get("Key 1000");
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time to get: " + time + " seconds");

        startTime = System.nanoTime();
        products.get("Key 100000");
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time to get: " + time + " seconds");

        startTime = System.nanoTime();
        products.get("1000000");
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000;
        System.out.println("Time to get: " + time + " seconds");

    }
} // Aftr looking at the time it takes to put and get values from the hashmap, they generally run at the same time not matter which item O(1)
