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

    private static final int COUNT_ROWS = 3;
    private static final int COUNT_COLUMNS = 4;

    private LivingSpace livingSpace3x4;

    @Before
    public void setUp() {
        livingSpace3x4 = new LivingSpace(COUNT_ROWS, COUNT_COLUMNS);
    }

    @After
    public void tearDown() {
        livingSpace3x4 = null;
    }

    @Test
    public void testLivingSpaceInitialization() {
        assertNotNull("LivingSpace must not be null", livingSpace3x4);
    }

    @Test
    public void testSizeOfColumnsIsCorrect() {
        assertEquals("getColumns() must have " + COUNT_COLUMNS + " columns", COUNT_COLUMNS, livingSpace3x4.getColumns());
    }

    @Test
    public void testSizeOfRowsIsCorrect() {
        assertEquals("getRows() must have " + COUNT_ROWS + " rows", COUNT_ROWS, livingSpace3x4.getRows());
    }

    @Test
    public void testReviveAtFirstCellPosition() {
        assertTrue("revive at (0, 0) must return true", livingSpace3x4.reviveCellAt(0, 0));
    }

    @Test
    public void testReviveAtLastCellPosition() {
        assertTrue("revive at (" + (COUNT_ROWS - 1) + ", " + (COUNT_COLUMNS - 1) + ") must return true", livingSpace3x4.reviveCellAt(COUNT_ROWS - 1, COUNT_COLUMNS - 1));
    }

    @Test
    public void testReviveAtOutOfBounds() {
        assertFalse("revive at (-1, -1) must return false", livingSpace3x4.reviveCellAt(-1, -1));
    }

    @Test
    public void testKillAtFirstCellPosition() {
        livingSpace3x4.reviveCellAt(0, 0);
        assertTrue("kill at (0, 0) must return true", livingSpace3x4.killCellAt(0, 0));
    }

    @Test
    public void testKillAtLastCellPosition() {
        livingSpace3x4.reviveCellAt(COUNT_ROWS - 1, COUNT_COLUMNS - 1);
        assertTrue("kill at (" + (COUNT_ROWS - 1) + ", " + (COUNT_COLUMNS - 1) + ") must return true", livingSpace3x4.killCellAt(COUNT_ROWS - 1, COUNT_COLUMNS - 1));
    }

    @Test
    public void testKillAtOutOfBounds() {
        assertFalse("kill at (-1, -1) must return false", livingSpace3x4.killCellAt(-1, -1));
    }

    @Test
    public void testIsCellAtPositionAliveFalse() {
        assertFalse("isAlive() at (0, 0) must be false", livingSpace3x4.isAliveAt(0, 0));
    }

    @Test
    public void testIsCellAtPositionAliveTrue() {
        livingSpace3x4.reviveCellAt(0, 0);
        assertTrue("isAlive() at (0, 0) must be true", livingSpace3x4.isAliveAt(0, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsAliveAtOutOfBounds() {
        livingSpace3x4.isAliveAt(-1, -1);
    }

    @Test
    public void testCountLivingNeighborsAtTopLeftCorner() {
        livingSpace3x4.reviveCellAt(0, 0);
        livingSpace3x4.reviveCellAt(1, 1);
        assertEquals("living neighbors count must be 1", 1, livingSpace3x4.countLivingNeighborsAt(0, 0));
    }

    @Test
    public void testCountLivingNeighborsAtBottomRightCorner() {
        livingSpace3x4.reviveCellAt(COUNT_ROWS - 1, COUNT_COLUMNS - 1);
        livingSpace3x4.reviveCellAt(COUNT_ROWS - 2, COUNT_COLUMNS - 2);
        assertEquals("living neighbors count must be 1", 1, livingSpace3x4.countLivingNeighborsAt(COUNT_ROWS - 1, COUNT_COLUMNS - 1));
    }

    @Test
    public void testCountLivingNeighborsAtTopLeftCornerWithEveryCellAroundAlive() {
        livingSpace3x4.reviveCellAt(0, 0);
        livingSpace3x4.reviveCellAt(0, 1);
        livingSpace3x4.reviveCellAt(1, 0);
        livingSpace3x4.reviveCellAt(1, 1);
        assertEquals("living neighbors count must be 3", 3, livingSpace3x4.countLivingNeighborsAt(0, 0));
    }

    @Test
    public void testCountLivingNeighborsAtBottomRightCornerWithEveryCellAroundAlive() {
        livingSpace3x4.reviveCellAt(COUNT_ROWS - 1, COUNT_COLUMNS - 1);
        livingSpace3x4.reviveCellAt(COUNT_ROWS - 1, COUNT_COLUMNS - 2);
        livingSpace3x4.reviveCellAt(COUNT_ROWS - 2, COUNT_COLUMNS - 1);
        livingSpace3x4.reviveCellAt(COUNT_ROWS - 2, COUNT_COLUMNS - 2);
        assertEquals("living neighbors count must be 3", 3, livingSpace3x4.countLivingNeighborsAt(COUNT_ROWS - 1, COUNT_COLUMNS - 1));
    }

    @Test
    public void testCountLivingNeighborsInMiddle() {
        livingSpace3x4.reviveCellAt(0, 0);
        livingSpace3x4.reviveCellAt(1, 1);
        assertEquals("living neighbors count must be 1", 1, livingSpace3x4.countLivingNeighborsAt(1, 1));
    }

    @Test
    public void testCountLivingNeighborsInMiddleWithEveryCellAroundAlive() {
        livingSpace3x4.reviveCellAt(0, 0);
        livingSpace3x4.reviveCellAt(0, 1);
        livingSpace3x4.reviveCellAt(0, 2);
        livingSpace3x4.reviveCellAt(1, 0);
        livingSpace3x4.reviveCellAt(1, 1);
        livingSpace3x4.reviveCellAt(1, 2);
        livingSpace3x4.reviveCellAt(2, 0);
        livingSpace3x4.reviveCellAt(2, 1);
        livingSpace3x4.reviveCellAt(2, 2);
        assertEquals("living neighbors count must be 8", 8, livingSpace3x4.countLivingNeighborsAt(1, 1));
    }

    @Test
    public void testPrintLivingSpaceAsString() {
        String livingSpaceStrBuilder = "O---" + '\n' +
                "O---" + '\n' +
                "O---" + '\n';
        if (livingSpace3x4.getLivingCharacter() != 'O') {
            livingSpace3x4.setLivingCharacter('O');
        }
        if (livingSpace3x4.getDeadCharacter() != '-') {
            livingSpace3x4.setDeadCharacter('-');
        }
        livingSpace3x4.reviveCellAt(0, 0);
        livingSpace3x4.reviveCellAt(1, 0);
        livingSpace3x4.reviveCellAt(2, 0);
        assertEquals(livingSpaceStrBuilder, livingSpace3x4.printLivingSpaceAsString());
    }

    @Test
    public void testLivingSpaceCloning() {
        int posX = 0;
        int posY = 0;
        char livingChar = 'L';
        char deadChar = 'D';
        livingSpace3x4.reviveCellAt(posX, posY);
        livingSpace3x4.setLivingCharacter(livingChar);
        livingSpace3x4.setDeadCharacter(deadChar);

        LivingSpace clonedLivingSpace = null;
        try {
            clonedLivingSpace = livingSpace3x4.clone();
        } catch (CloneNotSupportedException e) {
            assertTrue("cloning Living Space failed with Exception", false);
        }

        assertTrue("Cell must be alive at (" + posX + ", " + posY + ")", clonedLivingSpace.isAliveAt(posX, posY));
        assertEquals("Living character must be " + livingChar, livingSpace3x4.getLivingCharacter(), clonedLivingSpace.getLivingCharacter());
        assertEquals("Living character must be " + deadChar, livingSpace3x4.getDeadCharacter(), clonedLivingSpace.getDeadCharacter());
        assertEquals("row count must be " + livingSpace3x4.getRows(), livingSpace3x4.getRows(), clonedLivingSpace.getRows());
        assertEquals("column count must be " + livingSpace3x4.getColumns(), livingSpace3x4.getColumns(), clonedLivingSpace.getColumns());
    }

}
