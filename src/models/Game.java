package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.enums.GameStatus;
import strategies.win.CheckByColumn;
import strategies.win.CheckByDiagonal;
import strategies.win.CheckByRow;
import strategies.win.CheckIfWon;

import java.util.ArrayList;

@Builder
@Getter
@Setter
public class Game {
    Board board;
    ArrayList<Players> players = new ArrayList<>();
    GameStatus gameStatus;
    public boolean checkIfPlayerWon(){
        CheckByColumn checkByColumn = new CheckByColumn();
        CheckByRow checkByRow = new CheckByRow();
        CheckByDiagonal checkByDiagonal = new CheckByDiagonal();
        if(checkByColumn.check(board) || checkByRow.check(board) || checkByDiagonal.check(board)){
            this.gameStatus = GameStatus.END;
            return true;
        }
        System.out.println("GAME CONTINUES");
        return false;
    }
}
