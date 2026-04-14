package academy.tochkavhoda.misc;


import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.misc.v2.ColoredSquare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColoredSquareTest {

    @Test
    void testCreationAndColor() {
        ColoredSquare s = new ColoredSquare(new Point(0, 0), 10, 5);

        assertEquals(0, s.getTopLeft().getX());
        assertEquals(0, s.getTopLeft().getY());
        assertEquals(10, s.getLength());
        assertEquals(5, s.getColor());
    }

    @Test
    void testDefaultColor() {
        ColoredSquare s = new ColoredSquare(new Point(0, 0), 10);

        assertEquals(0, s.getColor());
    }

    @Test
    void testSetColor() {
        ColoredSquare s = new ColoredSquare(10, 5);

        s.setColor(99);

        assertEquals(99, s.getColor());
    }

    @Test
    void testMoveTo() {
        ColoredSquare s = new ColoredSquare(new Point(0, 0), 10, 1);

        s.moveTo(15, 25);

        assertEquals(15, s.getTopLeft().getX());
        assertEquals(25, s.getTopLeft().getY());
    }

    @Test
    void testMoveRel() {
        ColoredSquare s = new ColoredSquare(new Point(5, 5), 10, 1);

        s.moveRel(3, -2);

        assertEquals(8, s.getTopLeft().getX());
        assertEquals(3, s.getTopLeft().getY());
    }

    @Test
    void testAreaAndPerimeter() {
        ColoredSquare s = new ColoredSquare(new Point(0, 0), 4, 1);

        assertEquals(16, s.getArea());
        assertEquals(16, s.getPerimeter());
    }

    @Test
    void testIsInside() {
        ColoredSquare s = new ColoredSquare(new Point(0, 0), 10, 1);

        assertTrue(s.isInside(5, 5));
        assertTrue(s.isInside(new Point(1, 1)));
        assertFalse(s.isInside(20, 20));
    }

    @Test
    void testEqualsAndHashCode() {
        ColoredSquare s1 = new ColoredSquare(new Point(0, 0), 10, 5);
        ColoredSquare s2 = new ColoredSquare(new Point(0, 0), 10, 5);
        ColoredSquare s3 = new ColoredSquare(new Point(1, 0), 10, 5);

        assertEquals(s1, s2);
        assertNotEquals(s1, s3);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    void testDifferentColorsNotEqual() {
        ColoredSquare s1 = new ColoredSquare(new Point(0, 0), 10, 1);
        ColoredSquare s2 = new ColoredSquare(new Point(0, 0), 10, 2);

        assertNotEquals(s1, s2);
    }
}