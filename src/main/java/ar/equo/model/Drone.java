package ar.equo.model;

import ar.equo.exception.DroneOutOfBoundsException;
import ar.equo.exception.IllegalArgumentException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Drone {

    private Position position;
    private char[] instructions;

    public Position explore(Plateau plateau) throws IllegalArgumentException, DroneOutOfBoundsException {
        for (char instruction : instructions) {
            executeInstruction(plateau, instruction);
        }
        return position;
    }

    private void executeInstruction(Plateau plateau, char instruction) throws IllegalArgumentException, DroneOutOfBoundsException {
        switch (instruction) {
            case 'L':
                rotateLeft();
                break;
            case 'R':
                rotateRight();
                break;
            case 'M':
                moveForward(plateau);
                break;
            default:
                throw new IllegalArgumentException(instruction);
        }
    }

    private void rotateLeft() {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('W');
                break;
            case 'W':
                position.setOrientation('S');
                break;
            case 'S':
                position.setOrientation('E');
                break;
            case 'E':
                position.setOrientation('N');
                break;
        }
    }

    private void rotateRight() {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('E');
                break;
            case 'E':
                position.setOrientation('S');
                break;
            case 'S':
                position.setOrientation('W');
                break;
            case 'W':
                position.setOrientation('N');
                break;
        }
    }

    private void moveForward(Plateau plateau) throws DroneOutOfBoundsException {
        switch (position.getOrientation()) {
            case 'N':
                if (position.getY() < plateau.getMaxY()) {
                    position.setY(position.getY() + 1);
                }else{
                    throw new DroneOutOfBoundsException("North");
                }
                break;
            case 'E':
                if (position.getX() < plateau.getMaxX()) {
                    position.setX(position.getX() + 1);
                }else{
                    throw new DroneOutOfBoundsException("East");
                }
                break;
            case 'S':
                if (position.getY() > 0) {
                    position.setY(position.getY() - 1);
                }else{
                    throw new DroneOutOfBoundsException("South");
                }
                break;
            case 'W':
                if (position.getX() > 0) {
                    position.setX(position.getX() - 1);
                }else{
                    throw new DroneOutOfBoundsException("West");
                }
                break;
        }
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
