package com.company;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distanceBetweenPoints(Point p){
        return Math.sqrt(Math.pow((this.x - p.getX()),2) + Math.pow((this.y - p.getY()),2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
