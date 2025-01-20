class CalculatingDevice {
    protected String name;

    CalculatingDevice(String name) {
        this.name = name;
    }
    
    // Calculate the sum of arguments and return a string
    public String sum(double x, double y) {
        return x + "+" + y + "=" + (x + y);
    }

    public String calculate(double x, double y) {
        return name + ": " + sum(x, y);
    }

    public static void printRes(CalculatingDevice[] a, double x, double y) {
        for (CalculatingDevice device : a) {
            System.out.println(device.calculate(x, y));
        }
    }
}

class Calculator extends CalculatingDevice {
    public Calculator(String name) {
        super(name);
    }

    // Calculate the subtraction of arguments and return a string
    public String subtraction(double x, double y) {
        return x + "-" + y + "=" + (x - y);
    }

    // Get result of addition by invoking super.calculate and add the result of subtraction
    @Override
    public String calculate(double x, double y) {
        return super.calculate(x, y) + "; " + subtraction(x, y);
    }
}

class Computer extends Calculator {
    public Computer(String name) {
        super(name);
    }

    // Calculate the multiplication of arguments and return a string
    public String multiplication(double x, double y) {
        return x + "*" + y + "=" + x * y;
    }

    // Calculate the division of arguments and return a string
    public String division(double x, double y) {
        // Special case: if y = 0, the division calculation is invalid
        if (y == 0) {
            return "Division by zero error";
        } else {
            return x + "/" + y + "=" + x / y;
        }
    }

    // Get result of addition and subtraction by invoking super.calculate and add the result of multiplication and division
    @Override
    public String calculate(double x, double y) {
        return super.calculate(x, y) + "; " + multiplication(x, y) + "; "+ division(x, y);
    }
}

public class Computers {
    public static void main (String[] args) {
        CalculatingDevice[] arr = {
            new Computer("Cray"),
            new CalculatingDevice("Abacus"),
            new Calculator("HP")
        };

        CalculatingDevice.printRes(arr, 21, 7);
    }
}
