package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import models.enums.GridStatus;
import models.enums.SymbolType;

import javax.management.RuntimeMBeanException;

@Getter
@Setter
@SuperBuilder(toBuilder = true)

public class HumanPlayer extends Players{
    String name;
    String email;
    byte[] image;

    @Override
    public void makeMove(Board board, int i, int j) {

        Cell[][] cells = board.getCells();
        System.out.println(cells[i][j].getGridStatus());

        if(cells[i][j].getGridStatus().equals(GridStatus.AVAILABLE) ){

            Cell c = Cell.builder()
                    .gridStatus(GridStatus.OCCUPIED)
                    .symbolType(this.symbolType)
                    .row(i)
                    .column(j)
                    .build();
            cells[i][j] = c;

        }else{
            throw  new RuntimeException("Invalid Move");
        }

    }

}
