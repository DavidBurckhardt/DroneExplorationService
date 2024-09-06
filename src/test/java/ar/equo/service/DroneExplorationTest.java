package ar.equo.service;

import ar.equo.exception.DroneOutOfBoundsException;
import ar.equo.exception.IllegalArgumentException;
import ar.equo.model.Drone;
import ar.equo.model.Plateau;
import ar.equo.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DroneExplorationTest {

    private Plateau plateau;
    private DroneExploration droneExploration;
    private Drone drone1;
    private Drone drone2;

    @BeforeEach
    public void setUp() {

        plateau = new Plateau(5, 5);

        Position position1 = new Position(1, 2, 'N');
        char[] instructions1 = {'L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M'};
        drone1 = new Drone(position1, instructions1);

        Position position2 = new Position(3, 3, 'E');
        char[] instructions2 = {'M', 'M', 'R', 'M', 'M', 'R', 'M', 'R', 'R', 'M'};
        drone2 = new Drone(position2, instructions2);

        droneExploration = new DroneExploration(plateau, Arrays.asList(drone1, drone2));
    }

    @Test
    public void testDroneExplorationOK() {
        try {
            List<Position> finalPositions = droneExploration.run();

            assertEquals(new Position(1, 3, 'N'), finalPositions.get(0), "Drone 1 final position is incorrect.");
            assertEquals(new Position(5, 1, 'E'), finalPositions.get(1), "Drone 2 final position is incorrect.");
        } catch (IllegalArgumentException | DroneOutOfBoundsException e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testDroneOutOfBoundsException() {

        Position position = new Position(5, 5, 'N');
        char[] instructions = {'M', 'M'};
        Drone drone = new Drone(position, instructions);

        DroneExploration droneExploration = new DroneExploration(plateau, Arrays.asList(drone));

        assertThrows(DroneOutOfBoundsException.class, droneExploration::run, "Expected DroneOutOfBoundsException to be thrown");
    }

    @Test
    public void testIllegalArgumentException() {

        Position position = new Position(1, 2, 'N');
        char[] instructions = {'X', 'M', 'L'};
        Drone drone = new Drone(position, instructions);

        DroneExploration droneExploration = new DroneExploration(plateau, Arrays.asList(drone));

        assertThrows(IllegalArgumentException.class, droneExploration::run, "Expected IllegalArgumentException to be thrown");
    }

    @Test
    public void testComplexScenario() {

        Plateau bigPlateau = new Plateau(10, 10);

        Position position1 = new Position(0, 0, 'N');
        char[] instructions1 = {'M', 'M', 'R', 'M', 'M', 'R', 'M', 'M', 'R', 'M', 'M', 'R', 'M', 'M', 'M', 'M', 'L', 'L', 'M', 'M'};
        Drone drone1 = new Drone(position1, instructions1);

        Position position2 = new Position(9, 9, 'S');
        char[] instructions2 = {'L', 'L', 'L', 'M', 'M', 'M', 'R', 'R', 'M', 'M', 'M', 'L', 'L', 'L', 'M', 'R', 'R', 'R', 'M', 'R', 'M', 'M'};
        Drone drone2 = new Drone(position2, instructions2);

        Position position3 = new Position(5, 5, 'E');
        char[] instructions3 = {'M', 'M', 'M', 'M', 'M', 'L', 'M', 'M', 'L', 'M', 'M', 'L', 'M', 'R', 'M', 'M', 'M', 'M', 'R', 'R'};
        Drone drone3 = new Drone(position3, instructions3);

        List<Drone> drones = Arrays.asList(drone1,drone2,drone3);

        DroneExploration droneExploration = new DroneExploration(bigPlateau, drones);

        try {
            List<Position> finalPositions = droneExploration.run();

            assertEquals(new Position(0, 2, 'S'), finalPositions.get(0), "Drone 1 final position is incorrect.");
            assertEquals(new Position(10, 6, 'S'), finalPositions.get(1), "Drone 2 final position is incorrect.");
            assertEquals(new Position(4, 6, 'E'), finalPositions.get(2), "Drone 3 final position is incorrect.");
        } catch (IllegalArgumentException | DroneOutOfBoundsException e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }
}
