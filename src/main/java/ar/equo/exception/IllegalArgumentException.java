package ar.equo.exception;

public class IllegalArgumentException extends Throwable {

    public IllegalArgumentException(char instruction) {
        super("Invalid instruction: " + instruction);
    }
}
