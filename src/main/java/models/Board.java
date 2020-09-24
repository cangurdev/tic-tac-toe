package models;

public class Board {

    private String[][] board = new String[][]{
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}};

    public String getPosition(int i, int j) {
        return board[i][j];
    }

    public void setIndex(int i, int j, String sign) {
        this.board[i][j] = sign;
    }

    public void draw() {
        System.out.println(String.format(" %s | %s | %s", board[0][0], board[0][1], board[0][2]));
        System.out.println("--- --- ---");
        System.out.println(String.format(" %s | %s | %s", board[1][0], board[1][1], board[1][2]));
        System.out.println("--- --- ---");
        System.out.println(String.format(" %s | %s | %s", board[2][0], board[2][1], board[2][2]));
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }
}