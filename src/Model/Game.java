package Model;

import Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player>players;
    List<Move>moves;
    Player nextPlayerTurn;
    GameState gameState;
    Player winner;
    List<WinningStrategy>winningStrategies;
    int currentPlayerIndex=0;

    private Game(int dimension,List<Player>players,List<WinningStrategy>winningStrategies){
        this.players=players;
        this.winningStrategies=winningStrategies;
        this.board=new Board(dimension);
        this.moves=new ArrayList<>();
        this.currentPlayerIndex=0;
        this.gameState=GameState.INPROGRESS;

    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        //1.players
        //2.dimension
        //3.winning strategies

        List<Player>players;
        List<WinningStrategy>winningStrategies;
        int dimension;

        private Builder(){
            this.players=new ArrayList<>();
            this.winningStrategies=new ArrayList<>();
            this.dimension=0;
        }
        public Builder setPlayers(List<Player>players){
            this.players=players;
            return this;
        }
        public Builder setWinningStrategies(List<WinningStrategy>winningStrategies){
            this.winningStrategies=winningStrategies;
            return this;
        }
        public Builder setDimension(int dimension){
            this.dimension=dimension;
            return this;
        }
        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }
        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }
        public Game build(){

            return new Game(dimension,players,winningStrategies);
        }
    }
    public void makeMove(){
        Player currentPlayer=players.get(currentPlayerIndex);
        System.out.printf("Player turn: %s ",currentPlayer.getName());

        Move move=currentPlayer.makeMove(board);
        moves.add(move);

        //update the board with the rol and col
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        this.board.getBoard().get(row).set(col,move.getCell());
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(board,move)){
                System.out.printf("The player %s has won\n",currentPlayer.getName());
                gameState=GameState.WIN;
                break;
            }
        }

        currentPlayerIndex= (currentPlayerIndex+1)%players.size();
        this.board.display();
    }

}
