package client;

import game.Connect4Game;
import model.BoardCell;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

import java.util.Scanner;

/**
 * A Client application for playing a two-player text-based Connect 4 Game.
 *
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 * @see Connect4Game
 */
public class Connect4GameClient {

    /**
     * Helper method to choose the type of player (Human or Computer).
     *
     * @param scanner a {@link Scanner} instance for reading the user input.
     * @param name    the name of the player.
     * @param checker a {@link BoardCell} instance representing the player's checker.
     * @return an {@link Player} instance representing the player.
     */
    private static Player choosePlayerType(Scanner scanner, String name, BoardCell checker) {
        while (true) {
            System.out.print("Is " + name + " a Human or Computer? Please enter 'H'/'h' if " +
                    name + " is a human player, or 'C'/'c' if " + name + " is a computer player.");
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Connect 4 Game!");

        // Get player names
        System.out.print("Please enter the name for player.Player 1: ");
        String name1 = scanner.nextLine().trim();
        while (name1.isEmpty()) {
            System.out.print("Name cannot be empty. Please enter the name for player.Player 1: ");
            name1 = scanner.nextLine().trim();
        }
        System.out.print("Please enter the for player.Player 2: ");
        String name2 = scanner.nextLine().trim();
        while (name2.isEmpty()) {
            System.out.print("Name cannot be empty. Please enter the name for player.Player 2: ");
            name2 = scanner.nextLine().trim();
        }

        // Choose player types (Human or Computer)
        Player player1 = choosePlayerType(scanner, name1, BoardCell.PLAYER_A);
        Player player2 = choosePlayerType(scanner, name2, BoardCell.PLAYER_B);

        // Initialize and start the game
        Connect4Game game = new Connect4Game(player1, player2);
        game.play();

        scanner.close();
    }

}
