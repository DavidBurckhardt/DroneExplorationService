package ar.equo.service;

import ar.equo.exception.DroneOutOfBoundsException;
import ar.equo.exception.IllegalArgumentException;
import ar.equo.model.Drone;
import ar.equo.model.Plateau;
import ar.equo.model.Position;

import java.util.ArrayList;
import java.util.List;

public class DroneExploration {

    private final Plateau plateau;
    private final List<Drone> drones;

    public DroneExploration(Plateau plateau, List<Drone> drones) {
        this.plateau = plateau;
        this.drones = drones;
    }

    public List<Position> run() throws IllegalArgumentException, DroneOutOfBoundsException {
        List<Position> finalPositions = new ArrayList<>();
        for (Drone drone : drones) {
            finalPositions.add(drone.explore(plateau));
        }
        return finalPositions;
    }
}
