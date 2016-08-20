package de.arusaki.gameoflife;

import de.arusaki.gameoflife.model.LivingSpace;

/**
 * Mainclass for Conway's Game of Life simulation.
 *
 * @author Marvin Himmelmeier
 * @since 20.08.2016
 */
public class Main {

    public static void main(String[] args) {
        LivingSpace livingSpace = new LivingSpace(4, 5);
        livingSpace.reviveCellAt(1, 1);
        livingSpace.reviveCellAt(1, 2);
        livingSpace.reviveCellAt(1, 3);
        System.out.println(livingSpace.printLivingSpaceAsString());
    }
}
