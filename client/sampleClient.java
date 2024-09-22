package client;

import game.Connect4Game;
import model.BoardCell;
import player.Player;
import player.PlayerFactory;

import java.util.Scanner;

/**
 * A Client application for playing a two-player text-based Connect 4 Game.
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 */
public class sampleClient {

    /**
     * The main entry point for the text-based Connect 4 game.
     * <p>
     * This method interacts with users to get their names and determine the type of player
     * (Human or Computer) using {@link PlayerFactory}. It then initializes a {@link Connect4Game}
     * with the specified players and starts the game.
     * </p>
     *
     * <p>
     * The game continues until a player wins or the board is full. Players take turns dropping
     * checkers into a 6x7 grid, and the first player to connect four checkers in a row (vertically,
     * horizontally, or diagonally) wins.
     * </p>
     *
     * @param args command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Connect 4 Game!");

        // Get player names using PlayerFactory
        String name1 = PlayerFactory.inputPlayerName(scanner, 1);
        String name2 = PlayerFactory.inputPlayerName(scanner, 2);

        // Choose player types (Human or Computer) using PlayerFactory
        Player player1 = PlayerFactory.choosePlayerType(scanner, name1, BoardCell.PLAYER_A);
        Player player2 = PlayerFactory.choosePlayerType(scanner, name2, BoardCell.PLAYER_B);

        // Initialize and start the game
        Connect4Game game = new Connect4Game(player1, player2);
        game.play();

        scanner.close();
    }
}
