package controllers;

import models.Game;

public class ColumnController implements WinnerController {
    @Override
    public String winnerCheck(Game game) {
        for (int i = 0; i < 3; i++) {
            if (!game.getBoard().getPosition(0, i).equals(" ")&&game.getBoard().getPosition(0, i).equals(game.getBoard().getPosition(1, i)) && game.getBoard().getPosition(1, i).equals(game.getBoard().getPosition(2, i))) {
                return game.getBoard().getPosition(0, i);
            }
        }
        return null;
    }
}
