package com.company;

public class Square extends Shape{
    /*
    Rectangle is the only allowed shape for the square.
    Because a rectangle is a much simpler shape to work with than rhombuses or other squares.
    */
    protected final Point topLeft;
    protected final Point topRight;
    protected final Point bottomLeft;
    protected final Point bottomRight;
    protected final double length;
    protected final double height;

    public Square(double x, double y, double l, double h){
        super(x, y);
        length = l;
        height = h;
        topLeft = new Point(x - length/2, y + height/2);
        topRight = new Point(x + length/2, y + height/2);
        bottomLeft = new Point(x - length/2, y - height/2);
        bottomRight = new Point(x + length/2, y - height/2);
        computeArea();
        computeCircomference();
    }
    @Override
    boolean pointIsInsideArea(Point p) {
        return p.getX() >= topLeft.getX() && p.getX() <= topRight.getX() && p.getY() <= topLeft.getY() && p.getY() >= bottomLeft.getY();
    }

    @Override
    void computeArea() {
        area = height * length;
    }

    @Override
    void computeCircomference() {
        circumference = 2 * length + 2 * height;

    }
}
