package player;

import model.Board;
import model.BoardCell;

/**
 * An abstract class representing a player in the Connect 4 game.
 *
 * <p>It defines the structure for different types of players, including human players and computer
 * players.</p>
 *
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 * @see HumanPlayer
 * @see ComputerPlayer
 */
public abstract class Player {

    /**
     * The name of the player.
     */
    protected String name;

    /**
     * A {@link BoardCell} instance representing the player's checker type (Must be either 'X' or 'O').
     */
    protected BoardCell checker;

    /**
     * The number of drop operations the player has been conducted.
     */
    protected int dropCount;

    /**
     * Constructs a new {@link Player} instance with the specified name and checker type.
     *
     * @param name    the name of the player.
     * @param checker the {@link BoardCell} instance representing the player's checker.
     */
    public Player(String name, BoardCell checker) {
        this.name = name;
        this.checker = checker;
        dropCount = 1;
    }

    /**
     * An abstract method to get the player's move.
     *
     * @param board a {@link Board} instance representing the current state of the game board.
     * @return the index (0-based) of the column where the player wants to drop the checker.
     */
    public abstract int getMove(Board board);

    /**
     * Returns the name of the player.
     *
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a {@link BoardCell} instance representing the player's checker.
     *
     * @return a {@link BoardCell} instance representing the player's checker.
     */
    public BoardCell getChecker() {
        return checker;
    }

    /**
     * Sets the name of the player.
     *
     * @param name the name to be set for the player.
     */
    public void setName(String name) {
        this.name = name;
    }
}
