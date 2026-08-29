

class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
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

public class Generic {
    public static void main(String[] args) {

        Box<String> box = new Box<>();
        box.setValue("Hello");
        String result = box.getValue();
        System.out.println(result);

        Box<Integer> box2 = new Box<>();
        box2.setValue(2);
        Integer result2 = box2.getValue();
        System.out.println(result);


        Pair<String, Integer> student = new Pair<>();

        student.setFirst("Alice");
        student.setSecond(95);

        System.out.println(student.getFirst());
        System.out.println(student.getSecond());
    }
}
