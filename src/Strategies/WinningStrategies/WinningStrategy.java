package Strategies.WinningStrategies;

import Model.Board;
import Model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
