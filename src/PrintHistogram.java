import java.util.Scanner;

public class PrintHistogram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number1, number2, number3;
        System.out.println("Enter three non-negative integers:");
            number1 = s.nextInt();
            number2 = s.nextInt();
            number3 = s.nextInt();

        // check if user inputs are non-negative integers
        if (number1 >= 0 && number2 >= 0 && number3 >= 0) {
            System.out.println("Your inputs are: " + number1 + " " + number2 + " " + number3);
        } else {
            System.out.println("Invalid input, please enter three positive integers");
            number1 = s.nextInt();
            number2 = s.nextInt();
            number3 = s.nextInt();
            System.out.println("Your inputs are: " + number1 + " " + number2 + " " + number3);
        }
        s.close();

        System.out.println("Your histogram is: ");
        int height = Math.max(number1, Math.max(number2, number3));
        for (int i = height; i > 0; i--) {
            System.out.print(number1 >= i ? "* " : "  ");
            System.out.print(number2 >= i ? "* " : "  ");
            System.out.println(number3 >= i ? "* " : "  ");
        }
    }
}
