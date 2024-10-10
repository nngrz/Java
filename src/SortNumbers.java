import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        int a, b, c;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        s.close();
        System.out.println(a + " " + b + " " + c);

        int temp;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a > c) {
            temp = a;
            a = c;
            c = temp;
        }
        if (b > c) {
            temp = b;
            b = c;
            c = temp;
        }
        System.out.println(a + " " + b + " " + c);
    }
}