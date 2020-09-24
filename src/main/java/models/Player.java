package models;

import lombok.Getter;

@Getter
public class Player {
    private final String sign;
    public int moveCount;

    public Player(String sign) {
        this.sign = sign;
    }

    public void increaseMoveCount() {
        moveCount++;
    }
}
