package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {

    private int color;

    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }

    public ColoredCircle(int x, int y, int radius, int color) {
        super(x, y, radius);
        this.color = color;
    }

    public ColoredCircle(int radius, int color) {
        super(0, 0, radius);
        this.color = color;
    }

    public ColoredCircle(int color) {
        this(1, color); // radius=1, center=(0,0)
    }

    public ColoredCircle() {
        this(1); // color=1
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
        if (!(o instanceof ColoredCircle)) return false;
        ColoredCircle c = (ColoredCircle) o;

        return super.equals(o) && color == c.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}