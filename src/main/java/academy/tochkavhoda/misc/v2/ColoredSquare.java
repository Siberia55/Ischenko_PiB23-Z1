package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.figures.v2.Square;

import java.util.Objects;

public class ColoredSquare extends Square implements Colored {

    private int color;

    public ColoredSquare(Point leftTop, int size, int color) {
        super(leftTop, size);
        this.color = color;
    }

    public ColoredSquare(int xLeft, int yTop, int size, int color){
        this(new Point(xLeft, yTop), size, color);
    }

    public ColoredSquare(Point leftTop, int size) {
        this(leftTop, size, 0);
    }

    public ColoredSquare(int size, int color) {
        this(new Point(0, -size), size, color);
    }

    public ColoredSquare() {
        this(new Point(0, -1), 1, 0);
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredSquare that = (ColoredSquare) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}