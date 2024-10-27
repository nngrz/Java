import java.util.Scanner;

public class LongestSequence {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner s = new Scanner(System.in);
        int currentNumber;
        int lastNumber = 0;
        int currentCount = 0;
        int longestNumber = 0;
        int longestCount = 0;

        do {
            currentNumber = s.nextInt();

            if (currentNumber == lastNumber) {
                currentCount = currentCount + 1;
            } else {
                lastNumber = currentNumber;
                currentCount = 1;
            }

            if (currentCount > longestCount) {
                longestCount = currentCount;
                longestNumber = currentNumber;
            }
        } while (currentNumber != 0);
        s.close();

        if (longestCount > 1) {
            System.out.println("Longest sequence: " + longestCount + " times " + longestNumber);
        } else {
            System.out.println("Longest sequence: 1 time " + longestNumber);
        }
    }
}
