package Services;

import Model.Board;
import Model.CellStatus;

public class BoardService {

    public static void display(Board board){
        for(int i=0;i<board.getBoard().size();i++){
            System.out.print("|");
            for(int j=0;j<board.getBoard().size();j++){
                if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)){
                    System.out.print("| - |");
                }else {
                    System.out.printf("| %s |",
                            board.getBoard().get(i).get(j).getPlayer().getSymbol());
                }
            }
            System.out.println();
        }
    }
}
