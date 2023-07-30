package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public Board(int dimensions){
        this.board=new ArrayList<>();

        for(int i=0;i<dimensions;i++){
            this.board.add(new ArrayList<>());
            for(int j=0;j<dimensions;j++){
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }
    public void display(){
        for(int i=0;i<board.size();i++){
            System.out.print("|");
            for(int j=0;j<board.size();j++){
                if(board.get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)){
                    System.out.print("  |");
                }else {
                    System.out.printf(" %s |",
                            board.get(i).get(j).getPlayer().getSymbol());
                }
            }
            System.out.println();
        }
    }


    public List<List<Cell>> getBoard() {
        return board;
    }
}
