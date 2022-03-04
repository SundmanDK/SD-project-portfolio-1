package com.company;

abstract class Shape {
    protected Point center;
    protected Point[] pointsList;
    protected double area;
    protected double circumference;

    public Shape(double x, double y){
        center = new Point(x, y);
    }

    abstract boolean pointIsInsideArea(Point p);                        //Shape specific

    public Point getCenter(){
        return center;
    }

    public double distanceBetweenShapes(Shape s){
        return this.center.distanceBetweenPoints(s.getCenter());
    }

    abstract void computeArea();                                        //Shape specific

    abstract void computeCircomference();                               //Shape specific

    public double getArea(){ return area; }

    public double getCircumference(){ return circumference; }
}
