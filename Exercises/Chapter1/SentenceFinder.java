import java.util.Random;

public class SentenceFinder {
    static String target = "methinks it is like a weasel"; 
    static String alphabet = "abcedefghijklmnopqrstuvwxyz ";
    static Random r = new Random();

    public static String generate(){ // generate random string
        StringBuilder sb = new StringBuilder(); // sb for stringbuilder

        for (int i = 0; i < target.length(); i++) { 
            int index = r.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));

        }
        return sb.toString();
    }

    public static int score(String sentence) { // score for how many letter match
        int m = 0;
        for (int i = 0; i < target.length(); i++){
            if (sentence.charAt(i) == target.charAt(i)) {
                m++;
            }
        }
        return m;
    }

    public static void main(String[] args) { // main
        String closest = generate(); // closest string
        int cScore = score(closest); // closest string's score

        int attempts = 0;
        while (cScore < target.length()) {
            String randString = generate();
            int randScore = score(randString);

            if (randScore > cScore) {
                closest = randString;
                cScore = randScore;
            }
            attempts++;
            if (attempts % 1000 == 0) { // show stats every 1000 attempts
                System.out.println("Attempt " + attempts + ": " + randString + " (Score: " + cScore + ")");
            }

        }
        System.out.println("Found sentence after " + attempts + " attempts.");

    }
}
