package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.HasArea;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.Resizable;

public abstract class Figure implements Movable, Resizable, HasArea {

    protected int x;
    protected int y;

    protected Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public abstract boolean isInside(int x, int y);


}