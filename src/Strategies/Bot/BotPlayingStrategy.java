package Strategies.Bot;

import Model.Board;
import Model.Move;

public interface BotPlayingStrategy {

    Move suggestMove(Board board);


}
