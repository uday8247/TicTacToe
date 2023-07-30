package Controllers;

import Model.*;
import Services.BoardService;
import Services.GameService;
import Strategies.WinningStrategies.ColWinningStrategy;
import Strategies.WinningStrategies.RowWinningStrategy;

import java.util.List;

//simple interface to interact with the game
public class GameController {

    public static Game createGame(int dimension, List<Player> playerList){
        return Game.getBuilder().setPlayers(playerList)
                .addWinningStrategy(new ColWinningStrategy())
                .addWinningStrategy(new RowWinningStrategy())
                .setDimension(dimension)
                .build();
    }

    public void undo(){

    }

    public void displayBoard(Game game){
        BoardService.display(game.getBoard());
    }

    public GameState getGameStatus(Game game){
        return game.getGameState();
    }

    public void executeNextMove(Game game){
        GameService gameService=new GameService(game);
        gameService.executeNextMove();
    }

    public String getWinner(Game game){
        return game.getWinner().getName();
    }
}
