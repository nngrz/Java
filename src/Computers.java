public class CalculatingDevice {
    protected String name;

    CalculatingDevice(String name) {
        this.name = name;
    }
    
    public String calculate(double x, double y) {
        double sum = x + y;
        return name + ": " + x + "+" + y + "=" + sum;
    }

    public static void printRes(CalculatingDevice[] a, double x, double y) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].calculate(x, y));
        }
    }
}

public class Calculator extends CalculatingDevice {
    public Calculator(String name) {
        super(name);
    }

    @Override
    public String calculate(double x, double y) {
        String additionResult = super.calculate(x, y);
        double sub = x - y;
        return additionResult + "; " + x + "-" + y + "=" + sub;
    }
}

public class Computer extends Calculator {
    public Computer(String name) {
        super(name);
    }

    @Override
    public String calculate(double x, double y) {
        String additionAndSubtraction = super.calculate(x, y);
        double multiplication = x * y;
        if (y == 0) {
            return "Division by zero error";
        } else {
            double division = x / y;
            return additionAndSubtraction + "; " + x + "*" + y + "=" + multiplication + ";" + x + "/" + y + "=" + division;
        }
    }
}

public class Computers {
    public static void main (String[] args) {
        CalculatingDevice[] arr = {
            new Computer("Cray"),
            new CalculatingDevice("Abacus"),
            new Calculator("HP")
        };

        CalculatingDevice.printRes(arr, 21, 0);
    }
}
