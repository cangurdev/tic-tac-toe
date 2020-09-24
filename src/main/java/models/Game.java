package models;

import exceptions.NonEmptyCellException;
import exceptions.OutsideOfBoardException;
import lombok.Getter;

@Getter
public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }

    public void play(int i, int j) {
        if (i < 0 || i > 2 || j < 0 || j > 2)
            throw new OutsideOfBoardException("Moves cannot be made outside of the board!");
        if (!board.getPosition(i, j).equals(" "))
            throw new NonEmptyCellException("Cannot played on non empty cell");

        if (player1.getMoveCount() == player2.getMoveCount()) {
            board.setIndex(i, j, player1.getSign());
            player1.increaseMoveCount();
        } else if (player2.getMoveCount() < player1.getMoveCount()) {
            board.setIndex(i, j, player2.getSign());
            player2.increaseMoveCount();
        }
    }
}
