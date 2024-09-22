package client;

import game.Connect4Game;
import model.BoardCell;
import player.Player;
import player.PlayerFactory;

import java.util.Scanner;

/**
 * A Client application for playing a two-player text-based Connect 4 Game.
 *
 * @version 1.0
 */
public class sampleClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Connect 4 Game!");

        // Get player names using PlayerFactory
        PlayerFactory factory = new PlayerFactory();
        String name1 = factory.inputPlayerName(scanner, 1);
        String name2 = factory.inputPlayerName(scanner, 2);

        // Choose player types (Human or Computer) using PlayerFactory
        Player player1 = factory.choosePlayerType(scanner, name1, BoardCell.PLAYER_A);
        Player player2 = factory.choosePlayerType(scanner, name2, BoardCell.PLAYER_B);

        // Initialize and start the game
        Connect4Game game = new Connect4Game(player1, player2);
        game.play();

        scanner.close();
    }
}
