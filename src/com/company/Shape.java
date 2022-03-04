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

    boolean shapesOverlap(Shape s) {                                    //Shape specific for circle
        /*
        Since the only shapes that are allowed are simple ones such as rectangles, isosceles triangles and circles, and
        the program would only be expanded with regular shapes such as regular pentagons, straight lines and so on. The
        easiest solution to dealing with overlap seems to be checking if one of the points (corners) of the shape are
        inside the other shape. There are 2 issue with this approach, but they are easily overcome.
        First the Shape s which we are checking for overlap with might not have any points inside 'this' shape but 'this'
        shape might have points inside s, thus all we have to do is check both ways. First does s have any points in 'this'
        if no, then does 'this' have any points in s. This is an OR question if one or both have points inside the other
        shape then they overlap.
        Second issue is circles only have a center point, meaning there wouldn't be checked for whether the circumference
        of the circle overlaps with another shape. First extra points are added to the circle: north, east, west & south,
        this solves all cases of overlap between circles and squares, since rectangles are never angled, and some cases
        with triangles. Second a line from the center of the circle to the center of the second shape
        center of the other shape
         */
        boolean overlap = this.checkAllPointsForOverlap(s.pointsList);  //Check if any of Shape s' points are inside this

        if (!overlap){
            overlap = s.checkAllPointsForOverlap(this.pointsList);      //Check if any of this' points are inside Shape s
        }

        return overlap;
    }

    public boolean checkAllPointsForOverlap(Point[] points){
        for (Point p : points){
            if (this.pointIsInsideArea(p)){
                return true;
            }
        }
        return false;
    }

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
