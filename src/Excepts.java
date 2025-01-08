import java.util.Random;

// Custom checked exception
public class NotEnoughGas extends Exception {
    public NotEnoughGas(String message) {
        super(message);
    }
}

// Custom unchecked exception
public class Explosion extends RuntimeException {
    public Explosion(String message) {
        super(message);
    }
}

class Car {
    private int fuel;
    private int kilometers;
    private Random random;

    public Car() {
        this.fuel = 35;
        this.kilometers = 0;
        this.random = new Random();
    }

    public void fill() {
        if (random.nextInt(10) == 0) {
            throw new Explosion("BOOOOOOM!");
        }

        int randomFillofFuel = random.nextInt(35 - 15 + 1) + 15;
        this.fuel += randomFillofFuel;
        System.out.println("After filling " + fuel);
    }

    public void drive100km() throws NotEnoughGas {
        if (fuel < 10) {
            throw new NotEnoughGas("Only " + fuel + " liters. Must fill the tank");
        }

        // Consume 10 litres of fuel and increase 100 kilometers
        fuel -= 10;
        kilometers += 100;

        System.out.println(kilometers + "km driven, " + fuel + " liters left");
    }
}

public class Excepts {
    public static void main (String[] args) {
        Car car = new Car();
        while (true) {
            try {
                car.drive100km();
            } catch(NotEnoughGas e) {
                System.err.println(e.getMessage());
                car.fill();
            }
        }
    }
}
