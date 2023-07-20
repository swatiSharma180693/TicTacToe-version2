import models.Board;
import models.Game;
import models.HumanPlayer;
import models.Players;
import models.enums.GameStatus;
import models.enums.PlayerType;
import models.enums.SymbolType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board(3);
        HumanPlayer p1 = createHumanPlayer("abc", "abc@gmail.com", SymbolType.O, PlayerType.Human);
        HumanPlayer p2 = createHumanPlayer("abcd", "abcd@gmail.com", SymbolType.X, PlayerType.Human);
        ArrayList<Players> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        Game game = Game.builder()
                        .board(board)
                        .players(players)
                        .gameStatus(GameStatus.START)
                        .build();

        int i = 1;

        while(game.getGameStatus().equals(GameStatus.START)){

            game.getBoard().displayBoard();


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String name1 = null;
            String name2 = null;
            try {
                name1 = reader.readLine();
                name2 = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Printing the read line
            System.out.println(name1 + name2);


            int rowNumber = Integer.parseInt(name1);
            int columnNumber = Integer.parseInt(name2);


            if(i%2 == 0){
                p1.makeMove(board, rowNumber, columnNumber);

            }else{
                p2.makeMove(board, rowNumber, columnNumber);
            }

            game.getBoard().displayBoard();
            game.checkIfPlayerWon();
            System.out.println(game.getGameStatus());
            i++;

        }
    }
    private static HumanPlayer createHumanPlayer(String name, String email, SymbolType symbolType, PlayerType playerType){
        HumanPlayer humanPlayer = HumanPlayer.builder()
                .name(name)
                .email(email)
                .symbolType(symbolType)
                .playerType(playerType)
                .build();
        return humanPlayer;
    }
}
