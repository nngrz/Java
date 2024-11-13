import java.util.Scanner;

public class DaysCalculator {
    public static void main(String[] args) {
        int year, month;
        int days = 0;
        Scanner s = new Scanner(System.in);

        // Get input of the year
        System.out.println("Enter a year after 1582: ");
        do {
            year = s.nextInt();
            if (year <= 1582) {
                System.out.println("Invalid year, please enter a year greater than 1582. Try again.");
            }
        } while (year <= 1582);

        // Get input of the month
        System.out.println("Enter a month: ");
        do {
            month = s.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Invalid month, please enter a valid month between 1 and 12. Try again.");
            }
        } while (month < 1 || month > 12);
        s.close();

        // Count the number of days
        switch (month) {
            // Month with 31 days
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;

            // Month with 30 days
            case 4, 6, 9, 11 -> days = 30;

            // February: 28 or 29 days depending on the leap year
            case 2 -> days = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
        }

        System.out.println("There are " + days + " days in month " + month + " of year " + year + ".");
    }
}
