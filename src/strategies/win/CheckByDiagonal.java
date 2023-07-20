package strategies.win;

import models.Board;
import models.Cell;
import models.enums.SymbolType;
import strategies.win.CheckIfWon;

public class CheckByDiagonal implements CheckIfWon {

    @Override
    public boolean check(Board board) {
        Cell[][] cells = board.getCells();
        int size = board.getSize();
        for(int i=0; i<size; i++){
            SymbolType st = cells[i][0].getSymbolType();
            int count = 1;
            for(int j=i; j<size; j++){
                if(j==i){
                    if(cells[i][j].getSymbolType() == st){
                        count++;
                    }
                }
            }
            if(count==size){
                return true;
            }
        }

        for(int i=size-1; i>=0; i--) {
            SymbolType st = cells[i][0].getSymbolType();
            int count = 1;
            if (st != SymbolType.B){
                for (int j = i; j < size; j++) {
                    if (j == i) {
                        if (cells[i][j].getSymbolType() == st) {
                            count++;
                        }
                    }
                }
            }
            if(count==size){
                return true;
            }
        }
        return false;
    }
}
