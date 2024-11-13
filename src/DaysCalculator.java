import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year, month;
        int days;
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

        switch (month) {
            // Month with 31 days
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;

            // Month with 30 days
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;

            // February: 28 or 29 days depending on the leap year
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days = 29; // Leap year
                } else {
                    days = 28; // Not a leap year
                }
                break;

            default:
                days = 0;
        }
        System.out.println("There are " + days + " days in month " + month + " of year " + year + ".");
    }
}
