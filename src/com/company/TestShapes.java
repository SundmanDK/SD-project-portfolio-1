package com.company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShapes {
    Triangle triangle = new Triangle(1,1,3,2);
    Circle circle = new Circle(2,1.6,1);
    Square square = new Square(2,3,4,2);

    Point p1 = new Point(1.33, 2);
    Point p2 = new Point(10,10);

    @Test
    public void trianglePointInsideArea(){
        assertTrue(triangle.pointIsInsideArea(p1));
    }

    @Test
    public void trianglePointNotInsideArea(){
        assertFalse(triangle.pointIsInsideArea(p2));
    }

    @Test
    public void triangleArea(){
        double tArea = Math.abs(triangle.getBottomLeft().getX() * (triangle.getTop().getY() - triangle.getBottomRight().getY())
                + triangle.getTop().getX() * (triangle.getBottomRight().getY() - triangle.getBottomLeft().getY())
                + triangle.getBottomRight().getX() * (triangle.getBottomLeft().getY() - triangle.getTop().getY())) / 2;
        assertEquals(tArea, triangle.getArea());
    }

    @Test
    public void triangleCircumference(){
        double AB = Math.sqrt(Math.pow((triangle.getBottomLeft().getX() - triangle.getTop().getX()),2)
                + Math.pow((triangle.getBottomLeft().getY() - triangle.getTop().getY()),2));
        double BC = Math.sqrt(Math.pow((triangle.getTop().getX() - triangle.getBottomRight().getX()),2)
                + Math.pow((triangle.getTop().getY() - triangle.getBottomRight().getY()),2));
        double AC = Math.sqrt(Math.pow((triangle.getBottomLeft().getX() - triangle.getBottomRight().getX()),2)
                + Math.pow((triangle.getBottomLeft().getY() - triangle.getBottomRight().getY()),2));
        double tCircumference = AB + BC + AC;
        assertEquals(tCircumference, triangle.getCircumference());
    }

    @Test
    public void squarePointInsideArea(){
        assertTrue(square.pointIsInsideArea(p1));
    }

    @Test
    public void squarePointNotInsideArea(){
        assertFalse(square.pointIsInsideArea(p2));
    }

    @Test
    public void squareArea(){
        assertEquals((square.length * square.height), square.getArea());
    }

    @Test
    public void squareCircumference(){
        assertEquals((2 * square.length + 2 * square.height), square.getCircumference());
    }

    @Test
    public void circlePointInsideArea(){
        assertTrue(circle.pointIsInsideArea(p1));
    }

    @Test
    public void circlePointNotInsideArea(){
        assertFalse(circle.pointIsInsideArea(p2));
    }

    @Test
    public void circleArea(){
        assertEquals((Math.PI * Math.pow(circle.radius,2)), circle.getArea());
    }

    @Test
    public void circleCircumference(){
        assertEquals((2 * circle.radius * Math.PI), circle.getCircumference());
    }
}
