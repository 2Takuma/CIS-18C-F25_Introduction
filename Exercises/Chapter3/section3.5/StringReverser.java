public class StringReverser {

    public static String reverseString(String str) {
        // your code here; returns a String
        Stack<Character> rsStack = new Stack<>();
        String rs = "";
            
        for (int i = 0; i < str.length(); i++){
            rsStack.push(str.charAt(i));
        }
        
        for (int i = 0; i < str.length(); i++){
            rs = rs + rsStack.pop();
        }
        
        return rs; // placeholder
    }

    public static void testEqual(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.printf("%s and %s are equal.%n", str1, str2);
        } else {
            System.out.printf("%s and %s are not equal.%n", str1, str2);
        }
    }

    public static void main(String[] args) {
        testEqual(reverseString("apple"), "elppa");
        testEqual(reverseString("x"), "x");
        testEqual(reverseString("1234567890"), "0987654321");
    }
}
