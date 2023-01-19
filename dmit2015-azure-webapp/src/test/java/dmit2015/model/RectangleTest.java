package dmit2015.model;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @org.junit.jupiter.api.Test
    void area() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10);
        rectangle.setWidth(5);
        assertEquals(50, rectangle.area());
    }

    @org.junit.jupiter.api.Test
    void perimeter() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10);
        rectangle.setWidth(5);
        assertEquals(30, rectangle.perimeter());
    }

    @org.junit.jupiter.api.Test
    void diagonal() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10);
        rectangle.setWidth(5);
        assertEquals(11.18, rectangle.diagonal(), 0.01);
    }
}