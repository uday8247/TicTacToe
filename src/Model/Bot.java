package Model;

import Strategies.Bot.BotPlayingStrategy;
import Strategies.Bot.BotPlayingStrategyFactory;

import java.util.Scanner;

public class Bot extends Player{

    public Bot(String name, char symbol, int id, PlayerType playertype, BotDifficultyLevel botDifficultyLevel,
                Scanner scanner) {
        super(name, symbol, id, playertype,scanner);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    @Override
    public Move makeMove(Board board){


        Move move= botPlayingStrategy.suggestMove(board);
        System.out.printf("The bot is making a move %d,%d\n",move.getCell().getRow(),move.getCell().getCol());

        move.getCell().setPlayer(this);
        move.getCell().setCellStatus(CellStatus.OCCUPIED);

        return move;
    }
}
