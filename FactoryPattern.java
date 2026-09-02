interface Shape {
    void draw();
}

// Shapes
class Circle implements Shape {

    @Override
    public void draw() {
        // TODO 1:
        // 打印 "Drawing Circle"
        System.out.println("Drawing circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        // TODO 2:
        // 打印 "Drawing Rectangle"
        System.out.println("Drawing Rectangle");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

// Tools
class Toolbar {

    public void drawShape(String type) {

        Shape shape = ShapeFactory.createShape(type);

        shape.draw();
    }
}

class FileLoader {

    public void fileShape (String type) {

        return ShapeFactory.createShape(type);
    }
}

// Shape Factory
class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (type.equalsIgnoreCase("triangle")) {
            return new Triangle();
        }

        throw new IllegalArgumentException("Unknown shape: " + type);
    }
}

public class FactoryPattern {
    public static void main(String[] args) {

        String type = "circle";

        Shape shape = ShapeFactory.createShape(type);

        shape.draw();
    }
}
