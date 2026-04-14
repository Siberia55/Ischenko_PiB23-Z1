package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Stretchable;

import java.util.Objects;

public class Rectangle extends Figure implements Stretchable {

    private int width;
    private int height;

    // Конструктор по двум точкам
    public Rectangle(Point topLeft, Point bottomRight) {
        this(topLeft.getX(), topLeft.getY(),
                bottomRight.getX(), bottomRight.getY());
    }

    // Конструктор по координатам
    public Rectangle(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.width = x2 - x1;
        this.height = y2 - y1;
    }

    // Конструктор по длине и ширине
    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    // Конструктор по умолчанию
    public Rectangle() {
        this(0, -1, 1, 0);
    }


    public Point getTopLeft() {
        return new Point(x, y);
    }

    public Point getBottomRight() {
        return new Point(x + width, y + height);
    }

    public int getLength() {
        return Math.abs(width);
    }

    public int getWidth() {
        return Math.abs(height);
    }


    public void setTopLeft(Point point) {
        int bottomRightX = getBottomRight().getX();
        int bottomRightY = getBottomRight().getY();
        this.x = point.getX();
        this.y = point.getY();
        this.width = bottomRightX - x;
        this.height = bottomRightY - y;
    }

    public void setBottomRight(Point point) {
        this.width = point.getX() - x;
        this.height = point.getY() - y;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }


    // Увеличение/уменьшение от верхнего левого угла
    public void resize(double factor) {
        width = (int) (width * factor);
        height = (int) (height * factor);
    }

    // Растяжение по осям
    public void stretch(double factorLength, double factorWidth) {
        width = (int) (width * factorLength);
        height = (int) (height * factorWidth);
    }

    @Override
    public boolean isInside(int px, int py) {
        int left = Math.min(x, x + width);
        int right = Math.max(x, x + width);
        int top = Math.min(y, y + height);
        int bottom = Math.max(y, y + height);

        return px >= left && px <= right &&
                py >= top && py <= bottom;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isInside(Rectangle other) {
        return isInside(other.getTopLeft()) &&
                isInside(other.getBottomRight());
    }

    public boolean isIntersects(Rectangle other) {
        int left1 = Math.min(x, x + width);
        int right1 = Math.max(x, x + width);
        int top1 = Math.min(y, y + height);
        int bottom1 = Math.max(y, y + height);

        int left2 = Math.min(other.x, other.x + other.width);
        int right2 = Math.max(other.x, other.x + other.width);
        int top2 = Math.min(other.y, other.y + other.height);
        int bottom2 = Math.max(other.y, other.y + other.height);

        return !(right1 < left2 ||
                right2 < left1 ||
                bottom1 < top2 ||
                bottom2 < top1);
    }


    @Override
    public double getArea() {
        return Math.abs(width * height);
    }

    @Override
    public double getPerimeter() {
        return 2 * (Math.abs(width) + Math.abs(height));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return x == rectangle.x &&
                y == rectangle.y &&
                width == rectangle.width &&
                height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }
}