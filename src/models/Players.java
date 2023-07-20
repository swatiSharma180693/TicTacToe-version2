package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import models.enums.PlayerType;
import models.enums.SymbolType;


@SuperBuilder(toBuilder = true)
@Getter
@Setter
public abstract class Players {
    SymbolType symbolType;
    PlayerType playerType;
    public abstract void makeMove(Board board, int i, int j);
}

