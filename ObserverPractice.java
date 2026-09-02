import java.util.ArrayList;
import java.util.List;

class Counter {

    private int count = 0;
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void increment() {
        count++;
        System.out.println("Counter = " + count);

        for (Observer observer : observers) {
            observer.update(count);
        }
    }
}

interface Observer {
    void update(int value);
}

class CounterView implements Observer {

    @Override
    public void update(int value) {
        System.out.println("CounterView updated = " + value);
    }
}

class GraphicView implements Observer {

    @Override
    public void update(int value) {
        System.out.println("Graphic View updated = " + value);

        for (int i = 0; i < value; i++) {
            System.out.print("*");
        }

         System.out.println();
    }
}

public class ObserverPractice {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Observer observer1 = new CounterView();
        Observer observer2 = new GraphicView();
        counter.addObserver(observer1);
        counter.addObserver(observer2);

        counter.increment();
        counter.increment();
    }
}
