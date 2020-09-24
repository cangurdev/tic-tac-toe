package controllers;

import models.Game;

public class DiagonalController implements WinnerController {

    @Override
    public String winnerCheck(Game game) {
        if (!game.getBoard().getPosition(0, 0).equals(" ") && game.getBoard().getPosition(0, 0).equals(game.getBoard().getPosition(1, 1)) && game.getBoard().getPosition(1, 1).equals(game.getBoard().getPosition(2, 2))) {
            return game.getBoard().getPosition(0, 0);
        }
        if (!game.getBoard().getPosition(0, 2).equals(" ") && game.getBoard().getPosition(0, 2).equals(game.getBoard().getPosition(1, 1)) && game.getBoard().getPosition(1, 1).equals(game.getBoard().getPosition(2, 0))) {
            return game.getBoard().getPosition(0, 0);
        }
        return null;
    }
}
