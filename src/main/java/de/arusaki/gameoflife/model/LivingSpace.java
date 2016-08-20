package de.arusaki.gameoflife.model;

/**
 * LivingSpace-class, which holds the fields of the LivingSpace where its size cannot be changed after initialization.
 *
 * @author Marvin Himmelmeier
 * @since 20.08.2016
 */
public class LivingSpace {

    private final int columns;
    private final int rows;
    private final boolean[][] livingSpace;

    public LivingSpace(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.livingSpace = new boolean[columns][rows];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean[][] getLivingSpace() {
        return livingSpace;
    }
}
