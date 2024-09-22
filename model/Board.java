package model;

/**
 * Represents the game board in the Connect 4 game.
 *
 * <p>It provides operations for managing and updating the game board, validating player drops, and
 * checking for a game win/draw.</p>
 *
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 * @see BoardCell
 */
public class Board {

    /**
     * The number of rows in the board. (Default: {@value})
     */
    public static final int ROW_CNT = 6;

    /**
     * The number of columns in the board. (Default: {@value})
     */
    public static final int COLUMN_CNT = 7;

    /**
     * A two-dimension {@link BoardCell} array representing the game board.
     */
    private final BoardCell[][] grid;

    /**
     * Initializes an empty {@value ROW_CNT}x{@value COLUMN_CNT} game board.
     */
    public Board() {
        grid = new BoardCell[ROW_CNT][COLUMN_CNT];
        for (int i = 0; i < ROW_CNT; i++) {
            for (int j = 0; j < COLUMN_CNT; j++) {
                grid[i][j] = BoardCell.EMPTY;
            }
        }
    }

    /**
     * Validates if the specified column ID is within the bounds of the board.
     *
     * @param columnId The column index (0-indexed) to be validated.
     * @throws IllegalArgumentException if the specified column ID is out of bounds.
     */
    private void validateColumnId(int columnId) {
        if (columnId < 0 || columnId >= COLUMN_CNT) {
            throw new IllegalArgumentException("Invalid column ID: " + columnId +
                    ". Must be between 0 and " + (COLUMN_CNT - 1) + ".");
        }
    }

    /**
     * Returns whether all the cells in the specified column have already been used.
     *
     * @return {@code true} if all the cells in the specified column have already been used;
     *         Otherwise, {@code false}.
     */
    private boolean isColumnFull(int columnId) {
        validateColumnId(columnId);
        return grid[0][columnId] != BoardCell.EMPTY;
    }

    /**
     * Returns whether all the cells in the game board have already been used.
     *
     * @return {@code true} if all the cells in the game board have already been used;
     *         Otherwise, {@code false}.
     */
    public boolean isFull() {
        for (int i = 0; i < COLUMN_CNT; i++) {
            if (!isColumnFull(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns whether dropping a checker in the specified column is a valid move.
     *
     * @param columnId the index (0-indexed) of the column where the checker is to be dropped.
     * @return {@code true} if it's a valid move to drop a checker in the specified column;
     *         Otherwise, {@code false}.
     */
    public boolean isValidDrop(int columnId) {
        validateColumnId(columnId);
        return !isColumnFull(columnId);
    }

    /**
     * Returns whether the specified checker is a valid checker type.
     *
     * @param checker a {@link BoardCell} instance representing a checker (Must be either 'X' or 'O').
     * @return {@code true} if the specified checker is valid; Otherwise, {@code false}.
     */
    public boolean isValidChecker(BoardCell checker) {
        return checker == BoardCell.PLAYER_A || checker == BoardCell.PLAYER_B;
    }

    /**
     * Drops a checker in the specified column. If the column is already full, the drop operation
     * fails and this method would return {@code false}.
     *
     * @param columnId the index (0-indexed) of the column where the checker is to be dropped.
     * @param checker  a {@link BoardCell} instance representing a checker (Must be either 'X' or 'O').
     * @return {@code true} if the drop operation is successful; Otherwise, {@code false}.
     */
    public boolean dropChecker(int columnId, BoardCell checker) {
        if (!isValidDrop(columnId) || !isValidChecker(checker)) {
            return false;
        }

        for (int i = ROW_CNT - 1; i >= 0; i--) {
            if (grid[i][columnId] == BoardCell.EMPTY) {
                grid[i][columnId] = checker;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether the player with the specified checker has reached a winning condition.
     *
     * <p>It will check if any of the following winning conditions has been reached:</p>
     * <ol>
     * <li>Four consecutive same-type checkers in horizontal.</li>
     * <li>Four consecutive same-type checkers in vertical.</li>
     * <li>Four consecutive same-type checkers in a positively sloped diagonal.</li>
     * <li>Four consecutive same-type checkers in a negatively sloped diagonal.</li>
     * </ol>
     *
     * @param checker a {@link BoardCell} instance representing a checker (Must be either 'X' or 'O').
     * @return {@code true} if the player has reached a winning condition; Otherwise, {@code false}.
     */
    public boolean checkIfWinning(BoardCell checker) {
        if (!isValidChecker(checker)) {
            return false;
        }

        // Check horizontal locations
        for (int i = 0; i < ROW_CNT; i++) {
            for (int j = 0; j < COLUMN_CNT - 3; j++) {
                if (grid[i][j] == checker && grid[i][j + 1] == checker
                        && grid[i][j + 2] == checker && grid[i][j + 3] == checker) {
                    return true;
                }
            }
        }
        // Check vertical locations
        for (int i = 0; i < COLUMN_CNT; i++) {
            for (int j = 0; j < ROW_CNT - 3; j++) {
                if (grid[j][i] == checker && grid[j + 1][i] == checker
                        && grid[j + 2][i] == checker && grid[j + 3][i] == checker) {
                    return true;
                }
            }
        }
        // Check positively sloped diagonals
        for (int i = 0; i < ROW_CNT - 3; i++) {
            for (int j = 0; j < COLUMN_CNT - 3; j++) {
                if (grid[i][j] == checker && grid[i + 1][j + 1] == checker &&
                        grid[i + 2][j + 2] == checker && grid[i + 3][j + 3] == checker) {
                    return true;
                }
            }
        }
        // Check negatively sloped diagonals
        for (int i = 3; i < ROW_CNT; i++) {
            for (int j = 0; j < COLUMN_CNT - 3; j++) {
                if (grid[i][j] == checker && grid[i - 1][j + 1] == checker &&
                        grid[i - 2][j + 2] == checker && grid[i - 3][j + 3] == checker) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Displays the current state of the game board to the console through a text-based user
     * interface.
     */
    public void display() {
        System.out.println("\n          [Current Game Board]");
        for (int i = 0; i < ROW_CNT; i++) {
            System.out.print("    " + (ROW_CNT - i) + " |");
            for (int j = 0; j < COLUMN_CNT; j++) {
                BoardCell cell = grid[i][j];
                System.out.print(" " + cell.getStatus() + " |");
            }
            System.out.println();
        }
        System.out.print("       ");
        for (int i = 1; i <= COLUMN_CNT; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
    }
}
