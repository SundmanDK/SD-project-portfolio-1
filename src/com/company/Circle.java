package com.company;

public class Circle extends Shape{
    protected final int radius;
    protected final Point north;
    protected final Point east;
    protected final Point west;
    protected final Point south;

    public Circle(double x, double y, int radius){
        super(x, y);
        this.radius = radius;
        north = new Point(x,y + radius);
        east = new Point(x - radius,y);
        west = new Point(x + radius, y);
        south = new Point(x, y - radius);
        pointsList = new Point[]{center, north, east, west, south};
        computeArea();
        computeCircomference();
    }

    @Override
    public boolean pointIsInsideArea(Point p) {
        return center.distanceBetweenPoints(p) <= radius;               //If the distance to the point is shorter than
    }                                                                   // the radius then the point is inside the circle.

    @Override
    boolean shapesOverlap(Shape s) {
        addPointOnCircumferenceTowardCenterOfShape(s);
        boolean overlap = this.checkAllPointsForOverlap(s.pointsList);  //Check if any of Shape s' points are inside this
        if (!overlap) {
            overlap = s.checkAllPointsForOverlap(this.pointsList);      //Check if any of this' points are inside Shape s
        }
        return overlap;
    }

    public void addPointOnCircumferenceTowardCenterOfShape(Shape s){

        double distanceBetweenCenters = distanceBetweenShapes(s);
        //Vector between centers:
        double x = this.center.getX() - s.getCenter().getX();
        double y = this.center.getY() - s.getCenter().getY();
        //Unit vector:
        x /= distanceBetweenCenters;
        y /= distanceBetweenCenters;
        //Vector from circle center to the intersection between circle circumference and vector between centers:
        x *= radius;
        y *= radius;
        //Point at intersection:
        Point intersect = new Point(x, y);
        pointsList = new Point[]{center, intersect};
    }

    @Override
    public void computeArea(){
        area = Math.pow(radius,2) *  Math.PI;
    }

    @Override
    public void computeCircomference(){
        circumference = 2 * radius * Math.PI;
    }
}
