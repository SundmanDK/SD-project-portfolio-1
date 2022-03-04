package com.company;

public class Triangle extends Shape{
    /*
    Isosceles triangle (ligebenet trekant) is the only allowed shape for the triangle.
     */
    protected final Point top;
    protected final Point bottomLeft;
    protected final Point bottomRight;
    private final double height;
    private final double length;

    public Triangle(double x, double y, double height, double length){
        super(x, y);
        this.height = height;
        this.length = length;

        top = new Point(x, y + (2 * height / 3));                                  //Point B
        double bottomPointsHeightOffset = (height / 3);
        bottomLeft = new Point(x - length/2, y - bottomPointsHeightOffset);     //Point A
        bottomRight = new Point(x + length/2, y - bottomPointsHeightOffset);    //Point C
        computeArea();
        computeCircomference();
    }

    @Override
    boolean pointIsInsideArea(Point p) {
        //3 new triangles are described PAB, PAC & PBC.
        //Calculating area of triangle from 3 points:
        double area1 = Math.abs(p.getX() * (bottomLeft.getY() - top.getY())
                + bottomLeft.getX() * (top.getY() - p.getY())
                + top.getX() * (p.getY() - bottomLeft.getY())) / 2;

        double area2 = Math.abs(p.getX() * (top.getY() - bottomRight.getY())
                + top.getX() * (bottomRight.getY() - p.getY())
                + bottomRight.getX() * (p.getY() - top.getY())) / 2;

        double area3 = Math.abs(p.getX() * (bottomLeft.getY() - bottomRight.getY())
                + bottomLeft.getX() * (bottomRight.getY() - p.getY())
                + bottomRight.getX() * (p.getY() - bottomLeft.getY())) / 2;

        //If the area of the 3 new triangle equals the area of the original triangle then the point is inside.
        return (area1 + area2 + area3) == area;
    }

    @Override
    void computeArea() {
        area = (height * length) / 2;
    }

    @Override
    void computeCircomference() {
        circumference = length + 2 * (Math.sqrt(Math.pow(length /2, 2) + Math.pow(height,2)));
    }

    Point getTop(){
        return top;
    }
    Point getBottomLeft(){
        return bottomLeft;
    }
    Point getBottomRight(){
        return bottomRight;
    }
}
