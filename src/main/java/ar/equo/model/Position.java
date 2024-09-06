package ar.equo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {

    private int x;
    private int y;
    private char orientation; // 'N', 'E', 'S', 'W'

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return this.x == position.x &&
                this.y == position.y &&
                this.orientation == position.orientation;
    }
}

