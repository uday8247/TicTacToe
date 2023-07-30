import Model.Board;
import Model.*;
import Strategies.WinningStrategies.ColWinningStrategy;
import Strategies.WinningStrategies.RowWinningStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Player bot = new Bot("BOT", 'O', 1, PlayerType.BOT, BotDifficultyLevel.EASY, sc);
        Player myself = new Player("Uday", 'X', 2, PlayerType.HUMAN, sc);

        Game game = Game.getBuilder()
                .addPlayer(bot)
                .addPlayer(myself)
                .addWinningStrategy(new ColWinningStrategy())
                .addWinningStrategy(new RowWinningStrategy())
                .setDimension(3)
                .build();

        // TODO: Make the game running automatically
        game.makeMove();
        game.makeMove();
        game.makeMove();
        game.makeMove();
    }
}
