package player;

import model.Board;
import model.BoardCell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a computer player in the Connect 4 game.
 *
 * <p>It currently uses random selections to determine the move.</p>
 *
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 * @see Player
 */
public class ComputerPlayer extends Player {

    /**
     * A {@link Random} instance for randomly selecting the next column to drop the checker.
     */
    private final Random random;

    /**
     * Constructs a new {@link ComputerPlayer} instance with the specified name and checker type.
     *
     * @param name    the name of the computer player.
     * @param checker a {@link BoardCell} instance representing the player's checker.
     */
    public ComputerPlayer(String name, BoardCell checker) {
        super(name, checker);
        random = new Random();
    }

    /**
     * Generates a random valid column number for the computer player's current move.
     *
     * @param board a {@link Board} instance representing the current state of the game board.
     * @return the validated column index (0-based) where the player wants to drop the checker.
     * @throws IllegalStateException if there is no available column for the computer player to
     *                               drop the checker.
     */
    @Override
    public int getMove(Board board) {
        List<Integer> availableColumns = new ArrayList<>();
        for (int i = 0; i < Board.COLUMN_CNT; i++) {
            if (board.isValidDrop(i)) {
                availableColumns.add(i);
            }
        }
        if (availableColumns.isEmpty()) {
            throw new IllegalStateException("No columns available for the computer player to " +
                    "drop the checker.");
        }
        int columnId = availableColumns.get(random.nextInt(availableColumns.size()));
        System.out.print("[" + name + " (" + checker.getStatus() + ") Drop " + dropCount + "] ");
        System.out.println("Dropped a checker in column " + (columnId + 1) + ".");
        dropCount++;
        return columnId;
    }
}
