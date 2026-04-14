package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {

    private Point topLeft;
    private int length;

    public Square(Point topLeft, int length) {
        this.topLeft = topLeft;
        this.length = length;
    }

    public Square(int x, int y, int length) {
        this(new Point(x, y), length);
    }

    public Square(int length) {
        this(new Point(0, -length), length);
    }

    public Square() {
        this(new Point(0, -1), 1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Point getBottomRight() {
        return new Point(topLeft.getX() + length, topLeft.getY() + length);
    }

    public void moveTo(int x, int y) {
        topLeft.moveTo(x, y);
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
    }

    public void resize(double factor) {
        length = (int) Math.round(length * factor);
    }

    public double getArea() {
        return length * length;
    }

    public double getPerimeter() {
        return 4 * length;
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= topLeft.getX() + length &&
                y >= topLeft.getY() && y <= topLeft.getY() + length;
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public boolean isInside(Square other) {
        Point br = other.getBottomRight();
        return isInside(other.getTopLeft()) && isInside(br);
    }

    public boolean isIntersects(Square other) {
        Point tl1 = topLeft;
        Point br1 = getBottomRight();
        Point tl2 = other.getTopLeft();
        Point br2 = other.getBottomRight();

        return !(tl2.getX() > br1.getX() || br2.getX() < tl1.getX() ||
                tl2.getY() > br1.getY() || br2.getY() < tl1.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return length == square.length && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, length);
    }
}
