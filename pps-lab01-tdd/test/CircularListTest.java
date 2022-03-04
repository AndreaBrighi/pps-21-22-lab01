import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach() {
        list = new CircularListImpl();
    }

    void initListWith(int... elements) {
        for (var elem : elements) {
            list.add(elem);
        }
    }

    @Test
    public void testCreatedEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testNextEmpty() {
        assertEquals(Optional.empty(), list.next());
    }

    @Test
    public void testPreviousEmpty() {
        assertEquals(Optional.empty(), list.previous());
    }


    @Test
    public void testResetEmpty() {
        list.reset();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        initListWith(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void testNextWithOneElement() {
        initListWith(1);
        assertEquals(Optional.of(1), list.next());
    }

    @Test
    public void testNextLinkedWithOneElement() {
        initListWith(1);
        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(1), list.next());
    }

    @Test
    public void testNextWithTwoElements() {
        initListWith(1, 2);
        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(2), list.next());
    }

    @Test
    public void testNextLinkedWithTwoElements() {
        initListWith(1, 2);
        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(2), list.next());
        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(2), list.next());
    }

    @Test
    public void testPreviousWithOneElement() {
        initListWith(1);
        assertEquals(Optional.of(1), list.previous());
    }

    @Test
    public void testPreviousLinkedWithOneElement() {
        initListWith(1);
        assertEquals(Optional.of(1), list.previous());
        assertEquals(Optional.of(1), list.previous());
    }

    @Test
    public void testPreviousWithTwoElements() {
        initListWith(1, 2);
        assertEquals(Optional.of(2), list.previous());
        assertEquals(Optional.of(1), list.previous());
    }

    @Test
    public void testPreviousLinkedWithTwoElements() {
        initListWith(1, 2);
        assertEquals(Optional.of(2), list.previous());
        assertEquals(Optional.of(1), list.previous());
        assertEquals(Optional.of(2), list.previous());
        assertEquals(Optional.of(1), list.previous());
    }

    @Test
    public void testPreviousNext() {
        initListWith(1, 2, 3);
        assertEquals(Optional.of(3), list.previous());
        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(2), list.next());
    }

    @Test
    public void testNextPrevious() {
        initListWith(1, 2, 3);
        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(3), list.previous());
        assertEquals(Optional.of(1), list.next());
    }

    @Test
    public void testReset() {
        initListWith(1, 2, 3);
        assertEquals(Optional.of(3), list.previous());
        assertEquals(Optional.of(2), list.previous());
        list.reset();
        assertEquals(Optional.of(2), list.next());
        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(3), list.next());
    }
}
