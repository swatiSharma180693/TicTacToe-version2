package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import models.enums.GridStatus;
import models.enums.SymbolType;

@Builder
@Getter
@Setter

public class Cell {
    int row;
    int column;
    SymbolType symbolType;
    GridStatus gridStatus;
}
