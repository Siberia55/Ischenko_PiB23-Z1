package academy.tochkavhoda.misc;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.misc.v2.ColoredEllipse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColoredEllipseTest {

    @Test
    void testCreationAndColor() {
        ColoredEllipse e = new ColoredEllipse(new Point(10, 20), 8, 4, 5);

        assertEquals(10, e.getCenter().getX());
        assertEquals(20, e.getCenter().getY());
        assertEquals(8, e.getXAxis());
        assertEquals(4, e.getYAxis());
        assertEquals(5, e.getColor());
    }

    @Test
    void testDefaultColor() {
        ColoredEllipse e = new ColoredEllipse(10, 5);

        assertEquals(0, e.getColor());
    }

    @Test
    void testSetColor() {
        ColoredEllipse e = new ColoredEllipse(10, 5, 1);

        e.setColor(99);

        assertEquals(99, e.getColor());
    }

    @Test
    void testMoveTo() {
        ColoredEllipse e = new ColoredEllipse(new Point(0, 0), 10, 5, 1);

        e.moveTo(15, 25);

        assertEquals(15, e.getCenter().getX());
        assertEquals(25, e.getCenter().getY());
    }

    @Test
    void testMoveRel() {
        ColoredEllipse e = new ColoredEllipse(new Point(5, 5), 10, 5, 1);

        e.moveRel(5, -2);

        assertEquals(10, e.getCenter().getX());
        assertEquals(3, e.getCenter().getY());
    }

    @Test
    void testArea() {
        ColoredEllipse e = new ColoredEllipse(new Point(0, 0), 10, 6, 1);

        double expected = Math.PI * (10 / 2.0) * (6 / 2.0);

        assertEquals(expected, e.getArea(), 0.0001);
    }

    @Test
    void testIsInside() {
        ColoredEllipse e = new ColoredEllipse(new Point(0, 0), 10, 6, 1);

        assertTrue(e.isInside(0, 0));
        assertTrue(e.isInside(1, 1));
        assertFalse(e.isInside(100, 100));
    }

    @Test
    void testEqualsAndHashCode() {
        ColoredEllipse e1 = new ColoredEllipse(new Point(0, 0), 10, 6, 5);
        ColoredEllipse e2 = new ColoredEllipse(new Point(0, 0), 10, 6, 5);
        ColoredEllipse e3 = new ColoredEllipse(new Point(1, 0), 10, 6, 5);

        assertEquals(e1, e2);
        assertNotEquals(e1, e3);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void testDifferentColorsNotEqual() {
        ColoredEllipse e1 = new ColoredEllipse(new Point(0, 0), 10, 6, 1);
        ColoredEllipse e2 = new ColoredEllipse(new Point(0, 0), 10, 6, 2);

        assertNotEquals(e1, e2);
    }
}
