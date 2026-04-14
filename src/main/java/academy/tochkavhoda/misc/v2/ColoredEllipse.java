package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.figures.v2.Ellipse;
import academy.tochkavhoda.figures.v2.Point;

import java.util.Objects;

public class ColoredEllipse extends Ellipse implements Colored {

    private int color;

    public ColoredEllipse(Point center, int xAxis, int yAxis, int color) {
        super(center, xAxis, yAxis);
        this.color = color;
    }

    public ColoredEllipse(int xCenter, int yCenter, int xAxis, int yAxis, int color) {
        this(new Point(xCenter, yCenter), xAxis, yAxis, color);
    }

    public ColoredEllipse(int xAxis, int yAxis, int color) {
        this(new Point(0, 0), xAxis, yAxis, color);
    }

    public ColoredEllipse(Point center, int xAxis, int yAxis) {
        this(center, xAxis, yAxis, 0);
    }

    public ColoredEllipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis, 0);
    }

    public ColoredEllipse() {
        this(new Point(0, 0), 1, 1, 0);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredEllipse that = (ColoredEllipse) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}