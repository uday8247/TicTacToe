package Model;

import java.util.Scanner;

public class Player {
    private String name;

    private char symbol;

    private int id;

    private PlayerType playertype;

    private Scanner scanner;

    private static boolean cellAvailable(Board board){
        for(int i=0;i<board.getBoard().size();i++) {
            for (int j = 0; i < board.getBoard().size(); j++) {
                if (board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)) {
                    return true;
                }
            }
        }
        return false;
    }

    //TODO:create playerservice and create makeMove()

    public Move makeMove(Board board){

        System.out.println("Enter the row and column where you want to play the move");
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        Cell cell=new Cell(row,col);

        System.out.printf("The Player %s is making a move at :- %d,%d\n",
                this.name,cell.getRow(),cell.getCol());

        if(cell.getCellStatus().equals(CellStatus.OCCUPIED)){
            throw new IllegalArgumentException("The cell is occupied");
        }
        cell.setPlayer(this);
        cell.setCellStatus(CellStatus.OCCUPIED);
        return new Move(cell);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayertype() {
        return playertype;
    }

    public void setPlayertype(PlayerType playertype) {
        this.playertype = playertype;
    }

    public Player(String name, char symbol, int id, PlayerType playertype,Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.id = id;
        this.playertype = playertype;
        this.scanner=scanner;
    }
}
