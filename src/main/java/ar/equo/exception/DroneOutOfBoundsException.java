package ar.equo.exception;

public class DroneOutOfBoundsException extends Throwable {

    public DroneOutOfBoundsException(String direction) {
        super("The drone has exceeded the boundary towards the " + direction);
    }
}