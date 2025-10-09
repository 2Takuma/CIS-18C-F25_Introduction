import java.util.Random; // exercise 16

public class HotPotatoSimulation {

    public static String hotPotato(String[] nameList) { // removed integer parameter
        Queue<String> simQueue = new Queue<>();
        Random random = new Random(); // For e16, added random object and int variable
        int num;
        for (String name: nameList) {
            simQueue.enqueue(name);
        }

        while (simQueue.size() > 1) {
            // pass the potato: move person at head to tail
            num = random.nextInt(20) + 6; // For e16, the number of passes will vary from 5-25
            for (int pass = 0; pass < num; pass++) {
                simQueue.enqueue(simQueue.dequeue());
            }

            String removed = simQueue.dequeue(); // remove person at head
            System.out.println(removed + " is out of the game.");
        }
        return simQueue.dequeue();
    }

    public static void main(String[] args) {
        String[] people = {"Bill", "David", "Susan", "Jane",
            "Kent", "Brad"};
        String lastPerson = hotPotato(people);
        System.out.println("Last person is " + lastPerson + ".");
    }
}
