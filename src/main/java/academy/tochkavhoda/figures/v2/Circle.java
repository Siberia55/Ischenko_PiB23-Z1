package academy.tochkavhoda.figures.v2;

import java.util.Objects;

public class Circle extends Figure {

    private int radius;

    public Circle(Point center, int radius) {
        super(center.getX(), center.getY());
        this.radius = radius;
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public Circle(int radius) {
        this(0, 0, radius);
    }

    public Circle() {
        this(1);
    }

    // Получить центр круга
    public Point getCenter() {
        return new Point(x, y);
    }

    // Установить центр круга
    public void setCenter(Point center) {
        moveTo(center.getX(), center.getY());
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void resize(double ratio) {
        radius = (int) (radius * ratio);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isInside(int px, int py) {
        int dx = px - x;
        int dy = py - y;
        return dx * dx + dy * dy <= radius * radius;
    }

    // Перегруженный метод для Point
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
    @Override
    public void moveTo(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    @Override
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return x == circle.x &&
                y == circle.y &&
                radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius);
    }
}