package academy.tochkavhoda.misc;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.misc.v2.Ship;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {

    @Test
    void testCreationAndGetters() {
        Ship ship = new Ship(new Point(10, 20), 5, 10, 3);

        assertEquals(10, ship.getPosition().getX());
        assertEquals(20, ship.getPosition().getY());
        assertEquals(5, ship.getWidth());
        assertEquals(10, ship.getHeight());
        assertEquals(3, ship.getColor());
    }

    @Test
    void testArea() {
        Ship ship = new Ship(0, 0, 4, 6, 0);

        assertEquals(24.0, ship.getArea());
    }

    @Test
    void testMoveTo() {
        Ship ship = new Ship(0, 0, 5, 5, 0);

        ship.moveTo(15, 25);

        assertEquals(15, ship.getPosition().getX());
        assertEquals(25, ship.getPosition().getY());
    }

    @Test
    void testMoveRel() {
        Ship ship = new Ship(10, 10, 5, 5, 0);

        ship.moveRel(5, -3);

        assertEquals(15, ship.getPosition().getX());
        assertEquals(7, ship.getPosition().getY());
    }

    @Test
    void testResize() {
        Ship ship = new Ship(0, 0, 10, 20, 0);

        ship.resize(2);

        assertEquals(20, ship.getWidth());
        assertEquals(40, ship.getHeight());
    }

    @Test
    void testIsInside() {
        Ship ship = new Ship(0, 0, 10, 10, 0);

        assertTrue(ship.isInside(5, 5));
        assertTrue(ship.isInside(new Point(1, 1)));
        assertFalse(ship.isInside(15, 15));
    }

    @Test
    void testColor() {
        Ship ship = new Ship(0, 0, 5, 5, 0);

        ship.setColor(7);

        assertEquals(7, ship.getColor());
    }

    @Test
    void testEquals() {
        Ship s1 = new Ship(new Point(0, 0), 5, 5, 1);
        Ship s2 = new Ship(new Point(0, 0), 5, 5, 1);
        Ship s3 = new Ship(new Point(1, 0), 5, 5, 1);

        assertEquals(s1, s2);
        assertNotEquals(s1, s3);
    }

    @Test
    void testInvalidResize() {
        Ship ship = new Ship(0, 0, 5, 5, 0);

        assertThrows(IllegalArgumentException.class, () -> ship.resize(0));
        assertThrows(IllegalArgumentException.class, () -> ship.resize(-2));
    }
}
