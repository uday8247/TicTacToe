import Controllers.GameController;
import Model.Board;
import Model.*;
import Strategies.WinningStrategies.ColWinningStrategy;
import Strategies.WinningStrategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameController gameController = new GameController();

        System.out.println("Let's begin TicTacToe:)");

        System.out.println("Enter the dimension of the board :- ");
        int dimension = sc.nextInt();

        System.out.println("How many Total Players :- ");
        int numberOfPlayers = sc.nextInt();

        System.out.println("Is there a bot? y/n");
        String isBot = sc.next();
        int nonBotPlayers = numberOfPlayers;
        if (isBot.equals("y")) {
            nonBotPlayers = nonBotPlayers - 1;
        }

        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < nonBotPlayers; i++) {
            System.out.println("Enter the name of the player :- ");
            String playerName = sc.next();
            System.out.println("Enter the symbol :- ");
            String symbol = sc.next();

            playerList.add(new Player(playerName, symbol.charAt(0), i, PlayerType.HUMAN, sc));
        }

        if (isBot.equals("y")) {
            System.out.println("Enter the name of the bot :- ");
            String botName = sc.next();
            System.out.println("Enter the symbol :- ");
            String symbol = sc.next();

            playerList.add(new Bot(botName, symbol.charAt(0), nonBotPlayers, BotDifficultyLevel.EASY, sc));
        }

        Game game = gameController.createGame(dimension,playerList);

        while(gameController.getGameStatus(game).equals(GameState.INPROGRESS)){
            System.out.println("This is the current board :-");

            gameController.displayBoard(game);

            //TODO:add undo check here

            gameController.executeNextMove(game);

        }

        System.out.println("Result of the game :-");
        if(gameController.getGameStatus(game).equals(GameState.DRAW)){
            System.out.println("DRAW");
        }else{
            System.out.println("The winner is :- "+gameController.getWinner(game));
        }
    }
}
//
//        Player bot = new Bot("BOT", 'O', 1, PlayerType.BOT, BotDifficultyLevel.EASY, sc);
//        Player myself = new Player("Uday", 'X', 2, PlayerType.HUMAN, sc);
//
//        Game game = Game.getBuilder()
//                .addPlayer(bot)
//                .addPlayer(myself)
//                .addWinningStrategy(new ColWinningStrategy())
//                .addWinningStrategy(new RowWinningStrategy())
//                .setDimension(3)
//                .build();
//
//
//        game.makeMove();
//        game.makeMove();
//        game.makeMove();
//        game.makeMove();
//    }
//}
