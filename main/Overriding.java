package main;

public class Overriding {

    public static void main(String[] args) {

        Shape obj = new Circle(20.0);
        obj.area();

        Shape obj2 = new Rectangle(10, 20);
        obj2.area();
    }
}

class Shape {

    void area() {
    }
}

class Circle extends Shape {

    private double r;

    Circle(double r) {
        this.r = r;
    }

    void area() {
        System.out.println("Area of Circle = " + (3.14 * r * r));
    }
}

class Rectangle extends Shape {

    private double l, b;

    Rectangle(double l, double b) {
        this.l = l;
        this.b = b;
    }

    void area() {
        System.out.println("Area of Rectangle = " + (l * b));
    }
}