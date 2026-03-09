/**
 * Lab 2: String Antics
 * This class has methods to check words and sentences:
 * - palindrome (same forward/backward)
 * - abecedarian (letters in A to Z order)
 * - pangram (has all 26 letters)
 * - capitalizeFirstLetter
 * @author Kelvin Myat (isPalindrome, isAbecedarian)
 * @author Nikolas (isPangram, capitalizeFirstLetter)
 */
public class Antics {

    /**
     * Checks if a string is a palindrome.
     * It ignores uppercase/lowercase.
     * @param s the word to check
     * @return true if it is a palindrome, false if not
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        String text = s.toLowerCase();
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Checks if a word is abecedarian (letters in A to Z order).
     * Example: accent (true), almost (false)
     * @param s the word to check
     * @return true if letters are in order, false otherwise
     */
    public static boolean isAbecedarian(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        String text = s.toLowerCase();

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) > text.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if a sentence is a pangram (has all 26 letters a to z).
     * Ignores case and ignores spaces/punctuation.
     * @param s the sentence to check
     * @return true if it contains all 26 letters, false otherwise
     */
    public static boolean isPangram(String s) {
        if (s == null) {
            return false;
        }

        boolean[] seen = new boolean[26]; 
        int count = 0;

        String text = s.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                int index = c - 'a'; 
                if (!seen[index]) {
                    seen[index] = true;
                    count++;
                }
            }
        }

        return count == 26;
    }

    /**
     * Makes only the first letter uppercase.
     * Example: "california" to "California"
     * @param s the word to change
     * @return the word with the first letter capitalized
     */
    public static String capitalizeFirstLetter(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String first = s.substring(0, 1).toUpperCase();
        String rest = s.substring(1);

        return first + rest;
    }
}