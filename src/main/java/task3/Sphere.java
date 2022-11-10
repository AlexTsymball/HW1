package task3;

import java.util.Objects;

public class Sphere implements Shape {
    private final double radius;
    private final double volume;

    public Sphere(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("value can't be less than or equals 0");
        this.radius = radius;
        this.volume = calculateVolume();
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "Volume=" + calculateVolume() +
                '}';
    }

    @Override
    public double calculateVolume() {

        double volumeOfSphere = (4 / 3.0) * Math.PI * Math.pow(radius, 3);
        if (volumeOfSphere == Double.POSITIVE_INFINITY) {
            throw new IllegalArgumentException("too big value for correct calculate this operation");
        } else {
            return volumeOfSphere;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
