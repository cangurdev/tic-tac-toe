package controllers;

import models.Game;

public class TieController{
    public String tieCheck(Game game) {
        if (game.getPlayer1().getMoveCount() + game.getPlayer2().getMoveCount() >= 9) {
            return "Game is tie";
        }
        return null;
    }


}
