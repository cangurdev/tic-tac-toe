package exceptions;

public class NonEmptyCellException extends RuntimeException{

    public NonEmptyCellException(String message){
        super(message);
    }
}
