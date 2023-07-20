package strategies.win;

import models.Board;
import models.Cell;
import models.enums.SymbolType;
import strategies.win.CheckIfWon;

public class CheckByColumn implements CheckIfWon {
    public boolean check(Board board) {
        Cell[][] cells = board.getCells();
        int size = board.getSize();
        for(int j=0; j<size; j++) {
            SymbolType st = cells[0][j].getSymbolType();
            if (st != SymbolType.B) {
                int count = 1;
                for (int i = 1; i < size; i++) {
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
