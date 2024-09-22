package player;

import model.Board;
import model.BoardCell;

import java.util.Scanner;

/**
 * Represents a human player in the Connect 4 Game.
 *
 * <p>It provides operations for reading and parsing the user input to determine the player's
 * move.</p>
 *
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 * @see Player
 */
public class HumanPlayer extends Player {

    /**
     * A {@link Scanner} instance for reading the user input.
     */
    private final Scanner scanner;

    /**
     * Constructs a new {@link HumanPlayer} instance with the specified name and checker type.
     *
     * @param name    the name of the human player.
     * @param checker a {@link BoardCell} instance representing the player's checker.
     */
    public HumanPlayer(String name, BoardCell checker) {
        super(name, checker);
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts the human player to enter a column number for the current move.
     *
     * @param board a {@link Board} instance representing the current state of the game board.
     * @return the validated column index (0-based) where the player wants to drop the checker.
     * @throws NumberFormatException if the user input is not a valid integer.
     */
    @Override
    public int getMove(Board board) {
        int columnId;
        while (true) {
            try {
                System.out.print("[" + name + " (" + checker.getStatus() + ") Drop " + dropCount + "] ");
                System.out.print("Please choose a column (1~" + Board.COLUMN_CNT + ") to drop " +
                        "your checker: ");
                String input = scanner.nextLine();
                columnId = Integer.parseInt(input) - 1;
                if (columnId < 0 || columnId >= Board.COLUMN_CNT) {
                    System.out.println("Invalid column number. Please choose a number between 1 " +
                            "and " + Board.COLUMN_CNT + ".");
                } else if (!board.isValidDrop(columnId)) {
                    System.out.println("Column " + (columnId + 1) + " is already full. Please " +
                            "choose another column to drop your checker.");
                } else {
                    System.out.print("[" + name + " (" + checker.getStatus() + ") Drop " + dropCount + "] ");
                    System.out.println("Dropped a checker in column " + (columnId + 1) + ".");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        dropCount++;
        return columnId;
    }
}
