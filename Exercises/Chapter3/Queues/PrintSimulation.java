package School.CIS_18C.Exercises.Chapter_3.Queues;

/* Self Check:
    How would you modify the printer simulation to reflect a larger number of students?
        A: To reflect a larger number of students, we could increase the chances of there being a task created.
            Instead of having the 1 of 180 chance every second (1 per 3 minutes), we could reduce the time as more students would increase the chances.
            For example 1 / 60 chance per second (1 per 1 minute) for a more populated location.

    Suppose that the number of students was doubled. You may* need to make some reasonable assumptions about how this simulation was put together but what would you change? 
    Modify the code. Also suppose that the length of the average print task was cut in half. Change the code to reflect that change.
        A: If the number of students was doubled, we could cut down the chance in half. Instead of 1/180 chance (1 task per 3 minutes), we would reduce it to 1/90 (1 per 90 seconds).
            To change the length of the average print task, we can halve the time in the startNext formula. Changing 60 -> 30 to half the time

    Finally, how would you parametertize the number of students? Rather than changing the code, we would like to make the number of students a parameter of the simulation.
        A:
*/ 


import java.util.Random;
//import java.util.Queue;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class Queue<T> { // Class for custom represente Queue

    ArrayList<T> items; // The tail of the queue is at the beginning of the ArrayList; the head is the last item

    public Queue() { // Create a new Queue
        this.items = new ArrayList<T>();
    }

    public boolean isEmpty() { // Returns true if there are no items in the queue;false otherwise.
        return (this.items.isEmpty());
    }

    public void enqueue(T item) { // Add an item to the tail of the queue
        this.items.add(0, item);
    }


    public T dequeue() { // Remove the item at the head of the queue and return it. If the queue is empty, throws an exception.
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.items.remove(this.size() - 1);
    }

    public T peek() { // Return the item at the head of the queue, but do not remove it. If the queue is empty, throws an exception.
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.items.get(this.size() - 1);
    }

    public int size() { // Returns the number of items in the queue.
        return this.items.size();
    }
 
    public String toString() { // Convert to string as an array from tail to head

        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            return "tail ->" + arrString + "-> head";
        } else {
            return "<<empty queue>>";
        }
    }
}

public class PrintSimulation { // Print Simulation

    static Random generator = new Random();

    int numSeconds; // time period
    Printer labPrinter;
    Queue<Task> printQueue;
    ArrayList<Integer> waitingTimes;

    
    public PrintSimulation (int numSeconds, int pagesPerMinute) { // Print Simulation object (time period, pages per minute)
        this.numSeconds = numSeconds;
        labPrinter = new Printer(pagesPerMinute); // The "Printer" object 
    }

    public void performSimulation() {
        printQueue = new Queue<Task>(); // Initialize bc not static so it creates new queue every simulation
        waitingTimes = new ArrayList<Integer>(); // Initialize for same reason
        for (int currentSecond = 0; currentSecond < numSeconds; currentSecond++) {
            if (newPrintTask()) {
                Task t = new Task(currentSecond);
                printQueue.enqueue(t);
            }

            if ((!labPrinter.busy()) && (!printQueue.isEmpty())) {
                Task nextTask = printQueue.dequeue();
                waitingTimes.add(nextTask.waitTime(currentSecond));
                labPrinter.startNext(nextTask);
            }

            labPrinter.tick();
        }

        int totalWaitingTime = 0;
        for (int i = 0; i < waitingTimes.size(); i++) {
            totalWaitingTime = totalWaitingTime + waitingTimes.get(i);
        }
        double average_wait = (double) totalWaitingTime / waitingTimes.size();

        System.out.printf("Average wait %6.2f secs. ", average_wait);
        System.out.printf("%d tasks remaining.%n", printQueue.size());
    }

    public boolean newPrintTask() {
        int num = generator.nextInt(90) + 1; // Change the bound from 180 to 90 to increase the chances as the amount of students double
        return (num == 90);
    }

    public static void main(String[] args) {  // Main Function
        PrintSimulation sim = new PrintSimulation(3600, 5); // 
        for (int i = 0; i < 10; i++) {
            sim.performSimulation();
        }
    }
}

class Task {
    int timeStamp; // Timestamp of when task is added
    int pages; // Number of Pages

    static Random generator = new Random(); // The random number generator is static, as it is shared among all tasks.

    public Task(int timeStamp) { // Initialize task object with timestamp
        this.timeStamp = timeStamp;
        this.pages = generator.nextInt(20) + 1; // Give random amount of pages from 1-20 (0-19 + 1)
    }

    public int getPages() { // returns pages
        return this.pages;
    }

    public int waitTime(int currentTime) { // Returns the amount of time waited for ..
        return currentTime - this.timeStamp;
    }
}

class Printer {
    int pageRate; // pages per minute
    int timeRemaining; // Time remaining to finish the task?
    Task currentTask;

    public Printer(int pageRate) { // Create a Printer object with a set pagerate
        this.pageRate = pageRate;
        this.currentTask = null; // no current task to start with
        this.timeRemaining = 0;
    }

    public void tick() {
        if (this.currentTask != null) { // If there is a task, -1 from time remaining
            this.timeRemaining = this.timeRemaining - 1;
            if (this.timeRemaining <= 0) { // When the time remaining to finish the task goes to 0, remove the current task
                this.currentTask = null;
            }
        }
    }

    public boolean busy() { // true = has task object, false = no task object
        return this.currentTask != null;
    }

    public void startNext(Task newTask) { // Change the current task into the new task
        this.currentTask = newTask;
        this.timeRemaining = newTask.getPages() * 60 / this.pageRate; // set the time remaining in seconds (pages * 60) / rate per min -> 10pages * 60seconds = 600 / 5rpm = 120 seconds (2 min)
        // To half the time, we can set 60 to 30 to make the example above 60 seconds -> 10 pages * 60 seconds  =  300 / 5 rate per min  =  60 seconds (1 min)
    }
}
