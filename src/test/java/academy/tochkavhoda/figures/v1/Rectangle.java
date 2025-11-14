package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Rectangle(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Rectangle(int length, int width) {
        this(new Point(0, -width), new Point(length, 0));
    }

    public Rectangle() {
        this(new Point(0, -1), new Point(1, 0));
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    public void moveTo(int x, int y) {
        int dx = x - topLeft.getX();
        int dy = y - topLeft.getY();
        moveRel(dx, dy);
    }

    public void moveTo(Point p) {
        moveTo(p.getX(), p.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void resize(double factor) {
        int newLength = (int) Math.round(getLength() * factor);
        int newWidth = (int) Math.round(getWidth() * factor);
        bottomRight = new Point(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    public void stretch(double factorLength, double factorWidth) {
        int newLength = (int) Math.round(getLength() * factorLength);
        int newWidth = (int) Math.round(getWidth() * factorWidth);
        bottomRight = new Point(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX() &&
                y >= topLeft.getY() && y <= bottomRight.getY();
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public boolean isInside(Rectangle other) {
        return isInside(other.topLeft) && isInside(other.bottomRight);
    }

    public boolean isIntersects(Rectangle other) {
        return !(other.topLeft.getX() > bottomRight.getX() ||
                other.bottomRight.getX() < topLeft.getX() ||
                other.topLeft.getY() > bottomRight.getY() ||
                other.bottomRight.getY() < topLeft.getY());
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rect = (Rectangle) o;
        return Objects.equals(topLeft, rect.topLeft) &&
                Objects.equals(bottomRight, rect.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
