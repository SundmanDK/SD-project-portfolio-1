package com.company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShapes {
    double tX = 1;
    double tY = 1;
    double cX = 2;
    double cY = 1.6;
    double sX = 2;
    double sY = 3;
    Triangle triangle = new Triangle(tX, tY,3,2);
    Circle circle = new Circle(cX, cY,1);
    Square square = new Square(sX, sY,4,2);

    Point p1 = new Point(1.33, 2);
    Point p2 = new Point(10,10);

    //Area tests:
    @Test
    public void triangleArea(){
        double tArea = Math.abs(triangle.getBottomLeft().getX() * (triangle.getTop().getY() - triangle.getBottomRight().getY())
                + triangle.getTop().getX() * (triangle.getBottomRight().getY() - triangle.getBottomLeft().getY())
                + triangle.getBottomRight().getX() * (triangle.getBottomLeft().getY() - triangle.getTop().getY())) / 2;
        assertEquals(tArea, triangle.getArea());
    }

    @Test
    public void circleArea(){
        assertEquals((Math.PI * Math.pow(circle.radius,2)), circle.getArea());
    }

    @Test
    public void squareArea(){
        assertEquals((square.length * square.height), square.getArea());
    }

    //Circumference tests:
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
    public void circleCircumference(){
        assertEquals((2 * circle.radius * Math.PI), circle.getCircumference());
    }

    @Test
    public void squareCircumference(){
        assertEquals((2 * square.length + 2 * square.height), square.getCircumference());
    }

    //Point inside area tests:
    @Test
    public void trianglePointInsideArea(){
        assertTrue(triangle.pointIsInsideArea(p1));
    }

    @Test
    public void circlePointInsideArea(){
        assertTrue(circle.pointIsInsideArea(p1));
    }

    @Test
    public void squarePointInsideArea(){
        assertTrue(square.pointIsInsideArea(p1));
    }

    //Point not inside area tests:
    @Test
    public void trianglePointNotInsideArea(){
        assertFalse(triangle.pointIsInsideArea(p2));
    }

    @Test
    public void squarePointNotInsideArea(){
        assertFalse(square.pointIsInsideArea(p2));
    }

    @Test
    public void circlePointNotInsideArea(){
        assertFalse(circle.pointIsInsideArea(p2));
    }

    //showing that distanceBetweenShapes works both ways for all shapes:
    @Test
    public void distanceBetweenCircleAndSquare(){
        assertEquals(circle.distanceBetweenShapes(square), Math.sqrt(Math.pow((cX - sX),2) + Math.pow((cY - sY),2)));
        assertEquals(square.distanceBetweenShapes(circle), Math.sqrt(Math.pow((sX - cX),2) + Math.pow((sY - cY),2)));
    }

    @Test
    public void distanceBetweenCircleAndTriangle(){
        assertEquals(circle.distanceBetweenShapes(triangle), Math.sqrt(Math.pow((cX - tX),2) + Math.pow((cY - tY),2)));
        assertEquals(triangle.distanceBetweenShapes(circle), Math.sqrt(Math.pow((tX - cX),2) + Math.pow((tY - cY),2)));
    }

    @Test
    public void distanceBetweenTriangleAndSquare(){
        assertEquals(triangle.distanceBetweenShapes(square), Math.sqrt(Math.pow((tX - sX),2) + Math.pow((tY - sY),2)));
        assertEquals(square.distanceBetweenShapes(triangle), Math.sqrt(Math.pow((sX - tX),2) + Math.pow((sY - tY),2)));
    }
}
