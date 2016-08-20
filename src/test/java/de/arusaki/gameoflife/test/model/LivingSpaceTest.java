package de.arusaki.gameoflife.test.model;

import de.arusaki.gameoflife.model.LivingSpace;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testclass for methods from {@link LivingSpace}.
 *
 * @author Marvin Himmelmeier
 * @since 20.08.2016
 */
public class LivingSpaceTest {

    private static final int COUNT_COLUMNS = 4;
    private static final int COUNT_ROWS = 3;

    private LivingSpace livingSpace3x2;

    @Before
    public void setUp() {
        livingSpace3x2 = new LivingSpace(COUNT_COLUMNS, COUNT_ROWS);
    }

    @After
    public void tearDown() {
        livingSpace3x2 = null;
    }

    @Test
    public void testLivingSpaceInitialization() {
        assertNotNull("LivingSpace must not be null", livingSpace3x2);
    }

    @Test
    public void testSizeOfColumnsIsCorrect() {
        assertEquals("getColumns() must have " + COUNT_COLUMNS + " columns", COUNT_COLUMNS, livingSpace3x2.getColumns());
    }

    @Test
    public void testSizeOfRowsIsCorrect() {
        assertEquals("getRows() must have " + COUNT_ROWS + " rows", COUNT_ROWS, livingSpace3x2.getRows());
    }

    @Test
    public void testReviveAtSuccessful() {
        assertTrue("revive at (0, 0) must return true", livingSpace3x2.reviveCellAt(0, 0));
    }

    @Test
    public void testReviveAtFailure() {
        assertFalse("revive at (-1, -1) must return false", livingSpace3x2.reviveCellAt(-1, -1));
    }

    @Test
    public void testIsCellAtPositionAliveFalse() {
        assertFalse("isAlive() at (0, 0) must be false", livingSpace3x2.isAliveAt(0, 0));
    }

    @Test
    public void testIsCellAtPositionAliveTrue() {
        livingSpace3x2.reviveCellAt(0, 0);
        assertTrue("isAlive() at (0, 0) must be true", livingSpace3x2.isAliveAt(0, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsAliveAtOutOfBounds() {
        livingSpace3x2.isAliveAt(-1, -1);
    }

    @Test
    public void testCountLivingNeighborsAtTopLeftCorner() {
        livingSpace3x2.reviveCellAt(0, 0);
        livingSpace3x2.reviveCellAt(1, 1);
        assertEquals("living neighbors count must be 1", 1, livingSpace3x2.countLivingNeighborsAt(0, 0));
    }

    @Test
    public void testCountLivingNeighborsAtTopLeftCornerWithEveryCellAroundAlive() {
        livingSpace3x2.reviveCellAt(0, 0);
        livingSpace3x2.reviveCellAt(0, 1);
        livingSpace3x2.reviveCellAt(1, 0);
        livingSpace3x2.reviveCellAt(1, 1);
        assertEquals("living neighbors count must be 3", 3, livingSpace3x2.countLivingNeighborsAt(0, 0));
    }

    @Test
    public void testCountLivingNeighborsInMiddle() {
        livingSpace3x2.reviveCellAt(0, 0);
        livingSpace3x2.reviveCellAt(1, 1);
        assertEquals("living neighbors count must be 1", 1, livingSpace3x2.countLivingNeighborsAt(1, 1));
    }

    @Test
    public void testCountLivingNeighborsInMiddleWithEveryCellAroundAlive() {
        livingSpace3x2.reviveCellAt(0, 0);
        livingSpace3x2.reviveCellAt(0, 1);
        livingSpace3x2.reviveCellAt(0, 2);
        livingSpace3x2.reviveCellAt(1, 0);
        livingSpace3x2.reviveCellAt(1, 1);
        livingSpace3x2.reviveCellAt(1, 2);
        livingSpace3x2.reviveCellAt(2, 0);
        livingSpace3x2.reviveCellAt(2, 1);
        livingSpace3x2.reviveCellAt(2, 2);
        assertEquals("living neighbors count must be 8", 8, livingSpace3x2.countLivingNeighborsAt(1, 1));
    }

}
