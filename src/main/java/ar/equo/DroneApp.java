package ar.equo;

import ar.equo.exception.DroneOutOfBoundsException;
import ar.equo.exception.IllegalArgumentException;
import ar.equo.model.Drone;
import ar.equo.model.Plateau;
import ar.equo.model.Position;
import ar.equo.service.DroneExploration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DroneApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the upper-right coordinates of the plateau (e.g., 5 5):");
        int xMax = scanner.nextInt();
        int yMax = scanner.nextInt();
        Plateau plateau = new Plateau(xMax, yMax);

        List<Drone> drones = new ArrayList<>();

        System.out.println("Enter the number of drones:");
        int numDrones = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int i = 0; i < numDrones; i++) {
            System.out.println("Enter position for drone " + (i + 1) + " (e.g., 1 2 N):");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char orientation = scanner.next().charAt(0);
            scanner.nextLine();  // Consume the newline

            System.out.println("Enter instructions for drone " + (i + 1) + " (e.g., LMLMLMLMM):");
            String instructions = scanner.nextLine().toUpperCase().trim().replaceAll("[^LRM]", "");

            Position position = new Position(x, y, orientation);
            Drone drone = new Drone(position, instructions.toCharArray());
            drones.add(drone);
        }

        DroneExploration droneExploration = new DroneExploration(plateau, drones);

        try {
            List<Position> finalPositions = droneExploration.run();
            int i = 1;
            for (Position position : finalPositions) {
                System.out.println("Final position for drone " + i + " : " + position);
                i++;
            }
        } catch (IllegalArgumentException | DroneOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
