package com.company;

public class Circle extends Shape{
    protected final int radius;

    public Circle(double x, double y, int radius){
        super(x, y);
        this.radius = radius;
        computeArea();
        computeCircomference();
    }

    @Override
    public boolean pointIsInsideArea(Point p) {
        return center.distanceBetweenPoints(p) <= radius;               //If the distance to the point is shorter than
    }                                                                   // the radius then the point is inside the circle.

    @Override
    public void computeArea(){
        area = Math.pow(radius,2) *  Math.PI;
    }

    @Override
    public void computeCircomference(){
        circumference = 2 * radius * Math.PI;
    }
}
