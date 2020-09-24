import controllers.GameStatus;
import exceptions.NonEmptyCellException;
import exceptions.OutsideOfBoardException;
import models.Board;
import models.Game;
import models.Player;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class TicTacToeTests {
    Board board = new Board();
    Player player1 = new Player("X");
    Player player2 = new Player("O");
    Game sut = new Game(player1, player2, board);

    @AfterEach
    public void clearBoard() {
        sut.getBoard().clearBoard();
    }

    @Test
    public void it_should_return_x_in_cell_when_x_played() {
        //Arrange
        //Act
        sut.play(0, 0);
        sut.play(1, 0);
        //Assert
        assertThat(sut.getBoard().getPosition(0, 0)).isEqualTo("X");
    }

    @Test
    public void it_should_return_o_in_cell_when_o_played() {
        //Arrange
        //Act
        sut.play(0, 2);
        sut.play(1, 2);
        //Assert
        assertThat(sut.getBoard().getPosition(1, 2)).isEqualTo("O");
    }

    @Test
    public void it_should_return_OutsideOfBoardException_when_played_on_outside_of_the_board() {
        //Arrange
        //Act
        Throwable throwable = catchThrowable(() -> sut.play(1, 3));
        //Assert
        assertThat(throwable).isInstanceOf(OutsideOfBoardException.class).hasMessage("Moves cannot be made outside of the board!");
    }

    @Test
    public void it_should_return_winner_when_all_cells_in_column_are_equals() {
        //Arrange
        GameStatus gameStatus = new GameStatus();
        //Act
        sut.play(0, 0);
        sut.play(1, 1);
        sut.play(1, 0);
        sut.play(2, 2);
        sut.play(2, 0);
        String result = gameStatus.checkStatus(sut);
        //Assert
        assertThat(result).isEqualTo("X is winner");
    }

    @Test
    public void it_should_return_winner_when_all_cells_in_row_are_equals() {
        //Arrange
        GameStatus gameStatus = new GameStatus();
        //Act
        sut.play(1, 1);
        sut.play(0, 0);
        sut.play(2, 2);
        sut.play(0, 1);
        sut.play(1, 2);
        sut.play(0, 2);
        String result = gameStatus.checkStatus(sut);

        //Assert
        assertThat(result).isEqualTo("O is winner");
    }

    @Test
    public void it_should_return_winner_when_all_cells_in_diagonal_are_equals() {
        //Arrange
        GameStatus gameStatus = new GameStatus();
        //Act
        sut.play(0, 0);
        sut.play(0, 2);
        sut.play(1, 1);
        sut.play(2, 1);
        sut.play(2, 2);
        String result = gameStatus.checkStatus(sut);

        //Assert
        assertThat(result).isEqualTo("X is winner");
    }

    @Test
    public void it_should_return_NonEmptyCellException_when_played_cell_is_not_empty() {
        //Arrange
        //Act
        sut.play(1, 0);
        Throwable throwable = catchThrowable(() -> sut.play(1, 0));
        //Assert
        assertThat(throwable).isInstanceOf(NonEmptyCellException.class).hasMessage("Cannot played on non empty cell");
    }

    @Test
    public void it_should_return_game_is_tie_when_all_cells_are_full_however_no_winner() {
        //Arrange
        GameStatus gameStatus = new GameStatus();
        //Act
        sut.play(0, 0);
        sut.play(0, 2);
        sut.play(0, 1);

        sut.play(1, 0);
        sut.play(1, 2);
        sut.play(1, 1);

        sut.play(2, 0);
        sut.play(2, 2);
        sut.play(2, 1);

        String result = gameStatus.checkStatus(sut);
        //Assert
        assertThat(result).isEqualTo("Game is tie");
    }
    @Test
    public void it_should_return_null_when_game_is_not_finished() {
        //Arrange
        GameStatus gameStatus = new GameStatus();
        //Act
        sut.play(0, 0);
        sut.play(0, 2);
        sut.play(1, 1);
        sut.play(2, 1);
        String result = gameStatus.checkStatus(sut);

        //Assert
        assertThat(result).isEqualTo(null);
    }
}
