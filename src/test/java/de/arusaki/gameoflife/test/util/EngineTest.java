package de.arusaki.gameoflife.test.util;

import de.arusaki.gameoflife.model.LivingSpace;
import de.arusaki.gameoflife.util.Engine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Testclass for methods from {@link Engine}.
 *
 * @author Marvin Himmelmeier
 * @since 21.08.2016
 */
public class EngineTest {

    private static final int COUNT_ROWS = 3;
    private static final int COUNT_COLUMNS = 3;

    private LivingSpace livingSpace3x3;

    @Before
    public void setUp() {
        livingSpace3x3 = new LivingSpace(COUNT_ROWS, COUNT_COLUMNS);
        livingSpace3x3.reviveCellAt(0, 1);
        livingSpace3x3.reviveCellAt(1, 1);
        livingSpace3x3.reviveCellAt(2, 1);
    }

    @After
    public void tearDown() {
        livingSpace3x3 = null;
    }

    @Test
    public void testEvolveASimple3x3Blinker() {
        LivingSpace evolvedLivingSpace = Engine.evolve(livingSpace3x3);
        assertTrue("Cell at (1, 0) must be alive", evolvedLivingSpace.isAliveAt(1, 0));
        assertTrue("Cell at (1, 1) must be alive", evolvedLivingSpace.isAliveAt(1, 1));
        assertTrue("Cell at (1, 2) must be alive", evolvedLivingSpace.isAliveAt(1, 2));
    }
}
