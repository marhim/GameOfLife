package de.arusaki.gameoflife.test.model;

import de.arusaki.gameoflife.model.LivingSpace;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testclass for methods from {@link LivingSpace}.
 *
 * @author Marvin Himmelmeier
 * @since 20.08.2016
 */
public class LivingSpaceTest {

    private LivingSpace livingSpace3x2;

    @Before
    public void setUp() {
        livingSpace3x2 = new LivingSpace(3, 2);
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
    public void testSizeOfColumnsInInitialization() {
        assertEquals("LivingSpace-Array must have 3 columns", 3, livingSpace3x2.getLivingSpace().length);
        assertEquals("getColumns() must have 3 columns", 3, livingSpace3x2.getColumns());
    }

    @Test
    public void testSizeOfRowsInInitialization() {
        assertEquals("LivingSpace-Array must have 2 rows", 2, livingSpace3x2.getLivingSpace()[0].length);
        assertEquals("getRows() must have 2 rows", 2, livingSpace3x2.getRows());
    }
}
