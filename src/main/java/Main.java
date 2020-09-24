import models.Board;
import models.Game;
import models.Player;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("O");
        Game game = new Game(player1,player2,board);

        game.play(0,0);
        game.play(1,1);
        game.play(2,2);
        game.getBoard().draw();
    }
}
