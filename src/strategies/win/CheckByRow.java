package strategies.win;

import models.Board;
import models.Cell;
import models.enums.SymbolType;
import strategies.win.CheckIfWon;

public class CheckByRow implements CheckIfWon {

    @Override
    public boolean check(Board board) {
        Cell[][] cells = board.getCells();
        int size = board.getSize();
        for(int i=0; i<size; i++) {
            SymbolType st = cells[i][0].getSymbolType();
            if (st != SymbolType.B){
                int count = 1;
                for (int j = 1; j < size; j++) {
                    if (cells[i][j].getSymbolType() == st) {
                        count++;
                    }
                }
                if (count == size) {
                    return true;
                }
            }
        }
        return false;
    }
}
