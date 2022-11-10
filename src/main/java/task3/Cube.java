package task3;

import java.util.Objects;

public class Cube implements Shape {
    private final double side;
    private final double volume;


    public Cube(double side) {
        if (side <= 0) throw new IllegalArgumentException("value can't be less than or equals 0");
        this.side = side;
        this.volume = calculateVolume();
    }

    @Override
    public String toString() {
        return "Cube{" +
                "Volume=" + calculateVolume() +
                '}';
    }

    @Override
    public double calculateVolume() {
        double volumeOfCube = Math.pow(side, 3);
        if (volumeOfCube == Double.POSITIVE_INFINITY) {
            throw new IllegalArgumentException("too big value for correct calculate this operation");
        } else {
            return volumeOfCube;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.side, this.side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.side);
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
