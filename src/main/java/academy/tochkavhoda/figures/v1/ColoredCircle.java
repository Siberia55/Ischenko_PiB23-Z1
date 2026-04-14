package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredCircle extends Circle{
    private  int color;

    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }
    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }
    public ColoredCircle(int radius, int color) {
        super(radius);
        this.color = color;
    }
    public ColoredCircle(int color) {
        super(1);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public ColoredCircle() {
        super(1);
        this.color = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    public void setColor(int color) {
        this.color = color;
    }
}