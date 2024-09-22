package model;

/**
 * An enum class representing the status of a cell in the game.Connect4Game board.
 *
 * <p>The status of a cell can be divided into three types:</p>
 * <ol>
 * <li>EMPTY (' '), representing the cell has not been checked by any player yet.</li>
 * <li>PlAYER_A ('X'), representing the cell has been checked with checker 'X' by player A.</li>
 * <li>PlAYER_B ('O'), representing the cell has been checked with checker 'O' by player B.</li>
 * </ol>
 *
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 * @see Board
 */
public enum BoardCell {

    /**
     * Represents the cell is not checked yet.
     */
    EMPTY(' '),

    /**
     * Represents the cell is checked with checker 'X' by player A.
     */
    PLAYER_A('X'),

    /**
     * Represents the cell is checked with checker 'O' by player B.
     */
    PLAYER_B('O');

    /**
     * A character representing the cell's current status (Empty / Checked by player A /
     * Checked by player B).
     */
    private final char status;

    /**
     * Constructor for the {@link BoardCell} enum.
     *
     * @param status a character representing the cell's current status.
     */
    BoardCell(char status) {
        this.status = status;
    }

    /**
     * Returns the character representing the cell's current status.
     *
     * @return a character representing the cell's current status.
     */
    public char getStatus() {
        return status;
    }
}
