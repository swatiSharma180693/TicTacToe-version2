package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.enums.GameStatus;
import models.enums.GridStatus;
import models.enums.SymbolType;

import java.sql.SQLOutput;

//@Builder
@Getter
@Setter
public class Board {

    int size;
    Cell[][] cells;

    public Board(int size){
        this.cells = new Cell[size][size];
        this.size = size;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Cell c = Cell.builder().
                        row(i).
                        column(j).
                        symbolType(SymbolType.B).
                        gridStatus(GridStatus.AVAILABLE).
                        build();
                this.cells[i][j] = (c);
            }
        }
    }

    public void displayBoard() {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(cells[i][j].symbolType+" ");
            }
            System.out.println();
        }
    }
}
