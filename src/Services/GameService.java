package Services;

import Model.Game;
import Model.GameState;
import Model.Move;
import Model.Player;
import Strategies.WinningStrategies.WinningStrategy;

public class GameService {

    Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void executeNextMove() {

        Player currentPlayer = game.getCurrentPlayer();
        System.out.printf("Player turn: %s\n", currentPlayer.getName());

        Move move = currentPlayer.makeMove(game.getBoard());

        if (move == null) {
            game.setGameState(GameState.DRAW);
            return;
        }

        game.addMove(move);

        game.updateBoard(move);

        for (WinningStrategy winningStrategy: game.getWinningStrategies()) {
            if (winningStrategy.checkWinner(game.getBoard(), move)) {
                System.out.printf("The player %s has won.\n", currentPlayer.getName());
                game.setGameState(GameState.WIN);
                game.setWinner(currentPlayer);
                break;
            }
        }
        game.nextPlayerTurn();
    }
}