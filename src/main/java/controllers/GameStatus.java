package controllers;

import models.Game;

public class GameStatus {
    ColumnController columnController = new ColumnController();
    DiagonalController diagonalController = new DiagonalController();
    RowsController rowsController = new RowsController();
    TieController tieController = new TieController();

    public String checkStatus(Game game) {
        if (columnController.winnerCheck(game) != null)
            return String.format("%s is winner", columnController.winnerCheck(game));
        if (diagonalController.winnerCheck(game) != null)
            return String.format("%s is winner", diagonalController.winnerCheck(game));
        if (rowsController.winnerCheck(game) != null)
            return String.format("%s is winner", rowsController.winnerCheck(game));
        if (tieController.tieCheck(game) != null)
            return tieController.tieCheck(game);
        return null;
    }
}
