package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.HasArea;
import academy.tochkavhoda.figures.v2.Point;

public class Ship implements Colored, Movable, HasArea {

    private Point position;
    private int width;
    private int height;
    private int color;

    public Ship(Point position, int width, int height, int color) {
        checkSize(width, height);
        this.position = new Point(position.getX(), position.getY());
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Ship(int x, int y, int width, int height, int color) {
        this(new Point(x, y), width, height, color);
    }

    public Ship(int width, int height, int color) {
        this(new Point(0, 0), width, height, color);
    }

    public Ship() {
        this(new Point(0, 0), 1, 1, 0);
    }

    public Point getPosition() {
        return new Point(position.getX(), position.getY());
    }

    public void setPosition(Point position) {
        this.position = new Point(position.getX(), position.getY());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void moveTo(int x, int y) {
        position = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        position = new Point(
                position.getX() + dx,
                position.getY() + dy
        );
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2.0 * (width + height);
    }

    public boolean isInside(int x, int y) {
        return x >= position.getX() &&
                x < position.getX() + width &&
                y >= position.getY() &&
                y < position.getY() + height;
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public void resize(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Factor must be positive");
        }

        width = Math.max(1, (int) (width * factor));
        height = Math.max(1, (int) (height * factor));
    }

    private void checkSize(int w, int h) {
        if (w <= 0 || h <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ship)) return false;

        Ship other = (Ship) obj;

        return width == other.width &&
                height == other.height &&
                color == other.color &&
                position.equals(other.position);
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + color;
        return result;
    }
}