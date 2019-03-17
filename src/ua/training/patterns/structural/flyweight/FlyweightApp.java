
package ua.training.patterns.structural.flyweight;

import java.util.*;

public class FlyweightApp {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("точка"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));

        Random random = new Random();
        for (Shape shape : shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x, y);
        }
    }

}

//Flyweight
interface Shape {
    void draw(int x, int y);
}

//Point Flyweight
class Point implements Shape {
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем точку");
    }
}

//Circle Flyweight
class Circle implements Shape {
    int r = 5;

    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем круг радиусом " + r);
    }
}

//Square Flyweight
class Square implements Shape {
    int a = 10;

    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем квадрат со стороной " + a);
    }
}

class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();

    public Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);

        if (shape == null) {
            switch (shapeName) {
                case "точка":
                    shape = new Point();
                    break;
                case "круг":
                    shape = new Circle();
                    break;
                case "квадрат":
                    shape = new Square();
                    break;
            }
            shapes.put(shapeName, shape);
        }

        return shape;
    }
}
