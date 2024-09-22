package game;

import model.Board;
import player.Player;

/**
 * Represents the game flow of the Connect 4 Game.
 *
 * <p>It handles player turns, checks for win/draw conditions, and provides interfaces with players
 * to receive moves.</p>
 * 
 * <p><b>Example usage:</b></p>
 * <pre>
 * {@code
 *     // See PlayerFactory to create players, then:
 *     
 *     // Start a Connect 4 game with players created:
 *     Connect4Game game = new Connect4Game(player1, player2);
 *     game.play();
 * }
 * </pre>
 *
 * @author Dongzhi Zhang (dongzhiz), Peitong Zhu (peitongz)
 * @version 1.0
 * @see Board
 * @see Player
 */
public class Connect4Game {

    /**
     * A {@link Board} instance representing the game board.
     */
    private Board board;

    /**
     * A {@link Player} array representing the players playing the game.
     */
    private Player[] players;

    /**
     * An integer index representing the player who should move in the current round.
     */
    private int currentPlayerId;

    /**
     * Constructs a new {@link Connect4Game} instance with two specified players, and initializes
     * the game board.
     *
     * @param playerA the first player.
     * @param playerB the second player.
     */
    public Connect4Game(Player playerA, Player playerB) {
        board = new Board();
        players = new Player[]{playerA, playerB};
        currentPlayerId = 0;
    }

    /**
     * Starts and manages the game flow until a player wins or a draw occurs.
     */
    public void play() {
        while (true) {
            Player currentPlayer = players[currentPlayerId];
            System.out.print("\n============ " + currentPlayer.getName() + "'s Turn (" +
                    currentPlayer.getChecker().getStatus() + ") ============");
            board.display();
            int columnToDrop = currentPlayer.getMove(board);
            boolean success = board.dropChecker(columnToDrop, currentPlayer.getChecker());
            if (success) {
                if (board.checkIfWinning(currentPlayer.getChecker())) {
                    board.display();
                    System.out.println("Congratulations " + currentPlayer.getName() +
                            "! You have won the game!");
                    break;
                } else if (board.isFull()) {
                    board.display();
                    System.out.println("The game is a draw.");
                    break;
                }
                currentPlayerId = 1 - currentPlayerId;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }
}
