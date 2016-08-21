package de.arusaki.gameoflife.util;

import de.arusaki.gameoflife.model.LivingSpace;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Util-class with static methods for simulating Conway's Game of Life, it manages the rules etc.
 *
 * @author Marvin Himmelmeier
 * @since 21.08.2016
 */
public class Engine {

    private static final Logger LOGGER = LogManager.getLogger(Engine.class);

    public static LivingSpace evolve(LivingSpace currentLivingSpace) {
        LivingSpace evolvedLivingSpace = null;
        try {
            evolvedLivingSpace = currentLivingSpace.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        if (evolvedLivingSpace != null) {
            for (int i = 0; i < currentLivingSpace.getRows(); i++) {
                for (int j = 0; j < currentLivingSpace.getColumns(); j++) {
                    int countLivingNeighbors = currentLivingSpace.countLivingNeighborsAt(i, j);
                    boolean isAliveAt = currentLivingSpace.isAliveAt(i, j);
                    // checking underpopulation
                    if (isAliveAt && countLivingNeighbors < 2) {
                        evolvedLivingSpace.killCellAt(i, j);
                    } else if (isAliveAt && countLivingNeighbors > 3) { // checking overpopulation
                        evolvedLivingSpace.killCellAt(i, j);
                    } else if (!isAliveAt && countLivingNeighbors == 3) { // checking reproduction
                        evolvedLivingSpace.reviveCellAt(i, j);
                    }
                }
            }
        } else {
            LOGGER.error("Cloned living space is null! Will return given living space without evolving");
            evolvedLivingSpace = currentLivingSpace;
        }

        return evolvedLivingSpace;
    }
}
