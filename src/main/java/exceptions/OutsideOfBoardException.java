package exceptions;

public class OutsideOfBoardException extends RuntimeException {
    public OutsideOfBoardException(String message){
        super(message);
    }
}

