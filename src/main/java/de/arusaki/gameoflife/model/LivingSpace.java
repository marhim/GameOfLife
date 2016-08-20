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

    /**
     * Initializes the living space fields with given number of columns and rows.
     *
     * @param columns number of columns the living space should have
     * @param rows    number of rows the living space should have
     */
    public LivingSpace(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.livingSpace = new boolean[columns][rows];
    }

    /**
     * Set the Cell at given position alive.
     *
     * @param posX x-position
     * @param posY y-position
     * @return true, if setting cell alive at given position, false if not
     */
    public boolean reviveCellAt(int posX, int posY) {
        try {
            livingSpace[posX][posY] = true;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            return false;
        }
        return true;
    }

    /**
     * Checks status of the cell at given position. {@link IndexOutOfBoundsException} will be thrown, if position is out of bounds.
     *
     * @param posX x-position
     * @param posY y-position
     * @return true, if Cell is alive, false if not
     */
    public boolean isAliveAt(int posX, int posY) {
        return livingSpace[posX][posY];
    }

    /**
     * Counts living neighbors of given position except itself. {@link IndexOutOfBoundsException} will be thrown, if position is out of bounds.
     *
     * @param posX x-position
     * @param posY y-position
     * @return count of living neighbors
     */
    public int countLivingNeighborsAt(int posX, int posY) {
        int livingNeighborsCount = 0;
        for (int i = posX - 1; i < posX + 2; i++) {
            for (int j = posY - 1; j < posY + 2; j++) {
                // ignore given position and check out of bounds, if so continue with next iteration
                if (!((i == posX && j == posY) || i < 0 || j < 0 || i >= columns || j >= rows)) {
                    if (livingSpace[i][j]) {
                        livingNeighborsCount++;
                    }
                }
            }
        }
        return livingNeighborsCount;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
