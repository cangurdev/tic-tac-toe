package controllers;

import models.Game;

public class RowsController implements WinnerController {

    @Override
    public String winnerCheck(Game game) {
        for (int i = 0; i < 3; i++) {
            if (!game.getBoard().getPosition(i, 0).equals(" ") && game.getBoard().getPosition(i, 0).equals(game.getBoard().getPosition(i, 1)) && game.getBoard().getPosition(i, 1).equals(game.getBoard().getPosition(i, 2))) {
                return game.getBoard().getPosition(i, 0);
            }
        }
        return null;
    }

}
