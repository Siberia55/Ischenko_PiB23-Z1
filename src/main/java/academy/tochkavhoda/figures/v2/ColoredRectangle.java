package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {

    private int color;

    public ColoredRectangle(Point topLeft, Point bottomRight, int color) {
        super(topLeft, bottomRight);
        this.color = color;
    }

    public ColoredRectangle(int x1, int y1, int x2, int y2, int color) {
        super(x1, y1, x2, y2);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, int color) {
        super(length, width);
        this.color = color;
    }

    public ColoredRectangle(int color) {
        super(1, 1);
        this.color = color;
    }

    public ColoredRectangle() {
        this(1);
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
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle)) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}