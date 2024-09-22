package player;

import model.BoardCell;

import java.util.Scanner;

/**
 * A factory class for creating players in the Connect 4 game.
 * <p>
 * This class provides static methods to interact with the user to obtain player details,
 * such as player names and types (Human or Computer), and return a {@link Player} instance
 * for each player.
 * </p>
 *
 * <p>
 * The methods in this class do not depend on any instance of the class, so they are declared
 * as static.
 * </p>
 * 
 * <p><b>Example usage:</b></p>
 * <pre>
 * {@code
 *     Scanner scanner = new Scanner(System.in);
 *     
 *     // Input names for Player 1 and Player 2
 *     String name1 = PlayerFactory.inputPlayerName(scanner, 1);
 *     String name2 = PlayerFactory.inputPlayerName(scanner, 2);
 *     
 *     // Determine the type of player (Human or Computer) and create player instances
 *     Player player1 = PlayerFactory.choosePlayerType(scanner, name1, BoardCell.PLAYER_A);
 *     Player player2 = PlayerFactory.choosePlayerType(scanner, name2, BoardCell.PLAYER_B);
 * }
 * </pre>
 */
public class PlayerFactory {
    
    /**
     * Prompts the user to input a valid player name.
     * <p>
     * This method reads the player name from the user and validates that the input is not empty.
     * If the input is empty, the user is asked to provide the name again until a valid name is entered.
     * </p>
     *
     * @param scanner a {@link Scanner} instance to read user input.
     * @param playerNumber the number of the player (e.g., 1 for Player 1, 2 for Player 2).
     * @return the valid name entered by the user.
     */
    public static String inputPlayerName(Scanner scanner, int playerNumber) {
        System.out.print("Please enter the name for Player " + playerNumber + ": ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Please enter the name for Player " + playerNumber + ": ");
            name = scanner.nextLine().trim();
        }
        return name;
    }

    /**
     * Determines the type of player (Human or Computer) based on user input.
     * <p>
     * This method prompts the user to specify if the player is a human or computer. It loops until a valid
     * input is received ('H' or 'C'). Depending on the input, it creates and returns either a {@link HumanPlayer}
     * or a {@link ComputerPlayer} instance.
     * </p>
     *
     * @param scanner a {@link Scanner} instance to read user input.
     * @param name the name of the player to be created.
     * @param checker the {@link BoardCell} instance representing the player's checker (either 'X' or 'O').
     * @return a {@link Player} instance representing either a human or computer player.
     */
    public static Player choosePlayerType(Scanner scanner, String name, BoardCell checker) {
        while (true) {
            System.out.print("Is " + name + " a Human or Computer? Please enter 'H'/'h' if " +
                    name + " is a human player, or 'C'/'c' if " + name + " is a computer player: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("H")) {
                return new HumanPlayer(name, checker);
            } else if (input.equals("C")) {
                return new ComputerPlayer(name, checker);
            } else {
                System.out.println("Invalid input. Please enter 'H'/'h' for Human player or " +
                        "'C'/'c' for Computer player.");
            }
        }
    }
}
