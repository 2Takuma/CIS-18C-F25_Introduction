//Given a list of numbers in random order, write an algorithm that works in O(nlog(n)) to find the kth smallest number in the list.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class exercise9 {
        public static void main(String[] args) {
            int n = 1_000_000;
            int id2Get = n-4;
            Random rand = new Random();

            ArrayList<Integer> intAL = new ArrayList<>();
            for (int i = 0; i < n; i++) { // Fill int ArrayList
            intAL.add(rand.nextInt(n));
            }
            double startTime = System.nanoTime();
            Collections.sort(intAL);
            intAL.get(id2Get);
            double endTime = System.nanoTime();
            double time = (endTime - startTime) / 1_000_000_000;
            

            System.out.println("Time to sort and get item at index " + id2Get + ": " + time + " seconds." );
        }
} // Sort the list first then search


// Exercise 10 inclusions: Can you improve the algorithm from the previous problem to be linear? Explain.
/* Yes. We can improve the algorithm from the previous problem by using a different selection method
 */

