import java.lang.reflect.Method;

class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void print() {
        System.out.println(value);
    }
}

class Pair<K, V> {
    private K first;
    private V second;

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}

class Animal {
    public void speak() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {
    private String name;

    public Dog() {

    }

    @Override
    public void speak() {
        System.out.println("Dog");
    }

    public void bark() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Cat");
    }
}

public class Generic {
    public static void main(String[] args) {

        // Box<String> box = new Box<>();
        // box.setValue("Hello");
        // String result = box.getValue();
        // System.out.println(result);

        // Box<Integer> box2 = new Box<>();
        // box2.setValue(2);
        // Integer result2 = box2.getValue();
        // System.out.println(result);


        // Pair<String, Integer> student = new Pair<>();

        // student.setFirst("Alice");
        // student.setSecond(95);

        // System.out.println(student.getFirst());
        // System.out.println(student.getSecond());

        // Box<Animal> animalBox = new Box<>();

        // animalBox.setValue(new Dog());

        // Animal a = animalBox.getValue();

        // a.speak();

        // Box<Dog> dogBox = new Box<>();
        // dogBox.setValue(new Dog());

        // Box<? extends Animal> animalBox2 = dogBox;
        // Animal animal = animalBox2.getValue();
        // animal.speak();

        // Reflection
        Dog dog = new Dog();
        // dog.bark();

        Class<Dog> clazz = Dog.class;
        // System.out.println(clazz);
        // System.out.println(clazz.getName());
        // System.out.println(clazz.getSimpleName());
        // System.out.println("Methods:");

        try {
            Method method = clazz.getDeclaredMethod("bark");
            method.invoke(dog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: composite practice
}
