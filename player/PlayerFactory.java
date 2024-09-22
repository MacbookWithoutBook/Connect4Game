package player;

import model.BoardCell;

import java.util.Scanner;

/**
 * A factory class for creating Player instances based on user input.
 */
public class PlayerFactory {

    /**
     * Prompts the user to input a valid player name.
     *
     * @param scanner a {@link Scanner} instance for reading the user input.
     * @param playerNumber the player's number (e.g., 1 or 2).
     * @return the valid name entered by the user.
     */
    public String inputPlayerName(Scanner scanner, int playerNumber) {
        System.out.print("Please enter the name for Player " + playerNumber + ": ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Please enter the name for Player " + playerNumber + ": ");
            name = scanner.nextLine().trim();
        }
        return name;
    }

    /**
     * Creates a Player (Human or Computer) based on user input.
     *
     * @param scanner a {@link Scanner} instance for reading the user input.
     * @param name    the name of the player.
     * @param checker a {@link BoardCell} instance representing the player's checker.
     * @return an {@link Player} instance representing the player.
     */
    public Player choosePlayerType(Scanner scanner, String name, BoardCell checker) {
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
