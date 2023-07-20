package models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import models.enums.DifficultyLevel;
import strategies.botMove.MoveStrategyForBot;

@SuperBuilder(toBuilder = true)
public class BotPlayer extends Players{

    DifficultyLevel difficultyLevel;

    MoveStrategyForBot moveStrategyForBot;

    @Override
    public void makeMove(Board board, int i, int j) {
        moveStrategyForBot.BotMAkeMove();
    }

}
